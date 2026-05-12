
   
public class User {

    String UserId;
    String Password;

    public User(String UserId, String Password) {
        this.UserId = UserId;
        this.Password = Password;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}