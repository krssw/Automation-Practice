package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserModel {
    private final String name;
    private final String surname;
    private final String email;
    private final String position;
}