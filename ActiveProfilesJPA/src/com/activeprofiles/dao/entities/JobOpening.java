package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the job_opening database table.
 * 
 */
@Entity
@Table(name="job_opening")
@NamedQuery(name="JobOpening.findAll", query="SELECT j FROM JobOpening j")
public class JobOpening implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="JOB_OPENING_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JOB_OPENING_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="is_active", nullable=false)
	private Boolean isActive;

	@Column(name="is_display_company")
	private Boolean isDisplayCompany;

	@Column(name="job_desc", length=2980)
	private String jobDesc;

	@Column(name="job_title", nullable=false, length=30)
	private String jobTitle;

	@Column(name="usr_acc_id", nullable=false)
	private Integer usrAccId;

	//bi-directional many-to-one association to Company
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="company_id", nullable=false)
	private Company company;

	//bi-directional many-to-one association to JobOpeningDetail
	@OneToMany(mappedBy="jobOpening")
	private List<JobOpeningDetail> jobOpeningDetails;

	//bi-directional many-to-one association to JobOpeningQuestion
	@OneToMany(mappedBy="jobOpening")
	private List<JobOpeningQuestion> jobOpeningQuestions;

	//bi-directional many-to-one association to JobPostActivity
	@OneToMany(mappedBy="jobOpening")
	private List<JobPostActivity> jobPostActivities;

	//bi-directional many-to-one association to JobPostSkill
	@OneToMany(mappedBy="jobOpening")
	private List<JobPostSkill> jobPostSkills;

	public JobOpening() {
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

	public Boolean getIsDisplayCompany() {
		return this.isDisplayCompany;
	}

	public void setIsDisplayCompany(Boolean isDisplayCompany) {
		this.isDisplayCompany = isDisplayCompany;
	}

	public String getJobDesc() {
		return this.jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Integer getUsrAccId() {
		return this.usrAccId;
	}

	public void setUsrAccId(Integer usrAccId) {
		this.usrAccId = usrAccId;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<JobOpeningDetail> getJobOpeningDetails() {
		return this.jobOpeningDetails;
	}

	public void setJobOpeningDetails(List<JobOpeningDetail> jobOpeningDetails) {
		this.jobOpeningDetails = jobOpeningDetails;
	}

	public JobOpeningDetail addJobOpeningDetail(JobOpeningDetail jobOpeningDetail) {
		getJobOpeningDetails().add(jobOpeningDetail);
		jobOpeningDetail.setJobOpening(this);

		return jobOpeningDetail;
	}

	public JobOpeningDetail removeJobOpeningDetail(JobOpeningDetail jobOpeningDetail) {
		getJobOpeningDetails().remove(jobOpeningDetail);
		jobOpeningDetail.setJobOpening(null);

		return jobOpeningDetail;
	}

	public List<JobOpeningQuestion> getJobOpeningQuestions() {
		return this.jobOpeningQuestions;
	}

	public void setJobOpeningQuestions(List<JobOpeningQuestion> jobOpeningQuestions) {
		this.jobOpeningQuestions = jobOpeningQuestions;
	}

	public JobOpeningQuestion addJobOpeningQuestion(JobOpeningQuestion jobOpeningQuestion) {
		getJobOpeningQuestions().add(jobOpeningQuestion);
		jobOpeningQuestion.setJobOpening(this);

		return jobOpeningQuestion;
	}

	public JobOpeningQuestion removeJobOpeningQuestion(JobOpeningQuestion jobOpeningQuestion) {
		getJobOpeningQuestions().remove(jobOpeningQuestion);
		jobOpeningQuestion.setJobOpening(null);

		return jobOpeningQuestion;
	}

	public List<JobPostActivity> getJobPostActivities() {
		return this.jobPostActivities;
	}

	public void setJobPostActivities(List<JobPostActivity> jobPostActivities) {
		this.jobPostActivities = jobPostActivities;
	}

	public JobPostActivity addJobPostActivity(JobPostActivity jobPostActivity) {
		getJobPostActivities().add(jobPostActivity);
		jobPostActivity.setJobOpening(this);

		return jobPostActivity;
	}

	public JobPostActivity removeJobPostActivity(JobPostActivity jobPostActivity) {
		getJobPostActivities().remove(jobPostActivity);
		jobPostActivity.setJobOpening(null);

		return jobPostActivity;
	}

	public List<JobPostSkill> getJobPostSkills() {
		return this.jobPostSkills;
	}

	public void setJobPostSkills(List<JobPostSkill> jobPostSkills) {
		this.jobPostSkills = jobPostSkills;
	}

	public JobPostSkill addJobPostSkill(JobPostSkill jobPostSkill) {
		getJobPostSkills().add(jobPostSkill);
		jobPostSkill.setJobOpening(this);

		return jobPostSkill;
	}

	public JobPostSkill removeJobPostSkill(JobPostSkill jobPostSkill) {
		getJobPostSkills().remove(jobPostSkill);
		jobPostSkill.setJobOpening(null);

		return jobPostSkill;
	}

}