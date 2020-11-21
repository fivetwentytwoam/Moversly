package com.moversly.master.service;

import com.moversly.master.domain.AgencyStatus;
import com.moversly.master.repository.AgencyStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyStatusService {
    @Autowired
    AgencyStatusRepository repo;
    public List<AgencyStatus> all() {
        return repo.findAll();
    }

    public Optional<AgencyStatus> findById(Integer id) {
        return repo.findById(id);
    }

    public Optional<AgencyStatus> findByStatus(String status) {
        return repo.findByStatus(status);
    }
    public AgencyStatus createOrUpdate(AgencyStatus agencyStatus) {
        return repo.save(agencyStatus);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
