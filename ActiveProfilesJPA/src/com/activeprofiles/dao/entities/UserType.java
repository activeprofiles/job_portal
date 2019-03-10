package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user_type database table.
 * 
 */
@Entity
@Table(name="user_type")
@NamedQuery(name="UserType.findAll", query="SELECT u FROM UserType u")
public class UserType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USER_TYPE_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_TYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=15)
	private String code;

	@Column(length=250)
	private String description;

	//bi-directional many-to-one association to UserAccount
	@OneToMany(mappedBy="userType")
	private List<UserAccount> userAccounts;

	public UserType() {
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

	public List<UserAccount> getUserAccounts() {
		return this.userAccounts;
	}

	public void setUserAccounts(List<UserAccount> userAccounts) {
		this.userAccounts = userAccounts;
	}

	public UserAccount addUserAccount(UserAccount userAccount) {
		getUserAccounts().add(userAccount);
		userAccount.setUserType(this);

		return userAccount;
	}

	public UserAccount removeUserAccount(UserAccount userAccount) {
		getUserAccounts().remove(userAccount);
		userAccount.setUserType(null);

		return userAccount;
	}

}