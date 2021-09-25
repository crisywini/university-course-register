package co.perficient.university.model;

public abstract class BaseEntity<T> {
    public abstract T updateWith(T newItem);
}
