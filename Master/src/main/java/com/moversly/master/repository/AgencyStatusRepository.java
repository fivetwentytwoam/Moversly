package com.moversly.master.repository;

import com.moversly.master.domain.AgencyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.Optional;

public interface AgencyStatusRepository extends JpaRepository<AgencyStatus, Integer> {
    public Optional<AgencyStatus> findByStatus(String status);
}
