package java.model.common;

import model.interview.Slot;

import java.time.LocalDate;
import java.time.LocalTime;


public class SlotDTO {

    private final LocalDate date;
    private final LocalTime interviewStart;
    private final LocalTime interviewFinish;

    public SlotDTO(LocalDate date, LocalTime interviewStart, LocalTime interviewFinish) {
        this.date = date;
        this.interviewStart = interviewStart;
        this.interviewFinish = interviewFinish;
    }

    public Slot DtoToSlot(){
        return new Slot(date,interviewStart,interviewFinish);
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getInterviewStart() {
        return interviewStart;
    }

    public LocalTime getInterviewFinish() {
        return interviewFinish;
    }
}
