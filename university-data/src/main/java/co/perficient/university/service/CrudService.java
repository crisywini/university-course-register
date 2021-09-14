package co.perficient.university.service;

import java.util.Set;

public interface CrudService<T, IDT>{

    Set<T> findAll();

    T findById(IDT id);

    T save(T object);

    void delete(T object);

    void deleteById(IDT id);

}
