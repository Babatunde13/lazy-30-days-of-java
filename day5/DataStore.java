package day5;

import java.util.HashMap;

public class DataStore {
    private final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private HashMap<String, User> users;

    public DataStore() {
        APIClient<User> apiClient = new APIClient<User>(this.BASE_URL);
        String usersJson = apiClient.get("/users");
        System.out.println(usersJson);

        this.users = new HashMap<String, User>();
    }

    public void addUser(User user) {
        this.users.put(user.get_id(), user);
    }

    public User getUser(String _id) {
        return this.users.get(_id);
    }

    public void addOrUpdateUser(String _id, User user) {
        this.users.put(_id, user);
    }

    public void deleteUser(String _id) {
        this.users.remove(_id);
    }

    public HashMap<String, User> getUsers() {
        return this.users;
    }
}
