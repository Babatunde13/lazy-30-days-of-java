package day5;

public class User {
    private String _id;
    private String email;
    private String name;
    private String username;

    public User(String _id, String email, String name, String username) {
        this._id = _id;
        this.email = email;
        this.name = name;
        this.username = username;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
