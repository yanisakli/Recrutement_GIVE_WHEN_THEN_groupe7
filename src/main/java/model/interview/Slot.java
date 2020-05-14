package main.java.model.interview;

import java.time.LocalDate;
import java.time.LocalTime;

public class Slot {

    private final LocalDate date;
    private final LocalTime interviewStart;
    private final LocalTime interviewFinish;

    public Slot(LocalDate date, LocalTime interviewStart, LocalTime interviewFinish) {
        this.date = date;
        this.interviewStart = interviewStart;
        this.interviewFinish = interviewFinish;
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
