package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the job_seeker_skills_other database table.
 * 
 */
@Entity
@Table(name="job_seeker_skills_other")
@NamedQuery(name="JobSeekerSkillsOther.findAll", query="SELECT j FROM JobSeekerSkillsOther j")
public class JobSeekerSkillsOther implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="JOB_SEEKER_SKILLS_OTHER_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JOB_SEEKER_SKILLS_OTHER_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false)
	private Integer skill;

	//bi-directional many-to-one association to JobSeekerEperienceDetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usr_acc_id", nullable=false)
	private JobSeekerEperienceDetail jobSeekerEperienceDetail;

	public JobSeekerSkillsOther() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSkill() {
		return this.skill;
	}

	public void setSkill(Integer skill) {
		this.skill = skill;
	}

	public JobSeekerEperienceDetail getJobSeekerEperienceDetail() {
		return this.jobSeekerEperienceDetail;
	}

	public void setJobSeekerEperienceDetail(JobSeekerEperienceDetail jobSeekerEperienceDetail) {
		this.jobSeekerEperienceDetail = jobSeekerEperienceDetail;
	}

}