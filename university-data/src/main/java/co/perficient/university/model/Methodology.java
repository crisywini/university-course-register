package co.perficient.university.model;

import java.util.Arrays;

public enum Methodology {
    FACE_TO_FACE("FACE_TO_FACE"),
    VIRTUAL("VIRTUAL"),
    VIRTUAL_MEDIATION("VIRTUAL_MEDIATION"),
    FLIPPED_CLASSROOM("FLIPPED_CLASSROOM"),
    n("NONE");

    private String value;

    Methodology(String value) {
        this.value = value;
    }

    private static final Methodology defaultValue = n;

    public static Methodology of(String value) {
        boolean anyInList = Arrays
                .stream(Methodology.values())
                .anyMatch(methodology -> methodology.toString().equals(value));
        if (anyInList) {
            return Methodology.valueOf(value);
        }
        return defaultValue;
    }

    @Override
    public String toString() {
        return value;
    }
}
