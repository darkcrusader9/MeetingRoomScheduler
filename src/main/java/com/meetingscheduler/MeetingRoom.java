package com.meetingscheduler;

import com.meetingscheduler.model.Calendar;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
public class MeetingRoom {
    private String meetingRoomId;
    private int capacity;
    Calendar calendar;


    public MeetingRoom(String meetingRoomId, int capacity) {
        this.meetingRoomId = meetingRoomId;
        this.capacity = capacity;
        this.calendar = new Calendar();
    }

    public void addCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void addMeeting(Meeting meeting){
        calendar.addMeeting(meeting);
    }

    public boolean checkAvailability(Date startTime, Date endTime){
        return calendar.isAvailable(startTime, endTime);
    }
}
