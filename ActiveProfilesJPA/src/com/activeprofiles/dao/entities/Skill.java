package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the skills database table.
 * 
 */
@Entity
@Table(name="skills")
@NamedQuery(name="Skill.findAll", query="SELECT s FROM Skill s")
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SKILLS_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SKILLS_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=100)
	private String code;

	@Column(nullable=false, length=250)
	private String description;

	//bi-directional many-to-one association to JobSeekerSkill
	@OneToMany(mappedBy="skill")
	private List<JobSeekerSkill> jobSeekerSkills;

	public Skill() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<JobSeekerSkill> getJobSeekerSkills() {
		return this.jobSeekerSkills;
	}

	public void setJobSeekerSkills(List<JobSeekerSkill> jobSeekerSkills) {
		this.jobSeekerSkills = jobSeekerSkills;
	}

	public JobSeekerSkill addJobSeekerSkill(JobSeekerSkill jobSeekerSkill) {
		getJobSeekerSkills().add(jobSeekerSkill);
		jobSeekerSkill.setSkill(this);

		return jobSeekerSkill;
	}

	public JobSeekerSkill removeJobSeekerSkill(JobSeekerSkill jobSeekerSkill) {
		getJobSeekerSkills().remove(jobSeekerSkill);
		jobSeekerSkill.setSkill(null);

		return jobSeekerSkill;
	}

}