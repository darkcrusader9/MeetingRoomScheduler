package com.meetingscheduler.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Attendee implements Observer {
    String userName;

    @Override
    public void update(String message) {
        System.out.println("Hi " + userName + " " + message);
    }
}
