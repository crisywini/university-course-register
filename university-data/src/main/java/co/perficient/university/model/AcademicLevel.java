package co.perficient.university.model;

import java.util.Arrays;

public enum AcademicLevel {
    UNDERGRADUATE("UNDERGRADUATE"),
    SPECIALIZATION("SPECIALIZATION"),
    MASTER_DEGREE("MASTER_DEGREE"),
    DOCTOR_DEGREE("DOCTOR_DEGREE"),
    DIPLOMAT("DIPLOMAT"),
    SPECIALIZED_COURSES("SPECIALIZED_COURSES"),
    TRAINING_SCHOOLS("TRAINING_SCHOOLS"),
    HOTBEDS("HOTBEDS"),
    OTHER("OTHER"),
    n("NONE");

    private String value;

    AcademicLevel(String value) {
        this.value = value;
    }

    private static final AcademicLevel defaultValue = n;

    public static AcademicLevel of(String value) {
        boolean anyInList = Arrays
                .stream(AcademicLevel.values())
                .anyMatch(academicLevel -> academicLevel.toString().equals(value));
        if (anyInList) {
            return AcademicLevel.valueOf(value);
        }
        return defaultValue;
    }

    @Override
    public String toString() {
        return value;
    }
}
