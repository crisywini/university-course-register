package co.perficient.university.adapter;

import co.perficient.university.adapter.jparepositories.ScheduleJPARepository;
import co.perficient.university.model.dto.ScheduleDto;
import co.perficient.university.port.ScheduleRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {

    private final ScheduleJPARepository scheduleJPARepository;

    public ScheduleRepositoryImpl(ScheduleJPARepository scheduleJPARepository) {
        this.scheduleJPARepository = scheduleJPARepository;
    }

    @Override
    public Set<ScheduleDto> findAll() {
        return scheduleJPARepository
                .findAll()
                .stream()
                .map(x -> new ScheduleDto(x.getId(),
                        x.getStartDate(),
                        x.getEndDate()))
                .collect(Collectors.toSet());
    }

    @Override
    public ScheduleDto update(Long id, Schedule newEntity) {
        Schedule schedule = scheduleJPARepository.findById(id).get();
        Schedule updatedSchedule = scheduleJPARepository.save(schedule.updateWith(newEntity));
        return new ScheduleDto(updatedSchedule.getId(),
                updatedSchedule.getStartDate(),
                updatedSchedule.getEndDate());
    }

    @Override
    public ScheduleDto findById(Long id) {
        Schedule schedule = scheduleJPARepository.findById(id).orElse(null);
        return (schedule != null) ? new ScheduleDto(schedule.getId(),
                schedule.getStartDate(),
                schedule.getEndDate()) : null;
    }

    @Override
    public ScheduleDto save(Schedule object) {
        Schedule schedule = scheduleJPARepository.save(object);
        return new ScheduleDto(schedule.getId(),
                schedule.getStartDate(),
                schedule.getEndDate());
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
