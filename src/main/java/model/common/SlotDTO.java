package java.model.common;

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

    public SlotDTO SlotToDTO(model.interview.Slot slot){
        return new SlotDTO(slot.getDate(),slot.getInterviewStart(),slot.getInterviewFinish());
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
