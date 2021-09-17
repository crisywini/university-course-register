package co.perficient.university.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class DaySchedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "start_hour")
    private int startHour;
    @Column(name = "end_hour")
    private int endHour;
    private String classroom;
    @ManyToOne
    private Schedule schedule;


    public DaySchedule() {
    }

    public DaySchedule(Schedule schedule, String name, int startHour, int endHour, String classRoom) {
        this.name = name;
        this.startHour = startHour;
        this.endHour = endHour;
        this.classroom = classRoom;
        this.schedule = schedule;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
