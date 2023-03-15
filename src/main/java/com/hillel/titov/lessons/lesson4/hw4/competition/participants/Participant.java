package com.hillel.titov.lessons.lesson4.hw4.competition.participants;

public abstract class Participant {
    protected String name;
    protected double maxRunningAbility;
    protected double maxJumpingAbility;

    public Participant(String name) {
        this.name = name;
    }

    public void run() {
        System.out.format("%s runs\n", name);
    }
    public void jump() {
        System.out.format("%s jumps\n", name);
    }
    public String getName() {
        return name;
    }
    public double getMaxRunningAbility() {
        return maxRunningAbility;
    }

    public double getMaxJumpingAbility() {
        return maxJumpingAbility;
    }
}
