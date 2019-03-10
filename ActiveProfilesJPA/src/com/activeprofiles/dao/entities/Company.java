package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@Table(name="company")
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMPANY_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMPANY_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="company_name", nullable=false, length=150)
	private String companyName;

	@Column(name="company_url", length=1000)
	private String companyUrl;

	@Temporal(TemporalType.DATE)
	@Column(name="establishment_date")
	private Date establishmentDate;

	@Column(name="profile_description", nullable=false, length=150)
	private String profileDescription;

	//bi-directional many-to-one association to BusinessStream
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="business_stream_id", nullable=false)
	private BusinessStream businessStream;

	//bi-directional many-to-one association to CompanyDetail
	@OneToMany(mappedBy="company")
	private List<CompanyDetail> companyDetails;

	//bi-directional many-to-one association to JobOpening
	@OneToMany(mappedBy="company")
	private List<JobOpening> jobOpenings;

	public Company() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyUrl() {
		return this.companyUrl;
	}

	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}

	public Date getEstablishmentDate() {
		return this.establishmentDate;
	}

	public void setEstablishmentDate(Date establishmentDate) {
		this.establishmentDate = establishmentDate;
	}

	public String getProfileDescription() {
		return this.profileDescription;
	}

	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}

	public BusinessStream getBusinessStream() {
		return this.businessStream;
	}

	public void setBusinessStream(BusinessStream businessStream) {
		this.businessStream = businessStream;
	}

	public List<CompanyDetail> getCompanyDetails() {
		return this.companyDetails;
	}

	public void setCompanyDetails(List<CompanyDetail> companyDetails) {
		this.companyDetails = companyDetails;
	}

	public CompanyDetail addCompanyDetail(CompanyDetail companyDetail) {
		getCompanyDetails().add(companyDetail);
		companyDetail.setCompany(this);

		return companyDetail;
	}

	public CompanyDetail removeCompanyDetail(CompanyDetail companyDetail) {
		getCompanyDetails().remove(companyDetail);
		companyDetail.setCompany(null);

		return companyDetail;
	}

	public List<JobOpening> getJobOpenings() {
		return this.jobOpenings;
	}

	public void setJobOpenings(List<JobOpening> jobOpenings) {
		this.jobOpenings = jobOpenings;
	}

	public JobOpening addJobOpening(JobOpening jobOpening) {
		getJobOpenings().add(jobOpening);
		jobOpening.setCompany(this);

		return jobOpening;
	}

	public JobOpening removeJobOpening(JobOpening jobOpening) {
		getJobOpenings().remove(jobOpening);
		jobOpening.setCompany(null);

		return jobOpening;
	}

}