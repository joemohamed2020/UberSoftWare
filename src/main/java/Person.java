public class Person {
    private String userName;
    private String password;
    private String mobileNumber;
    private String Email;

    public Person() {
        userName="";
        password="";
        mobileNumber="";
        Email="";
    }
    public Person(String userName, String password, String Email, String mobileNumber) {
        this.userName = userName;
        this.password = password;
        this.Email = Email;
        this.mobileNumber = mobileNumber;
    }
    public Person(String userName, String password , String mobileNumber) {
        this.userName = userName;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

}