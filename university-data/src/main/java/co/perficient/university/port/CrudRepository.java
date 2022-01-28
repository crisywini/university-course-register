package co.perficient.university.port;

import java.util.Optional;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CrudRepository<T, IDT> {

    Optional<T> findById(IDT id);

    Optional<T> save(T object);

    void delete(T object);

    void deleteById(IDT id);

    Optional<T> update(IDT id, T newEntity);

    Set<T> findAll();

}
