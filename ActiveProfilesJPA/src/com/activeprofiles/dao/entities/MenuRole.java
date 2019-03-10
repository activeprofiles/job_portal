package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the menu_role database table.
 * 
 */
@Entity
@Table(name="menu_role")
@NamedQuery(name="MenuRole.findAll", query="SELECT m FROM MenuRole m")
public class MenuRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MENU_ROLE_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MENU_ROLE_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	//bi-directional many-to-one association to AppMenu
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="app_menu_id", nullable=false)
	private AppMenu appMenu;

	//bi-directional many-to-one association to SystemRole
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sys_role_id", nullable=false)
	private SystemRole systemRole;

	public MenuRole() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AppMenu getAppMenu() {
		return this.appMenu;
	}

	public void setAppMenu(AppMenu appMenu) {
		this.appMenu = appMenu;
	}

	public SystemRole getSystemRole() {
		return this.systemRole;
	}

	public void setSystemRole(SystemRole systemRole) {
		this.systemRole = systemRole;
	}

}