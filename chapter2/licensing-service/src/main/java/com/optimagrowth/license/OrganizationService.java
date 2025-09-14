package com.optimagrowth.license;

import com.optimagrowth.license.data.OrganizationRepository;
import com.optimagrowth.license.models.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public List<Organization> list() {
        return organizationRepository.findAll();
    }

    public <T extends Organization> void saveOrg(T organization) {
        organizationRepository.save(organization);
    }

}