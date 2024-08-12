package utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private final String name;
    private final  String surname;
    private final  String email;
    private final String position;
}