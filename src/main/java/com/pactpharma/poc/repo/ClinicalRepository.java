package com.pactpharma.poc.repo;

import com.pactpharma.poc.model.Clinical2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicalRepository extends JpaRepository<Clinical2,Long> {
}
