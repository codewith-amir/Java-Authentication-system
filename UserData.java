import java.util.ArrayList;

public class UserData {
    private ArrayList<User> List = new ArrayList<>();

    public UserData() 
    {
    List.add(new User("Burhan", "bUrhan123"));
    List.add(new User("Amir", "Amir@123"));
    }

    public boolean Authenticate(User user, String password) {
        for (User u : List) {
            if (u.getUserId().equals(user.getUserId()) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void addUser(User user) {
        if (List == null) {
            List = new ArrayList<>();
        }
        List.add(user);
    }
}