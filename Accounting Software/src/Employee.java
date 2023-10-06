public class Employee {
	
	private int employeeCode, employmentID, department, costCentre, profile, housePhone, mobilePhone, payslipPin;
	private String PPSNo, surname, firstName, address, postCode, county, country, email, gender, employmentType;
	
	Employee()
	{
		employeeCode = employmentID = department = costCentre = profile = housePhone = mobilePhone = payslipPin = 0;
		PPSNo = surname = firstName = address = postCode = county = country = email = gender = employmentType = null;
	}

	public int getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(int employeeCode) {
		this.employeeCode = employeeCode;
	}

	public int getEmploymentID() {
		return employmentID;
	}

	public void setEmploymentID(int employmentID) {
		this.employmentID = employmentID;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public int getCostCentre() {
		return costCentre;
	}

	public void setCostCentre(int costCentre) {
		this.costCentre = costCentre;
	}

	public int getProfile() {
		return profile;
	}

	public void setProfile(int profile) {
		this.profile = profile;
	}

	public int getHousePhone() {
		return housePhone;
	}

	public void setHousePhone(int housePhone) {
		this.housePhone = housePhone;
	}

	public int getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(int mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public int getPayslipPin() {
		return payslipPin;
	}

	public void setPayslipPin(int payslipPin) {
		this.payslipPin = payslipPin;
	}

	public String getPPSNo() {
		return PPSNo;
	}

	public void setPPSNo(String pPSNo) {
		PPSNo = pPSNo;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address1, String address2, String address3, String address4) {
		this.address = address1 + ";\n" + address2 + ";\n" + address3 + ";\n" + address4;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}
	
}
