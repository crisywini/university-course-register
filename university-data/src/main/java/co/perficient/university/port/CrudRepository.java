package co.perficient.university.port;

import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CrudRepository<T, IDT> {

    T findById(IDT id);

    T save(T object);

    void delete(T object);

    void deleteById(IDT id);

    T update(IDT id, T newEntity);


}
