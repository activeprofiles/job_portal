package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the user_log database table.
 * 
 */
@Entity
@Table(name="user_log")
@NamedQuery(name="UserLog.findAll", query="SELECT u FROM UserLog u")
public class UserLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USER_LOG_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_LOG_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="last_job_applied_date")
	private Date lastJobAppliedDate;

	@Temporal(TemporalType.DATE)
	@Column(name="last_login_date")
	private Date lastLoginDate;

	//bi-directional many-to-one association to UserAccount
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usr_acc_id", nullable=false)
	private UserAccount userAccount;

	public UserLog() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getLastJobAppliedDate() {
		return this.lastJobAppliedDate;
	}

	public void setLastJobAppliedDate(Date lastJobAppliedDate) {
		this.lastJobAppliedDate = lastJobAppliedDate;
	}

	public Date getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public UserAccount getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

}