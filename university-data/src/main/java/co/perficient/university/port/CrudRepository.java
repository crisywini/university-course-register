package co.perficient.university.port;

import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CrudRepository<T, TDto, IDT> {

    TDto findById(IDT id);

    TDto save(T object);

    void delete(T object);

    void deleteById(IDT id);

    TDto update(IDT id, T newEntity);

    Set<TDto> findAll();

}
