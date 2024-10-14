package workforcemanger.workforce.dto;

import workforcemanger.workforce.enums.StatusEnum;

import java.time.LocalDate;

public class AbsenceDTO {

    private int id;
    private StatusEnum type;
    private LocalDate date;
    private int duration;

    public AbsenceDTO() {}

    public AbsenceDTO(int id, StatusEnum type, LocalDate date, int duration) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StatusEnum getType() {
        return type;
    }

    public void setType(StatusEnum type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "AbsenceDTO{" +
                "id=" + id +
                ", type=" + type +
                ", date=" + date +
                ", duration=" + duration +
                '}';
    }
}
