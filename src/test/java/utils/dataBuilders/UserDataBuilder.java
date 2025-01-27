package utils.dataBuilders;

import model.UserModel;
import model.enums.Position;
import pages.AddUserPage;
import com.github.javafaker.Faker;

import java.util.Random;

public class UserDataBuilder {
    private static Position getRandomPosition() {
        Random random = new Random();
        Position[] positions = Position.values();
        int randomIndex = random.nextInt(positions.length);
        return positions[randomIndex];
    }

    public static void fillUserDetails(AddUserPage addUserPage, UserModel user) {
        addUserPage.addNewUser(
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getPosition()).confirmUserCreation();
    }

    public static UserModel createUser() {
        Faker faker = new Faker();
        Position randomPosition = getRandomPosition();

        return UserModel.builder()
                .name(faker.name().firstName())
                .surname(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .position(randomPosition.getDisplayPosition())
                .build();
    }
}


