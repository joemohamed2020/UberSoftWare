public class User extends Person {
    public User ()
    {

    }
    public User(String userName, String password, String Email, String mobileNumber) {
        super(userName, password, Email, mobileNumber);

    }
    public User(String userName, String password, String mobileNumber) {
        super(userName, password, mobileNumber);

    }

    @Override
    public String toString() {
        return "===================\nUserName:"+getUserName()+"\nPassword:"+getPassword()+"\nEmail:"+getEmail()+"\nMobileNumber:"+getMobileNumber()+"\n===================";
    }
}