package com.meetingscheduler;

import com.meetingscheduler.model.Attendee;
import com.meetingscheduler.strategy.MeetingRoomStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
public class Meeting {
    @Setter
    String meetingId;
    Date startTime;

    @Setter
    Date endTime;
    List<Attendee> attendeeList;

    MeetingRoom meetingRoom;

    public Meeting(String meetingId, Date startTime, Date endTime){
        this.meetingId = meetingId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.attendeeList = new ArrayList<>();
    }

    public void addAttendee(Attendee attendee){
        this.attendeeList.add(attendee);
    }

    public void notifyAttendee(String message){
        for(Attendee attendee : attendeeList)
            attendee.update(message);
    }

    public void setMeetingRoom(List<MeetingRoom> meetingRoomList, MeetingRoomStrategy meetingRoomStrategy){
         this.meetingRoom = meetingRoomStrategy.bookMeetingRoom(meetingRoomList, startTime, endTime);
         if(this.meetingRoom != null){
             this.meetingRoom.addMeeting(this);
             //System.out.println(this.meetingId + " is set in room " + this.meetingRoom.getMeetingRoomId());
             notifyAttendee(meetingId + " is happening in " + this.meetingRoom.getMeetingRoomId());
             //System.out.println("-------------------");
         } else{
             System.out.println("No Meeting Room Available for " + meetingId);
         }

    }
}
