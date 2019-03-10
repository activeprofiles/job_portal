package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the job_post_skills database table.
 * 
 */
@Entity
@Table(name="job_post_skills")
@NamedQuery(name="JobPostSkill.findAll", query="SELECT j FROM JobPostSkill j")
public class JobPostSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="JOB_POST_SKILLS_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JOB_POST_SKILLS_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	private Integer skill;

	//bi-directional many-to-one association to JobOpening
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="job_post_id", nullable=false)
	private JobOpening jobOpening;

	public JobPostSkill() {
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

	public JobOpening getJobOpening() {
		return this.jobOpening;
	}

	public void setJobOpening(JobOpening jobOpening) {
		this.jobOpening = jobOpening;
	}

}