package co.perficient.university.model;

import java.util.Arrays;

public enum Modality {
    FACE_TO_FACE("FACE_TO_FACE"),
    VIRTUAL("VIRTUAL"),
    n("NONE");

    private String value;

    Modality(String value) {
        this.value = value;
    }

    private static final Modality defaultValue = n;

    public static Modality of(String value) {
        boolean anyInList = Arrays
                .stream(Modality.values())
                .anyMatch(modality -> modality.toString().equals(value));
        if (anyInList) {
            return Modality.valueOf(value);
        }
        return defaultValue;
    }

    @Override
    public String toString() {
        return value;
    }
}
