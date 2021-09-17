package co.perficient.university.service.schedule;

import co.perficient.university.model.DaySchedule;
import co.perficient.university.model.Schedule;
import co.perficient.university.port.DayScheduleService;
import co.perficient.university.port.ScheduleService;
import org.springframework.stereotype.Service;

@Service
public class FindScheduleByIdService {

    private final ScheduleService scheduleService;

    public FindScheduleByIdService(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    public Schedule findById(Long id) {
        return scheduleService.findById(id);
    }
}
