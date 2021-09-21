package co.perficient.university.service.dayschedule;

import co.perficient.university.model.DaySchedule;
import co.perficient.university.port.DayScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveDayService {

    private final DayScheduleRepository dayScheduleService;

    private static final String DAY_REPEATED_MESSAGE = "The day already exists!";
    public SaveDayService(DayScheduleRepository dayScheduleService) {
        this.dayScheduleService = dayScheduleService;
    }


    public DaySchedule save(DaySchedule daySchedule) {
        validateNonRepeated(daySchedule);
        return dayScheduleService.save(daySchedule);
    }

    private void validateNonRepeated(DaySchedule courseSubject) {
        if (dayScheduleService.findById(courseSubject.getId()) != null) {
            throw new RuntimeException(DAY_REPEATED_MESSAGE);
        }
    }

}
