package com.hillel.titov.lessons.lesson4.hw4.competition.participants;

public class Cat extends Participant {

    public Cat(String name) {
        super(name);
        // Every cat has physical limitations of its body
        maxRunningAbility = 4000;
        maxJumpingAbility = 2.1;
    }
}
