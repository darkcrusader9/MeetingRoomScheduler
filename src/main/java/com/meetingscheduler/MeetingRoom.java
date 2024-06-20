package com.meetingscheduler;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Setter
@Getter
public class MeetingRoom {
    private String meetingRoomId;
    private int capacity;
    List<Meeting> scheduledMeetingList;


    public MeetingRoom(String meetingRoomId, int capacity) {
        this.meetingRoomId = meetingRoomId;
        this.capacity = capacity;
        this.scheduledMeetingList = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting) {
        int index = binarySearchInsertIndex(meeting.getStartTime());
        scheduledMeetingList.add(index, meeting);
    }

    private int binarySearchInsertIndex(Date startTime) {
        int low = 0;
        int high = scheduledMeetingList.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Date midDate = scheduledMeetingList.get(mid).getStartTime();

            if (midDate.before(startTime)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean checkAvailability(Date startTime, Date endTime){
        for (Meeting scheduledMeeting : scheduledMeetingList) {
            if (startTime.before(scheduledMeeting.getEndTime()) && endTime.after(scheduledMeeting.getStartTime())) {
                return false;
            }
        }
        return true;
    }
}
