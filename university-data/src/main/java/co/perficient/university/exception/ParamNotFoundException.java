package co.perficient.university.exception;

public class ParamNotFoundException extends RuntimeException {
    public ParamNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

