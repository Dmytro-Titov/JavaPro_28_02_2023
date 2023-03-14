package com.hillel.titov.lessons.lesson4.hw4.competition.participants;

public class Robot extends Participant {
    public Robot(String name) {
        super(name);
        // Every robot has physical limitations of its body
        maxRunningAbility = 20000;
        maxJumpingAbility = 3.0;
    }
}
