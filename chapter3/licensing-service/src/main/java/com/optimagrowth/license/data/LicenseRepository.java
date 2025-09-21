package com.optimagrowth.license.data;

import com.optimagrowth.license.model.License;
import org.springframework.data.repository.CrudRepository;

public interface LicenseRepository extends CrudRepository<License, Long> {
    License findByLicenseId(String licenseId);
}
