package com.ensi.ilsi.myClinic.repository;

import com.ensi.ilsi.myClinic.domain.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
