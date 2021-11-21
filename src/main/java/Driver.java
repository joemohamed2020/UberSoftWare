public class Driver extends Person {
    private String nationalID;
    private String licence ;

    public Driver(){
    }

    public Driver(String userName, String password, String Email, String mobileNumber, String nationalID, String licence) {
        super(userName, password, Email, mobileNumber);
        this.nationalID = nationalID;
        this.licence = licence;
    }

    public String getNationalID() {
        return nationalID;
    }
    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }
    public String getLicence() {
        return licence;
    }
    public void setLicence(String licence) {
        this.licence = licence;
    }

    @Override
    public String toString() {
        return "===================\nUserName:"+getUserName()+"\nPassword:"+getPassword()+"\nEmail:"+getEmail()+"\nMobileNumber:"+getMobileNumber()+"\nLicence:"+getMobileNumber()+"\nNationalId:"+getMobileNumber()+"\n===================";

    }
}