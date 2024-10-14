package workforcemanger.workforce.entity;

import workforcemanger.workforce.enums.StatusEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "absences")
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private StatusEnum type;

    private LocalDate date;
    private int duration;

    public Absence() {}


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
}
