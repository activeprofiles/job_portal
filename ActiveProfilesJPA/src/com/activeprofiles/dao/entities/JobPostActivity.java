package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the job_post_activity database table.
 * 
 */
@Entity
@Table(name="job_post_activity")
@NamedQuery(name="JobPostActivity.findAll", query="SELECT j FROM JobPostActivity j")
public class JobPostActivity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="JOB_POST_ACTIVITY_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JOB_POST_ACTIVITY_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=2800)
	private String comments;

	@Column(name="is_active")
	private Boolean isActive;

	@Temporal(TemporalType.DATE)
	@Column(name="posted_date")
	private Date postedDate;

	//bi-directional many-to-one association to JobOpening
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="job_opening_id", nullable=false)
	private JobOpening jobOpening;

	//bi-directional many-to-one association to UserAccount
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usr_acc_id", nullable=false)
	private UserAccount userAccount;

	public JobPostActivity() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Date getPostedDate() {
		return this.postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public JobOpening getJobOpening() {
		return this.jobOpening;
	}

	public void setJobOpening(JobOpening jobOpening) {
		this.jobOpening = jobOpening;
	}

	public UserAccount getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

}