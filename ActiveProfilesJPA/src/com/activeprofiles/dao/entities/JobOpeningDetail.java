package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the job_opening_details database table.
 * 
 */
@Entity
@Table(name="job_opening_details")
@NamedQuery(name="JobOpeningDetail.findAll", query="SELECT j FROM JobOpeningDetail j")
public class JobOpeningDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="JOB_OPENING_DETAILS_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JOB_OPENING_DETAILS_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="is_active", nullable=false)
	private Boolean isActive;

	@Column(name="job_address1", length=250)
	private String jobAddress1;

	@Column(name="job_address2", length=250)
	private String jobAddress2;

	@Column(name="job_city", length=15)
	private String jobCity;

	@Column(name="job_country", length=15)
	private String jobCountry;

	@Column(name="job_state", length=15)
	private String jobState;

	@Column(name="zip_code")
	private Integer zipCode;

	//bi-directional many-to-one association to JobOpening
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="job_post_id", nullable=false)
	private JobOpening jobOpening;

	public JobOpeningDetail() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getJobAddress1() {
		return this.jobAddress1;
	}

	public void setJobAddress1(String jobAddress1) {
		this.jobAddress1 = jobAddress1;
	}

	public String getJobAddress2() {
		return this.jobAddress2;
	}

	public void setJobAddress2(String jobAddress2) {
		this.jobAddress2 = jobAddress2;
	}

	public String getJobCity() {
		return this.jobCity;
	}

	public void setJobCity(String jobCity) {
		this.jobCity = jobCity;
	}

	public String getJobCountry() {
		return this.jobCountry;
	}

	public void setJobCountry(String jobCountry) {
		this.jobCountry = jobCountry;
	}

	public String getJobState() {
		return this.jobState;
	}

	public void setJobState(String jobState) {
		this.jobState = jobState;
	}

	public Integer getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public JobOpening getJobOpening() {
		return this.jobOpening;
	}

	public void setJobOpening(JobOpening jobOpening) {
		this.jobOpening = jobOpening;
	}

}