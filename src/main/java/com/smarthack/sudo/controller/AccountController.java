package com.smarthack.sudo.controller;

import com.smarthack.sudo.domain.User;
import com.smarthack.sudo.dto.UserDto;
import com.smarthack.sudo.dto.vm.ManagedUserVM;
import com.smarthack.sudo.excteptions.errors.InvalidPasswordException;
import com.smarthack.sudo.repository.UserRepository;
import com.smarthack.sudo.security.SecurityUtils;
import com.smarthack.sudo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

/**
 * REST controller for managing the current user's account.
 */
@RestController
@RequestMapping
public class AccountController {

    private static class AccountResourceException extends RuntimeException {
        private AccountResourceException(String message) {
            super(message);
        }
    }

    private final Logger log = LoggerFactory.getLogger(AccountController.class);

    private final UserRepository userRepository;

    private final UserService userService;

    public AccountController(UserRepository userRepository, UserService userService) {

        this.userRepository = userRepository;
        this.userService = userService;
    }

    /**
     * {@code POST  /register} : register the user.
     *
     * @param managedUserVM the managed user View Model.
     * @throws InvalidPasswordException  {@code 400 (Bad Request)} if the password is incorrect.
     */
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody ManagedUserVM managedUserVM) {
        if (!checkPasswordLength(managedUserVM.getPassword())) {
            throw new InvalidPasswordException();
        }
        UserDto user = userService.registerUser(managedUserVM, managedUserVM.getPassword());
    }

//    /**
//     * {@code GET  /activate} : activate the registered user.
//     *
//     * @param key the activation key.
//     * @throws RuntimeException {@code 500 (Internal Server Error)} if the user couldn't be activated.
//     */
//    @GetMapping("/activate")
//    public void activateAccount(@RequestParam(value = "key") String key) {
//        Optional<User> user = userService.activateRegistration(key);
//        if (!user.isPresent()) {
//            throw new AccountResourceException("No user was found for this activation key");
//        }
//    }

    /**
     * {@code GET  /authenticate} : check if the user is authenticated, and return its login.
     *
     * @param request the HTTP request.
     * @return the login if the user is authenticated.
     */
    @GetMapping("/authenticate")
    public String isAuthenticated(HttpServletRequest request) {
        log.debug("REST request to check if the current user is authenticated");
        return request.getRemoteUser();
    }

    private static boolean checkPasswordLength(String password) {
        return !StringUtils.isEmpty(password) &&
                password.length() >= ManagedUserVM.PASSWORD_MIN_LENGTH &&
                password.length() <= ManagedUserVM.PASSWORD_MAX_LENGTH;
    }
}
