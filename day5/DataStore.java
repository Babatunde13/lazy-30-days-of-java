package day5;

import java.util.HashMap;

public class DataStore {
    public HashMap<String, User> users;


    public DataStore() {
        String baseUrl = "https://jsonplaceholder.typicode.com";
        APIClient<User> apiClient = new APIClient<User>(baseUrl);
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
