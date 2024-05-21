package com.meetingscheduler;

import com.meetingscheduler.model.*;
import com.meetingscheduler.strategy.FCFSMeetingRoomStrategy;
import com.meetingscheduler.strategy.MeetingRoomStrategy;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Attendee attendee1 = new Attendee("John");
        Attendee attendee2 = new Attendee("Alice");

        // Create a MeetingRoomController
        MeetingRoomController meetingRoomController = new MeetingRoomController();

        // Create some meeting rooms
        MeetingRoom meetingRoom1 = new MeetingRoom("101", 10);
        MeetingRoom meetingRoom2 = new MeetingRoom( "102", 8);

        meetingRoomController.addMeetingRoom(meetingRoom1);
        meetingRoomController.addMeetingRoom(meetingRoom2);

        // Create a list of meeting rooms
        List<MeetingRoom> meetingRooms = meetingRoomController.getMeetingRoomList();

        // Create a meeting room booking strategy
        MeetingRoomStrategy meetingRoomStrategy = new FCFSMeetingRoomStrategy();

        // Create a meeting
        Date startTime = new Date();
        Date endTime = new Date(startTime.getTime() + 3600000); // 1 hour later
        Meeting meeting = new Meeting("Meeting 1", startTime, endTime);
        meeting.addAttendee(attendee1);
        meeting.addAttendee(attendee2);
        meeting.setMeetingRoom(meetingRooms, meetingRoomStrategy);


        // Create a meeting
        Meeting meeting1 = new Meeting("Meeting 2", startTime, endTime);
        meeting1.addAttendee(attendee1);
        meeting1.addAttendee(attendee2);
        meeting1.setMeetingRoom(meetingRooms, meetingRoomStrategy);

        // Create a meeting
        Meeting meeting2 = new Meeting("Meeting 3", startTime, endTime);
        meeting2.addAttendee(attendee1);
        meeting2.addAttendee(attendee2);
        meeting2.setMeetingRoom(meetingRooms, meetingRoomStrategy);

        // Create a meeting
        Meeting meeting3 = new Meeting("Meeting 4", new Date(startTime.getTime() + 7200000), new Date(startTime.getTime() + 10800000));
        meeting3.addAttendee(attendee1);
        meeting3.addAttendee(attendee2);
        meeting3.setMeetingRoom(meetingRooms, meetingRoomStrategy);

        // Create a meeting
        Meeting meeting4 = new Meeting("Meeting 5", new Date(startTime.getTime() + 7200000), new Date(startTime.getTime() + 10800000));
        meeting4.addAttendee(attendee1);
        meeting4.addAttendee(attendee2);
        meeting4.setMeetingRoom(meetingRooms, meetingRoomStrategy);
    }
}
