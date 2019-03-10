package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the profile_details database table.
 * 
 */
@Entity
@Table(name="profile_details")
@NamedQuery(name="ProfileDetail.findAll", query="SELECT p FROM ProfileDetail p")
public class ProfileDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROFILE_DETAILS_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROFILE_DETAILS_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false)
	private Boolean active;

	@Column(nullable=false)
	private byte[] profile;

	@Column(name="profile_type", length=15)
	private String profileType;

	//bi-directional many-to-one association to UserAccount
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usr_acc_id", nullable=false)
	private UserAccount userAccount;

	public ProfileDetail() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public byte[] getProfile() {
		return this.profile;
	}

	public void setProfile(byte[] profile) {
		this.profile = profile;
	}

	public String getProfileType() {
		return this.profileType;
	}

	public void setProfileType(String profileType) {
		this.profileType = profileType;
	}

	public UserAccount getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

}