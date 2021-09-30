package co.perficient.university.exception;

public class RepeatedEntityException extends RuntimeException {
    public RepeatedEntityException(String errorMessage) {
        super(errorMessage);
    }
}
