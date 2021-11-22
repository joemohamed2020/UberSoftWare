public class Driver extends Person {
    private String nationalID;
    private String licence ;
    private int driverStatues;

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
    public int getDriverStatues() {
        return driverStatues;
    }

    public void setDriverStatues(int driverStatues) {
        this.driverStatues = driverStatues;
    }
    @Override
    public String toString() {
        return "===================\nUserName:"+getUserName()+"\nPassword:"+getPassword()+"\nEmail:"+getEmail()+"\nMobileNumber:"+getMobileNumber()+"\nLicence:"+getMobileNumber()+"\nNationalId:"+getMobileNumber()+"\n===================";

    }
}