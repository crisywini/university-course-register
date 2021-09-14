package co.perficient.university.service.map;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMapService<T, IDT> {

    private Map<IDT, T> map = new HashMap<>();

    T findById(IDT id){
        return map.get(id);
    }

    T save(IDT id, T object){

        if(object != null && id != null ){

            map.put(id, object);

        }else{
            throw new RuntimeException("The entity should not be null");
        }

        return object;
    }

    void deleteById(IDT id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
}
