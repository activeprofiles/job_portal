package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the job_seeker_eperience_detail database table.
 * 
 */
@Entity
@Table(name="job_seeker_eperience_detail")
@NamedQuery(name="JobSeekerEperienceDetail.findAll", query="SELECT j FROM JobSeekerEperienceDetail j")
public class JobSeekerEperienceDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="JOB_SEEKER_EPERIENCE_DETAIL_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JOB_SEEKER_EPERIENCE_DETAIL_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="company_name", nullable=false, length=30)
	private String companyName;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	@Column(name="is_current_job")
	private Boolean isCurrentJob;

	@Column(name="job_city", length=15)
	private String jobCity;

	@Column(name="job_country", length=15)
	private String jobCountry;

	@Column(name="job_state", length=15)
	private String jobState;

	@Column(name="job_title", nullable=false, length=30)
	private String jobTitle;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date", nullable=false)
	private Date startDate;

	//bi-directional many-to-one association to UserAccount
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usr_acc_id", nullable=false)
	private UserAccount userAccount;

	//bi-directional many-to-one association to JobSeekerSkillsOther
	@OneToMany(mappedBy="jobSeekerEperienceDetail")
	private List<JobSeekerSkillsOther> jobSeekerSkillsOthers;

	public JobSeekerEperienceDetail() {
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

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Boolean getIsCurrentJob() {
		return this.isCurrentJob;
	}

	public void setIsCurrentJob(Boolean isCurrentJob) {
		this.isCurrentJob = isCurrentJob;
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

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public UserAccount getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public List<JobSeekerSkillsOther> getJobSeekerSkillsOthers() {
		return this.jobSeekerSkillsOthers;
	}

	public void setJobSeekerSkillsOthers(List<JobSeekerSkillsOther> jobSeekerSkillsOthers) {
		this.jobSeekerSkillsOthers = jobSeekerSkillsOthers;
	}

	public JobSeekerSkillsOther addJobSeekerSkillsOther(JobSeekerSkillsOther jobSeekerSkillsOther) {
		getJobSeekerSkillsOthers().add(jobSeekerSkillsOther);
		jobSeekerSkillsOther.setJobSeekerEperienceDetail(this);

		return jobSeekerSkillsOther;
	}

	public JobSeekerSkillsOther removeJobSeekerSkillsOther(JobSeekerSkillsOther jobSeekerSkillsOther) {
		getJobSeekerSkillsOthers().remove(jobSeekerSkillsOther);
		jobSeekerSkillsOther.setJobSeekerEperienceDetail(null);

		return jobSeekerSkillsOther;
	}

}