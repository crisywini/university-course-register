package co.perficient.university.adapter;

import co.perficient.university.adapter.jparepositories.DayScheduleJPARepository;
import co.perficient.university.model.DaySchedule;
import co.perficient.university.port.DayScheduleRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class DayScheduleRepositoryImpl implements DayScheduleRepository {


    private final DayScheduleJPARepository dayScheduleJPARepository;

    public DayScheduleRepositoryImpl(DayScheduleJPARepository dayScheduleJPARepository) {
        this.dayScheduleJPARepository = dayScheduleJPARepository;
    }

    @Override
    public Set<DaySchedule> findAll() {
        return new HashSet<>(dayScheduleJPARepository.findAll());
    }

    @Override
    public DaySchedule update(Long id, DaySchedule newEntity) {
        return null;
    }

    @Override
    public DaySchedule findById(Long id) {
        return dayScheduleJPARepository.findById(id).orElse(null);
    }

    @Override
    public DaySchedule save(DaySchedule object) {
        return dayScheduleJPARepository.save(object);
    }

    @Override
    public void delete(DaySchedule object) {
        dayScheduleJPARepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        dayScheduleJPARepository.deleteById(id);
    }
}
