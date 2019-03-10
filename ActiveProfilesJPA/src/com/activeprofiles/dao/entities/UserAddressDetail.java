package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_address_details database table.
 * 
 */
@Entity
@Table(name="user_address_details")
@NamedQuery(name="UserAddressDetail.findAll", query="SELECT u FROM UserAddressDetail u")
public class UserAddressDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USER_ADDRESS_DETAILS_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_ADDRESS_DETAILS_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=250)
	private String address;

	@Column(length=10)
	private String city;

	@Column(length=10)
	private String country;

	@Column(length=10)
	private String state;

	@Column(length=10)
	private String zipcode;

	//bi-directional many-to-one association to UserAccount
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usr_acc_id", nullable=false)
	private UserAccount userAccount;

	public UserAddressDetail() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public UserAccount getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

}