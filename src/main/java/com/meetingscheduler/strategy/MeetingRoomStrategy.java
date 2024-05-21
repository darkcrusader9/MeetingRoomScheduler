package com.meetingscheduler.strategy;

import com.meetingscheduler.MeetingRoom;

import java.util.Date;
import java.util.List;

public interface MeetingRoomStrategy {
    public MeetingRoom bookMeetingRoom(List<MeetingRoom> meetingRoomList, Date startTime, Date endTime);
}
