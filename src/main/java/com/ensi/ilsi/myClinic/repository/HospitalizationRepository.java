package com.ensi.ilsi.myClinic.repository;

import com.ensi.ilsi.myClinic.domain.Hospitalization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalizationRepository extends JpaRepository<Hospitalization, Long> {
}
