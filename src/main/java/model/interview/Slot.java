package main.java.model.interview;

import java.time.LocalDate;
import java.time.LocalTime;

public class Creneau {
    private final LocalDate date;
    private final LocalTime startInterview;
    private final LocalTime finishInterview;

    public Creneau(LocalDate date, LocalTime startInterview, LocalTime finishInterview) {
        this.date = date;
        this.startInterview = startInterview;
        this.finishInterview = finishInterview;
    }
}