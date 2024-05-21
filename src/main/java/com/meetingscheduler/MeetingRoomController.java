package com.meetingscheduler;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MeetingRoomController {
    List<MeetingRoom> meetingRoomList;

    public MeetingRoomController() {
        meetingRoomList = new ArrayList<>();
    }

    public void addMeetingRoom(MeetingRoom meetingRoom){
        this.meetingRoomList.add(meetingRoom);
    }
}
