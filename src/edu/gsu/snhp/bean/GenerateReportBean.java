package edu.gsu.snhp.bean;

import java.io.File;
import java.sql.Date;

public class GenerateReportBean {


	
	private String Owner;
	private String AssetDescription;
	private String DateSurplusPU;
	private String OnOffCampus;
	private String BuildingName;
	private String WarrantyEndDate;
	private String PersonDepartment;
	private String WarrantyStartDate;
	
	
	public String getOwner() {
		return Owner;
	}
	public void setOwner(String owner) {
		Owner = owner;
	}

	public String getDateSurplusPU() {
		return DateSurplusPU;
	}
	public void setDateSurplusPU(String dateSurplusPU) {
		DateSurplusPU = dateSurplusPU;
	}
	public String getOnOffCampus() {
		return OnOffCampus;
	}
	public void setOnOffCampus(String onOffCampus) {
		OnOffCampus = onOffCampus;
	}
	public String getBuildingName() {
		return BuildingName;
	}
	public void setBuildingName(String buildingName) {
		BuildingName = buildingName;
	}
	public String getWarrantyEndDate() {
		return WarrantyEndDate;
	}
	public void setWarrantyEndDate(String warrantyEndDate) {
		WarrantyEndDate = warrantyEndDate;
	}
	public String getAssetDescription() {
		return AssetDescription;
	}
	public void setAssetDescription(String assetDescription) {
		AssetDescription = assetDescription;
	}
	public String getPersonDepartment() {
		return PersonDepartment;
	}
	public void setPersonDepartment(String personDepartment) {
		PersonDepartment = personDepartment;
	}
	public String getWarrantyStartDate() {
		return WarrantyStartDate;
	}
	public void setWarrantyStartDate(String warrantyStartDate) {
		WarrantyStartDate = warrantyStartDate;
	}
	
	
	
	
}

