package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the business_stream database table.
 * 
 */
@Entity
@Table(name="business_stream")
@NamedQuery(name="BusinessStream.findAll", query="SELECT b FROM BusinessStream b")
public class BusinessStream implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BUSINESS_STREAM_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BUSINESS_STREAM_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=100)
	private String code;

	@Column(nullable=false, length=250)
	private String description;

	//bi-directional many-to-one association to Company
	@OneToMany(mappedBy="businessStream")
	private List<Company> companies;

	public BusinessStream() {
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

	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Company addCompany(Company company) {
		getCompanies().add(company);
		company.setBusinessStream(this);

		return company;
	}

	public Company removeCompany(Company company) {
		getCompanies().remove(company);
		company.setBusinessStream(null);

		return company;
	}

}