package co.perficient.university.port;

import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CrudRepository<T, IDT> {

    Set<T> findAll();

    T findById(IDT id);

    T save(T object);

    void delete(T object);

    void deleteById(IDT id);

}
