package co.perficient.university.model;

import javax.persistence.Entity;
import java.io.Serializable;
@Entity
public class DaySchedule implements Serializable {
    private long id;
    private String name;
    private int start_hour;
    private int end_hour;
    private String classRoom;


    public DaySchedule() {
    }

    public DaySchedule(String name, int start_hour, int end_hour, String classRoom) {
        this.name = name;
        this.start_hour = start_hour;
        this.end_hour = end_hour;
        this.classRoom = classRoom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStart_hour() {
        return start_hour;
    }

    public void setStart_hour(int start_hour) {
        this.start_hour = start_hour;
    }

    public int getEnd_hour() {
        return end_hour;
    }

    public void setEnd_hour(int end_hour) {
        this.end_hour = end_hour;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }
}
