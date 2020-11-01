package com.smarthack.sudo.repository;

import com.smarthack.sudo.domain.OrderedMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the OrderedMedicine entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrderedMedicineRepository extends JpaRepository<OrderedMedicine, String>, JpaSpecificationExecutor<OrderedMedicine> {
}
