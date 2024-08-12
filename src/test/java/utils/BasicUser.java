package utils;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BasicUser extends User {
    private final String name;
    private final String surname;
    private final String email;
    private final String position;

    @Builder
    public BasicUser(String name, String surname, String email, String position) {
        super(name, surname, email, position);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.position = position;
    }

    public String getFullName() { return String.format("%s %s", name, surname); }
    public String getEmail() { return String.format("%s", email); }
    public String getPosition() { return String.format("%s", position); }
}
