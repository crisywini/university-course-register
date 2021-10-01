package co.perficient.university.model;

import java.util.Arrays;

public enum Role {
    MANAGER("MANAGER"),
    VIEWER("VIEWER"),
    n("NONE");

    private String value;

    Role(String value) {
        this.value = value;
    }

    private static final Role defaultValue = n;

    public static Role of(String value) {
        boolean anyInList = Arrays
                .stream(Role.values())
                .anyMatch(role -> role.toString().equals(value));
        if (anyInList) {
            return Role.valueOf(value);
        }
        return defaultValue;
    }

    @Override
    public String toString() {
        return value;
    }
}
