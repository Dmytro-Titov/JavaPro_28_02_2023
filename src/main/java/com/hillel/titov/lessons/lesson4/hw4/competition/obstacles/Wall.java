package com.hillel.titov.lessons.lesson4.hw4.competition.obstacles;

import com.hillel.titov.lessons.lesson4.hw4.competition.participants.Participant;

public class Wall extends Obstacle {
    private double height;

    public Wall(double height) {
        if (height <= 0) {
            System.out.println("Avoid negative or zero values");
            throw new IllegalArgumentException();
        }
        this.height = height;
    }

    @Override
    public boolean overcome(Participant participant) {
        participant.jump();
        //Each participant has its maximum value of abilities, but at the random moment of time its abilities vary
        double currentJumpingAbility = participant.getMaxJumpingAbility() * Math.random();
        if (currentJumpingAbility >= height) {
            System.out.format("%s has jumped over the wall at the height of %.2f!\n", participant.getName(), height);
            return true;
        } else {
            System.out.format("%s has failed the wall at the height of %.2f and finished competitions!\n", participant.getName(), currentJumpingAbility);
            return false;
        }
    }
}
