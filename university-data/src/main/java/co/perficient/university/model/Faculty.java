package co.perficient.university.model;

import java.util.Arrays;

public enum Faculty {
    ENGINEERING("ENGINEERING"),
    EDUCATION_SCIENCE("EDUCATION_SCIENCE"),
    HUMAN_SCIENCE_AND_FINE_ARTS("HUMAN_SCIENCE_AND_FINE_ARTS"),
    BASIC_SCIENCES_AND_TECHNOLOGIES("BASIC_SCIENCES_AND_TECHNOLOGIES"),
    ECONOMIC("ECONOMIC"),
    HEALTH_SCIENCE("HEALTH_SCIENCE"),
    AGROINDUSTRIAL_SCIENCE("AGROINDUSTRIAL_SCIENCE"),
    n("NONE");

    private String value;

    Faculty(String value) {
        this.value = value;
    }

    private static final Faculty defaultValue = n;

    public static Faculty of(String value) {
        boolean anyInList = Arrays
                .stream(Faculty.values())
                .anyMatch(faculty -> faculty.toString().equals(value));
        if (anyInList) {
            return Faculty.valueOf(value);
        }
        return defaultValue;
    }

    @Override
    public String toString() {
        return value;
    }
}
