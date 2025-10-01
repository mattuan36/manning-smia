package com.optimagrowth.license.service;

import com.optimagrowth.license.data.OrganizationRepository;
import com.optimagrowth.license.model.Organization;
import com.optimagrowth.license.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public String createOrganization(Organization organization) {
        organizationRepository.save(organization);
        return organization.toString();
    }

    public String deleteOrganization(long organizationId) {
        organizationRepository.deleteById(organizationId);
        return "person " + organizationId + " deleted";
    }

    public Organization getOrganization(long organizationId) {
        return organizationRepository.getOne(organizationId);
    }

    public List<Organization> list() {
        return organizationRepository.findAll();
    }

    public <T extends Organization> void saveOrg(T organization) {
        organizationRepository.save(organization);
    }

}
