package com.smarthack.sudo.prescriptions.api;

import com.smarthack.sudo.prescriptions.model.requests.MedicineSearchRequest;
import com.smarthack.sudo.prescriptions.model.requests.OrderRequest;
import com.smarthack.sudo.prescriptions.model.responses.MedicineSearchResponse;
import com.smarthack.sudo.prescriptions.model.responses.OrderResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home-pharma")
public interface HomePharmacyAPI {

    @PostMapping
    MedicineSearchResponse searchMedicine(@RequestBody MedicineSearchRequest medicineSearchRequest);

    @PostMapping("/order")
    OrderResponse orderMedicines(@RequestBody OrderRequest orderRequest);

}
