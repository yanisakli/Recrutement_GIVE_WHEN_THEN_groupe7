package modelTest.interviewTest;

import infrastructure.utils.Utils;
import model.interview.Slot;
import model.interview.exception.SlotException;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.time.LocalTime;

public class SlotTest {

    @Test
    public void should_throw_exception_when_start_time_be_greater_than_finish_time(){
        LocalTime interviewStart = LocalTime.of(17,30);
        LocalTime interviewFinish = LocalTime.of(16,00);
        Assert.assertThrows(SlotException.class,()-> new Slot(Utils.date1,interviewStart,interviewFinish));
    }

    @Test
    public void should_throw_exception_when_date_is_in_weekend(){
        LocalDate date1 = LocalDate.of(2020, 05, 30);
        Assert.assertThrows(SlotException.class,()-> new Slot(date1,Utils.interviewStart,Utils.interviewFinish));
    }

    @Test
    public void should_throw_exception_when_time_start_is_after_7pm(){
        LocalTime interviewStart = LocalTime.of(19,05);
        Assert.assertThrows(SlotException.class,()-> new Slot(Utils.date1,interviewStart,Utils.interviewFinish));
    }

    @Test
    public void should_throw_exception_when_time_finish_is_after_8pm(){
        LocalTime interviewFinish = LocalTime.of(20,05);
        Assert.assertThrows(SlotException.class,()-> new Slot(Utils.date1,Utils.interviewStart,interviewFinish));
    }

    @Test
    public void should_throw_exception_when_time_start_is_before_8am(){
        LocalTime interviewStart = LocalTime.of(7,55);
        Assert.assertThrows(SlotException.class,()-> new Slot(Utils.date1,interviewStart,Utils.interviewFinish));
    }
}
