package com.activeprofiles.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the user_account database table.
 * 
 */
@Entity
@Table(name="user_account")
@NamedQuery(name="UserAccount.findAll", query="SELECT u FROM UserAccount u")
public class UserAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USER_ACCOUNT_ID_GENERATOR", sequenceName="AP_DUMMY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_ACCOUNT_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth", nullable=false)
	private Date dateOfBirth;

	@Column(name="first_name", nullable=false, length=25)
	private String firstName;

	@Column(length=1)
	private String gender;

	@Column(name="is_active", nullable=false)
	private Boolean isActive;

	@Column(name="last_name", length=25)
	private String lastName;

	@Column(name="middle_name", length=25)
	private String middleName;

	@Column(nullable=false, length=25)
	private String password;

	@Temporal(TemporalType.DATE)
	@Column(name="registration_date", nullable=false)
	private Date registrationDate;

	@Column(name="updated_by", length=15)
	private String updatedBy;

	@Column(nullable=false, length=25)
	private String userid;

	//bi-directional many-to-one association to JobPostActivity
	@OneToMany(mappedBy="userAccount")
	private List<JobPostActivity> jobPostActivities;

	//bi-directional many-to-one association to JobSeekerEducationDetail
	@OneToMany(mappedBy="userAccount")
	private List<JobSeekerEducationDetail> jobSeekerEducationDetails;

	//bi-directional many-to-one association to JobSeekerEperienceDetail
	@OneToMany(mappedBy="userAccount")
	private List<JobSeekerEperienceDetail> jobSeekerEperienceDetails;

	//bi-directional many-to-one association to JobSeekerSkill
	@OneToMany(mappedBy="userAccount")
	private List<JobSeekerSkill> jobSeekerSkills;

	//bi-directional many-to-one association to ProfileDetail
	@OneToMany(mappedBy="userAccount")
	private List<ProfileDetail> profileDetails;

	//bi-directional many-to-one association to UserType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usr_type", nullable=false)
	private UserType userType;

	//bi-directional many-to-one association to UserAddressDetail
	@OneToMany(mappedBy="userAccount")
	private List<UserAddressDetail> userAddressDetails;

	//bi-directional many-to-one association to UserContact
	@OneToMany(mappedBy="userAccount")
	private List<UserContact> userContacts;

	//bi-directional many-to-one association to UserLog
	@OneToMany(mappedBy="userAccount")
	private List<UserLog> userLogs;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="userAccount")
	private List<UserRole> userRoles;

	public UserAccount() {
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

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public List<JobPostActivity> getJobPostActivities() {
		return this.jobPostActivities;
	}

	public void setJobPostActivities(List<JobPostActivity> jobPostActivities) {
		this.jobPostActivities = jobPostActivities;
	}

	public JobPostActivity addJobPostActivity(JobPostActivity jobPostActivity) {
		getJobPostActivities().add(jobPostActivity);
		jobPostActivity.setUserAccount(this);

		return jobPostActivity;
	}

	public JobPostActivity removeJobPostActivity(JobPostActivity jobPostActivity) {
		getJobPostActivities().remove(jobPostActivity);
		jobPostActivity.setUserAccount(null);

		return jobPostActivity;
	}

	public List<JobSeekerEducationDetail> getJobSeekerEducationDetails() {
		return this.jobSeekerEducationDetails;
	}

	public void setJobSeekerEducationDetails(List<JobSeekerEducationDetail> jobSeekerEducationDetails) {
		this.jobSeekerEducationDetails = jobSeekerEducationDetails;
	}

	public JobSeekerEducationDetail addJobSeekerEducationDetail(JobSeekerEducationDetail jobSeekerEducationDetail) {
		getJobSeekerEducationDetails().add(jobSeekerEducationDetail);
		jobSeekerEducationDetail.setUserAccount(this);

		return jobSeekerEducationDetail;
	}

	public JobSeekerEducationDetail removeJobSeekerEducationDetail(JobSeekerEducationDetail jobSeekerEducationDetail) {
		getJobSeekerEducationDetails().remove(jobSeekerEducationDetail);
		jobSeekerEducationDetail.setUserAccount(null);

		return jobSeekerEducationDetail;
	}

	public List<JobSeekerEperienceDetail> getJobSeekerEperienceDetails() {
		return this.jobSeekerEperienceDetails;
	}

	public void setJobSeekerEperienceDetails(List<JobSeekerEperienceDetail> jobSeekerEperienceDetails) {
		this.jobSeekerEperienceDetails = jobSeekerEperienceDetails;
	}

	public JobSeekerEperienceDetail addJobSeekerEperienceDetail(JobSeekerEperienceDetail jobSeekerEperienceDetail) {
		getJobSeekerEperienceDetails().add(jobSeekerEperienceDetail);
		jobSeekerEperienceDetail.setUserAccount(this);

		return jobSeekerEperienceDetail;
	}

	public JobSeekerEperienceDetail removeJobSeekerEperienceDetail(JobSeekerEperienceDetail jobSeekerEperienceDetail) {
		getJobSeekerEperienceDetails().remove(jobSeekerEperienceDetail);
		jobSeekerEperienceDetail.setUserAccount(null);

		return jobSeekerEperienceDetail;
	}

	public List<JobSeekerSkill> getJobSeekerSkills() {
		return this.jobSeekerSkills;
	}

	public void setJobSeekerSkills(List<JobSeekerSkill> jobSeekerSkills) {
		this.jobSeekerSkills = jobSeekerSkills;
	}

	public JobSeekerSkill addJobSeekerSkill(JobSeekerSkill jobSeekerSkill) {
		getJobSeekerSkills().add(jobSeekerSkill);
		jobSeekerSkill.setUserAccount(this);

		return jobSeekerSkill;
	}

	public JobSeekerSkill removeJobSeekerSkill(JobSeekerSkill jobSeekerSkill) {
		getJobSeekerSkills().remove(jobSeekerSkill);
		jobSeekerSkill.setUserAccount(null);

		return jobSeekerSkill;
	}

	public List<ProfileDetail> getProfileDetails() {
		return this.profileDetails;
	}

	public void setProfileDetails(List<ProfileDetail> profileDetails) {
		this.profileDetails = profileDetails;
	}

	public ProfileDetail addProfileDetail(ProfileDetail profileDetail) {
		getProfileDetails().add(profileDetail);
		profileDetail.setUserAccount(this);

		return profileDetail;
	}

	public ProfileDetail removeProfileDetail(ProfileDetail profileDetail) {
		getProfileDetails().remove(profileDetail);
		profileDetail.setUserAccount(null);

		return profileDetail;
	}

	public UserType getUserType() {
		return this.userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public List<UserAddressDetail> getUserAddressDetails() {
		return this.userAddressDetails;
	}

	public void setUserAddressDetails(List<UserAddressDetail> userAddressDetails) {
		this.userAddressDetails = userAddressDetails;
	}

	public UserAddressDetail addUserAddressDetail(UserAddressDetail userAddressDetail) {
		getUserAddressDetails().add(userAddressDetail);
		userAddressDetail.setUserAccount(this);

		return userAddressDetail;
	}

	public UserAddressDetail removeUserAddressDetail(UserAddressDetail userAddressDetail) {
		getUserAddressDetails().remove(userAddressDetail);
		userAddressDetail.setUserAccount(null);

		return userAddressDetail;
	}

	public List<UserContact> getUserContacts() {
		return this.userContacts;
	}

	public void setUserContacts(List<UserContact> userContacts) {
		this.userContacts = userContacts;
	}

	public UserContact addUserContact(UserContact userContact) {
		getUserContacts().add(userContact);
		userContact.setUserAccount(this);

		return userContact;
	}

	public UserContact removeUserContact(UserContact userContact) {
		getUserContacts().remove(userContact);
		userContact.setUserAccount(null);

		return userContact;
	}

	public List<UserLog> getUserLogs() {
		return this.userLogs;
	}

	public void setUserLogs(List<UserLog> userLogs) {
		this.userLogs = userLogs;
	}

	public UserLog addUserLog(UserLog userLog) {
		getUserLogs().add(userLog);
		userLog.setUserAccount(this);

		return userLog;
	}

	public UserLog removeUserLog(UserLog userLog) {
		getUserLogs().remove(userLog);
		userLog.setUserAccount(null);

		return userLog;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setUserAccount(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setUserAccount(null);

		return userRole;
	}

}