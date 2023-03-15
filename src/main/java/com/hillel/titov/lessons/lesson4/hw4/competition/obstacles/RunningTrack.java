package com.hillel.titov.lessons.lesson4.hw4.competition.obstacles;

import com.hillel.titov.lessons.lesson4.hw4.competition.participants.Participant;

public class RunningTrack extends Obstacle {
    private double distance;

    public RunningTrack(double distance) {
        if (distance <= 0) {
            System.out.println("Avoid negative or zero values");
            throw new IllegalArgumentException();
        }
        this.distance = distance;
    }

    @Override
    public boolean overcome(Participant participant) {
        participant.run();
        //Each participant has its maximum value of abilities, but at the random moment of time its abilities vary
        double currentRunningAbility = participant.getMaxRunningAbility() * Math.random();
        if (currentRunningAbility >= distance) {
            System.out.format("%s has ran the running track at the distance of %.2f!\n", participant.getName(), distance);
            return true;
        } else {
            System.out.format("%s has failed the running track at the distance of %.2f and finished competitions!\n", participant.getName(), currentRunningAbility);
            return false;
        }
    }
}
