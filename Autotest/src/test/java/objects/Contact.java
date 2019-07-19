package objects;

public class Contact {

    private String firstName;
    private String middleName;
    private String lastName;
    private String nickName;
    private String company;
    private String address;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String fax;
    private String firstEmail;
    private String secondEmail;
    private String thirdEmail;
    private String homepage;
    private String secondAddress;
    private String secondHome;
    private String secondNotes;
    private String group;

    public String getFirstName() {
        return firstName;
    }

    public Contact setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Contact setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public Contact setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Contact setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public Contact setHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public Contact setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public Contact setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public Contact setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public String getFax() {
        return fax;
    }

    public Contact setFax(String fax) {
        this.fax = fax;
        return this;
    }

    public String getFirstEmail() {
        return firstEmail;
    }

    public Contact setFirstEmail(String firstEmail) {
        this.firstEmail = firstEmail;
        return this;
    }

    public String getSecondEmail() {
        return secondEmail;
    }

    public Contact setSecondEmail(String secondEmail) {
        this.secondEmail = secondEmail;
        return this;
    }

    public String getThirdEmail() {
        return thirdEmail;
    }

    public Contact setThirdEmail(String thirdEmail) {
        this.thirdEmail = thirdEmail;
        return this;
    }

    public String getHomepage() {
        return homepage;
    }

    public Contact setHomepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public Contact setSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
        return this;
    }

    public String getSecondHome() {
        return secondHome;
    }

    public Contact setSecondHome(String secondHome) {
        this.secondHome = secondHome;
        return this;
    }

    public String getSecondNotes() {
        return secondNotes;
    }

    public Contact setSecondNotes(String secondNotes) {
        this.secondNotes = secondNotes;
        return this;
    }

    public String getGroup() {
        return group;
    }

    public Contact setGroup(String group) {
        this.group = group;
        return this;
    }
}