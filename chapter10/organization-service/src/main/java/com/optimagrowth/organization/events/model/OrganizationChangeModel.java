package com.optimagrowth.organization.events.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class OrganizationChangeModel {
	private String type;
	private String action;
	private String organizationId;
	private String correlationId;

	public OrganizationChangeModel(String type, String action, String organizationId, String correlationId) {
		super();
		this.type = type;
		this.action = action;
		this.organizationId = organizationId;
		this.correlationId = correlationId;
	}

	public String getType() {return type;}
	public String getAction() {return action;}
	public String getOrganizationId() {return organizationId;}
	public String getCorrelationId() {return correlationId;}

	public void setType(String type) {this.type = type;}
	public void setAction(String action) {this.action = action;}
	public void setOrganizationId(String organizationId) {this.organizationId = organizationId;}
	public void setCorrelationId(String correlationId) {this.correlationId = correlationId;}

	@Override
	public String toString() {
		return "OrganizationChangeModel(type=" + type + ", action=" + action + ", organizationId=" + organizationId + ", correlationId=" + correlationId + ")";
	}
}
