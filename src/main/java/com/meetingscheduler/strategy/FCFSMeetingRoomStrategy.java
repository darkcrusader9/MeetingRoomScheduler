package com.meetingscheduler.strategy;

import com.meetingscheduler.MeetingRoom;

import java.util.Date;
import java.util.List;

public class FCFSMeetingRoomStrategy implements MeetingRoomStrategy{
    @Override
    public MeetingRoom bookMeetingRoom(List<MeetingRoom> meetingRoomList, Date startTime, Date endTime) {
        for(MeetingRoom meetingRoom : meetingRoomList){
            if(meetingRoom.checkAvailability(startTime, endTime)){
                return meetingRoom;
            }
        }
        return null;
    }
}
