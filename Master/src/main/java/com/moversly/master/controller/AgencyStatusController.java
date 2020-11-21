package com.moversly.master.controller;

import com.moversly.master.domain.AgencyStatus;
import com.moversly.master.exception.ResourceNotFoundException;
import com.moversly.master.service.AgencyStatusService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api
@RequestMapping("agency-status")
public class AgencyStatusController {
    @Autowired
    private AgencyStatusService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<AgencyStatus> get() {
        return service.all();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public AgencyStatus getById(@PathVariable("id") Integer id) {
        return service.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @RequestMapping(value = "/status/{status}", method = RequestMethod.GET)
    public AgencyStatus getByStatus(@PathVariable("status") String status) {
        return service.findByStatus(status).orElseThrow(ResourceNotFoundException::new);
    }

    @RequestMapping(value = "/", method = {RequestMethod.PUT})
    public AgencyStatus create(@RequestBody AgencyStatus agencyStatus) {
        return service.createOrUpdate(agencyStatus);
    }
    @RequestMapping(value = "/", method = {RequestMethod.POST})
    public AgencyStatus update(@RequestBody AgencyStatus agencyStatus) {
        return service.createOrUpdate(agencyStatus);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
