package objects;

import static Utils.DataGenerator.generateString;
import static Utils.DataGenerator.geniratorNumeric;

public class Contact {

    private String firstName;
    private String middleName;
    private String lastName;
    private String nickName;
    private String address;
    private String homePhone;
    private String mobilePhone;

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

    public Contact generateRandomContact(){
        return new Contact()
                .setFirstName(generateString(6))
                .setMiddleName(generateString(7))
                .setLastName(generateString(8))
                .setNickName(generateString(3))
                .setAddress(generateString(15))
                .setMobilePhone("+7" + geniratorNumeric(10))
                .setHomePhone("+8652" + geniratorNumeric(7));
    }
}