package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the job_opening_questions database table.
 * 
 */
@Entity
@Table(name="job_opening_questions")
@NamedQuery(name="JobOpeningQuestion.findAll", query="SELECT j FROM JobOpeningQuestion j")
public class JobOpeningQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="JOB_OPENING_QUESTIONS_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JOB_OPENING_QUESTIONS_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=250)
	private String answer;

	@Column(nullable=false, length=100)
	private String code;

	@Column(nullable=false, length=250)
	private String description;

	//bi-directional many-to-one association to JobOpening
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="job_opening_id", nullable=false)
	private JobOpening jobOpening;

	public JobOpeningQuestion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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

	public JobOpening getJobOpening() {
		return this.jobOpening;
	}

	public void setJobOpening(JobOpening jobOpening) {
		this.jobOpening = jobOpening;
	}

}