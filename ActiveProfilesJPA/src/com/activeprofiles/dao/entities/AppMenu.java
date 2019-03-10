package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the app_menu database table.
 * 
 */
@Entity
@Table(name="app_menu")
@NamedQuery(name="AppMenu.findAll", query="SELECT a FROM AppMenu a")
public class AppMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="APP_MENU_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APP_MENU_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=15)
	private String code;

	@Column(length=250)
	private String description;

	@Column(nullable=false)
	private Integer level;

	//bi-directional many-to-one association to MenuRole
	@OneToMany(mappedBy="appMenu")
	private List<MenuRole> menuRoles;

	public AppMenu() {
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

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public List<MenuRole> getMenuRoles() {
		return this.menuRoles;
	}

	public void setMenuRoles(List<MenuRole> menuRoles) {
		this.menuRoles = menuRoles;
	}

	public MenuRole addMenuRole(MenuRole menuRole) {
		getMenuRoles().add(menuRole);
		menuRole.setAppMenu(this);

		return menuRole;
	}

	public MenuRole removeMenuRole(MenuRole menuRole) {
		getMenuRoles().remove(menuRole);
		menuRole.setAppMenu(null);

		return menuRole;
	}

}