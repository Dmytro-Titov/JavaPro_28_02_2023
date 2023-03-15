package com.hillel.titov.lessons.lesson4.hw4.competition.participants;

public class Human extends Participant {
    public Human(String name) {
        super(name);
        // Every human has physical limitations of its body
        maxRunningAbility = 10000;
        maxJumpingAbility = 2.3;
    }
}
