package com.smarthack.sudo.repository;

import com.smarthack.sudo.domain.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Pharmacy entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, String>, JpaSpecificationExecutor<Pharmacy> {
}
