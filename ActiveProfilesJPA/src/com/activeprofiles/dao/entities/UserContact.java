package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_contact database table.
 * 
 */
@Entity
@Table(name="user_contact")
@NamedQuery(name="UserContact.findAll", query="SELECT u FROM UserContact u")
public class UserContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USER_CONTACT_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_CONTACT_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="contact_active", nullable=false)
	private Boolean contactActive;

	@Column(name="contact_no", nullable=false, length=10)
	private String contactNo;

	@Column(name="device_type", nullable=false, length=10)
	private String deviceType;

	@Column(name="sms_active", nullable=false)
	private Boolean smsActive;

	//bi-directional many-to-one association to UserAccount
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usr_acc_id", nullable=false)
	private UserAccount userAccount;

	public UserContact() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getContactActive() {
		return this.contactActive;
	}

	public void setContactActive(Boolean contactActive) {
		this.contactActive = contactActive;
	}

	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDeviceType() {
		return this.deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public Boolean getSmsActive() {
		return this.smsActive;
	}

	public void setSmsActive(Boolean smsActive) {
		this.smsActive = smsActive;
	}

	public UserAccount getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

}