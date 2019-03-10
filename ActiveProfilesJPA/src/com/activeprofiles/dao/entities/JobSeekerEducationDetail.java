package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the job_seeker_education_detail database table.
 * 
 */
@Entity
@Table(name="job_seeker_education_detail")
@NamedQuery(name="JobSeekerEducationDetail.findAll", query="SELECT j FROM JobSeekerEducationDetail j")
public class JobSeekerEducationDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="JOB_SEEKER_EDUCATION_DETAIL_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JOB_SEEKER_EDUCATION_DETAIL_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="certificate_degree_name", nullable=false, length=150)
	private String certificateDegreeName;

	@Temporal(TemporalType.DATE)
	@Column(name="completion_date")
	private Date completionDate;

	@Column(name="institute_university_name", nullable=false, length=50)
	private String instituteUniversityName;

	@Column(name="is_current_job")
	private Boolean isCurrentJob;

	@Column(name="percentage_cpga", length=3)
	private String percentageCpga;

	@Column(name="start_date", nullable=false, length=15)
	private String startDate;

	//bi-directional many-to-one association to UserAccount
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usr_acc_id", nullable=false)
	private UserAccount userAccount;

	public JobSeekerEducationDetail() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCertificateDegreeName() {
		return this.certificateDegreeName;
	}

	public void setCertificateDegreeName(String certificateDegreeName) {
		this.certificateDegreeName = certificateDegreeName;
	}

	public Date getCompletionDate() {
		return this.completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public String getInstituteUniversityName() {
		return this.instituteUniversityName;
	}

	public void setInstituteUniversityName(String instituteUniversityName) {
		this.instituteUniversityName = instituteUniversityName;
	}

	public Boolean getIsCurrentJob() {
		return this.isCurrentJob;
	}

	public void setIsCurrentJob(Boolean isCurrentJob) {
		this.isCurrentJob = isCurrentJob;
	}

	public String getPercentageCpga() {
		return this.percentageCpga;
	}

	public void setPercentageCpga(String percentageCpga) {
		this.percentageCpga = percentageCpga;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public UserAccount getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

}