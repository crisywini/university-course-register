package co.perficient.university.port;

import java.util.Optional;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CrudRepository<T, TDto, IDT> {

    Optional<TDto> findById(IDT id);

    Optional<TDto> save(T object);

    void delete(T object);

    void deleteById(IDT id);

    Optional<TDto> update(IDT id, T newEntity);

    Set<TDto> findAll();

}
