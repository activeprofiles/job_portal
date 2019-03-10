package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the job_seeker_skills database table.
 * 
 */
@Entity
@Table(name="job_seeker_skills")
@NamedQuery(name="JobSeekerSkill.findAll", query="SELECT j FROM JobSeekerSkill j")
public class JobSeekerSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="JOB_SEEKER_SKILLS_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JOB_SEEKER_SKILLS_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	//bi-directional many-to-one association to Skill
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usr_acc_id", nullable=false)
	private Skill skill;

	//bi-directional many-to-one association to UserAccount
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="skills_id", nullable=false)
	private UserAccount userAccount;

	public JobSeekerSkill() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Skill getSkill() {
		return this.skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public UserAccount getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

}