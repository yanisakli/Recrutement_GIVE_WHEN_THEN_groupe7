package model.interview;

import model.common.SlotDTO;
import model.interview.exception.SlotException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Slot {

    private final LocalDate date;
    private final LocalTime interviewStart;
    private final LocalTime interviewFinish;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slot slot = (Slot) o;
        return Objects.equals(date, slot.date) &&
                Objects.equals(interviewStart, slot.interviewStart) &&
                Objects.equals(interviewFinish, slot.interviewFinish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, interviewStart, interviewFinish);
    }

    public Slot(LocalDate date, LocalTime interviewStart, LocalTime interviewFinish) throws SlotException {
        if(interviewStart.compareTo(interviewFinish) >= 0){
            throw new SlotException("date time of interview finish must be greater than date time of interview start");
        }
        if(interviewStart.compareTo(LocalTime.of(19,01)) > 0){
            throw new SlotException("No interview after 7PM");
        }
        if(interviewStart.compareTo(LocalTime.of(8,00)) < 0){
            throw new SlotException("No interview before 8AM");
        }
        if(interviewFinish.compareTo(LocalTime.of(20,01)) > 0){
            throw new SlotException("No finish interview after 8PM");
        }
        if(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY){
            throw new SlotException("No interview in weekend");
        }
        this.date = date;
        this.interviewStart = interviewStart;
        this.interviewFinish = interviewFinish;
    }

    public SlotDTO SlotToDTO(){
        return new SlotDTO(date, interviewStart, interviewFinish);
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
