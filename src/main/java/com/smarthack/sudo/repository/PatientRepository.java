package com.smarthack.sudo.repository;

import com.smarthack.sudo.domain.Patient;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Patient entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PatientRepository extends JpaRepository<Patient, String>, JpaSpecificationExecutor<Patient> {

    @EntityGraph(value = "Patient.doctor", type = EntityGraph.EntityGraphType.FETCH)
    List<Patient> findAllByDoctorCnp(String cnp);
}
