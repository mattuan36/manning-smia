package com.optimagrowth.license.controller;

import com.optimagrowth.license.data.OrganizationRepository;
import com.optimagrowth.license.model.Organization;
import com.optimagrowth.license.model.Person;
import com.optimagrowth.license.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="v1/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping(value="/{organizationId}",method = RequestMethod.GET)
    public ResponseEntity<Organization> getOrganization(@PathVariable("organizationId") long organizationId) {
        return ResponseEntity.ok(organizationService.getOrganization(organizationId));
    }

    @PostMapping
    public ResponseEntity<String> createOrganization(@RequestBody Organization organization) {
        return ResponseEntity.ok(organizationService.createOrganization(organization));
    }

    @DeleteMapping(value="/{organizationId}")
    public ResponseEntity<String> deletePerson(@PathVariable("organizationId") long organizationId) {
        return ResponseEntity.ok(organizationService.deleteOrganization(organizationId));
    }
}
