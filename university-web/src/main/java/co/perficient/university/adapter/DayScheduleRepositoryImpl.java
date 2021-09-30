package co.perficient.university.adapter;

import co.perficient.university.adapter.jparepositories.DayScheduleJPARepository;
import co.perficient.university.model.dto.DayScheduleDto;
import co.perficient.university.port.DayScheduleRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class DayScheduleRepositoryImpl implements DayScheduleRepository {


    private final DayScheduleJPARepository dayScheduleJPARepository;

    public DayScheduleRepositoryImpl(DayScheduleJPARepository dayScheduleJPARepository) {
        this.dayScheduleJPARepository = dayScheduleJPARepository;
    }

    @Override
    public Set<DayScheduleDto> findAll() {
        return dayScheduleJPARepository
                .findAll()
                .stream()
                .map(x -> new DayScheduleDto(x.getId(),
                        x.getName(),
                        x.getStartHour() + "-" + x.getEndHour(),
                        x.getClassroom()))
                .collect(Collectors.toSet());
    }

    @Override
    public DayScheduleDto update(Long id, DaySchedule newEntity) {
        DaySchedule daySchedule = dayScheduleJPARepository.findById(id).get();
        DaySchedule updatedDay = dayScheduleJPARepository.save(daySchedule.updateWith(newEntity));
        return new DayScheduleDto(updatedDay.getId(),
                updatedDay.getName(),
                updatedDay.getStartHour() + "-" + updatedDay.getEndHour(),
                updatedDay.getClassroom());
    }

    @Override
    public DayScheduleDto findById(Long id) {
        DaySchedule daySchedule = dayScheduleJPARepository.findById(id).orElse(null);
        return (daySchedule != null) ? new DayScheduleDto(daySchedule.getId(),
                daySchedule.getName(),
                daySchedule.getStartHour() + "-" + daySchedule.getEndHour(),
                daySchedule.getClassroom()) : null;
    }

    @Override
    public DayScheduleDto save(DaySchedule object) {
        DaySchedule daySchedule = dayScheduleJPARepository.save(object);

        return new DayScheduleDto(daySchedule.getId(),
                daySchedule.getName(),
                daySchedule.getStartHour() + "-" + daySchedule.getEndHour(),
                daySchedule.getClassroom());
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
