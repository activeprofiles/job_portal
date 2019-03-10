package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the system_roles database table.
 * 
 */
@Entity
@Table(name="system_roles")
@NamedQuery(name="SystemRole.findAll", query="SELECT s FROM SystemRole s")
public class SystemRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SYSTEM_ROLES_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SYSTEM_ROLES_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=15)
	private String code;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(length=250)
	private String description;

	@Column(name="last_updated_date")
	private Timestamp lastUpdatedDate;

	@Column(name="updated_by", length=15)
	private String updatedBy;

	//bi-directional many-to-one association to MenuRole
	@OneToMany(mappedBy="systemRole")
	private List<MenuRole> menuRoles;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="systemRole")
	private List<UserRole> userRoles;

	public SystemRole() {
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

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<MenuRole> getMenuRoles() {
		return this.menuRoles;
	}

	public void setMenuRoles(List<MenuRole> menuRoles) {
		this.menuRoles = menuRoles;
	}

	public MenuRole addMenuRole(MenuRole menuRole) {
		getMenuRoles().add(menuRole);
		menuRole.setSystemRole(this);

		return menuRole;
	}

	public MenuRole removeMenuRole(MenuRole menuRole) {
		getMenuRoles().remove(menuRole);
		menuRole.setSystemRole(null);

		return menuRole;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setSystemRole(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setSystemRole(null);

		return userRole;
	}

}