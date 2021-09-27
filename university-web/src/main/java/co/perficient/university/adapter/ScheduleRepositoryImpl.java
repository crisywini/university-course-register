package co.perficient.university.adapter;

import co.perficient.university.adapter.jparepositories.ScheduleJPARepository;
import co.perficient.university.model.Schedule;
import co.perficient.university.port.ScheduleRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {

    private final ScheduleJPARepository scheduleJPARepository;

    public ScheduleRepositoryImpl(ScheduleJPARepository scheduleJPARepository) {
        this.scheduleJPARepository = scheduleJPARepository;
    }

    @Override
    public Set<Schedule> findAll() {
        return new HashSet<>(scheduleJPARepository.findAll());
    }

    @Override
    public Schedule update(Long id, Schedule newEntity) {
        return null;
    }

    @Override
    public Schedule findById(Long id) {
        return scheduleJPARepository.findById(id).orElse(null);
    }

    @Override
    public Schedule save(Schedule object) {
        return scheduleJPARepository.save(object);
    }

    @Override
    public void delete(Schedule object) {
        scheduleJPARepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        scheduleJPARepository.deleteById(id);
    }
}
