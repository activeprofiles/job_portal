package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the company_details database table.
 * 
 */
@Entity
@Table(name="company_details")
@NamedQuery(name="CompanyDetail.findAll", query="SELECT c FROM CompanyDetail c")
public class CompanyDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMPANY_DETAILS_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMPANY_DETAILS_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="company_url", length=1000)
	private String companyUrl;

	@Column(nullable=false, length=2147483647)
	private String logo;

	//bi-directional many-to-one association to Company
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="company_id", nullable=false)
	private Company company;

	public CompanyDetail() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyUrl() {
		return this.companyUrl;
	}

	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}