package user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class User {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String postalCode;
}
