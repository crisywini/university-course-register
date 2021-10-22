package co.perficient.university.model;

public interface BaseEntity<T> {
    T updateWith(T newItem);
}
