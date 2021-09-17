package co.perficient.university.service.dayschedule;


import co.perficient.university.model.CourseSubject;
import co.perficient.university.model.DaySchedule;
import co.perficient.university.port.CourseSubjectService;
import co.perficient.university.port.DayScheduleService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FindAllDaysService {

    private final DayScheduleService dayScheduleService;

    public FindAllDaysService(DayScheduleService dayScheduleService) {
        this.dayScheduleService = dayScheduleService;
    }


    public Set<DaySchedule> findAll() {
        return dayScheduleService.findAll();
    }


}
