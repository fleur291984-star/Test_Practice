package user;

public class User {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String postalCode;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
