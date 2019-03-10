package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the user_roles database table.
 * 
 */
@Entity
@Table(name="user_roles")
@NamedQuery(name="UserRole.findAll", query="SELECT u FROM UserRole u")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USER_ROLES_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_ROLES_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="last_updated_date")
	private Timestamp lastUpdatedDate;

	@Column(name="updated_by", length=15)
	private String updatedBy;

	//bi-directional many-to-one association to SystemRole
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sysroles_id", nullable=false)
	private SystemRole systemRole;

	//bi-directional many-to-one association to UserAccount
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usr_acc_id", nullable=false)
	private UserAccount userAccount;

	public UserRole() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public SystemRole getSystemRole() {
		return this.systemRole;
	}

	public void setSystemRole(SystemRole systemRole) {
		this.systemRole = systemRole;
	}

	public UserAccount getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

}