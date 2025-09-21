package com.optimagrowth.license.service;

import java.util.Locale;
import java.util.Random;

import com.optimagrowth.license.data.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.optimagrowth.license.model.License;

@Service
public class LicenseService {
	
	@Autowired
	MessageSource messages;

	@Autowired
	LicenseRepository licenseRepository;

	public License getLicense(String licenseId, String organizationId){
//		License license = new License();
//		license.setId(new Random().nextInt(1000));
//		license.setLicenseId(licenseId);
//		license.setOrganizationId(organizationId);
//		license.setDescription("Software product");
//		license.setProductName("Ostock");
//		license.setLicenseType("full");

		return licenseRepository.findByLicenseId(licenseId);
	}

	public String createLicense(License license, String organizationId, Locale locale){
		String responseMessage = null;
		if(!StringUtils.isEmpty(license)) {
			license.setOrganizationId(organizationId);
			licenseRepository.save(license);
			responseMessage = String.format(messages.getMessage("license.create.message",null,locale), license.toString());
		}

		return responseMessage;
	}

	public String updateLicense(License license, String organizationId, Locale locale){
		String responseMessage = null;
		if(!StringUtils.isEmpty(license)) {
			License licenseToUpdate = licenseRepository.findByLicenseId(license.getLicenseId());
			licenseToUpdate.setOrganizationId(organizationId);
			responseMessage = String.format(messages.getMessage("license.update.message", null, locale), license.toString());
		}

		return responseMessage;
	}

	public String deleteLicense(String licenseId, String organizationId, Locale locale){
		String responseMessage = null;
		licenseRepository.delete(getLicense(licenseId, organizationId));
		responseMessage = String.format(messages.getMessage("license.delete.message", null, locale),licenseId, organizationId);
		return responseMessage;

	}
}
