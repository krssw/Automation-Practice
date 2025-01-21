package model.enums;

import lombok.Getter;

@Getter
public enum Position {
    LEAD_TEST_ENGINEER("Lead Test Engineer"),
    SENIOR_TEST_ENGINEER("Senior Test Engineer"),
    TEST_ENGINEER("Test Engineer"),
    JUNIOR_ENGINEER("Junior Engineer"),
    LEAD_DEVELOPER("Lead Developer"),
    SENIOR_DEVELOPER("Senior Developer"),
    TEST_DEVELOPER("Test Developer"),
    JUNIOR_DEVELOPER("Junior Developer"),
    BUSINESS_ANALYST("Business Analyst");

    private final String displayPosition;

    Position(String displayPosition) {
        this.displayPosition = displayPosition;
    }

}
