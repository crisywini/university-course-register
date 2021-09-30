package co.perficient.university.exception;

public class NullEntityException extends RuntimeException {
    public NullEntityException(String errorMessage) {
        super(errorMessage);
    }
}
