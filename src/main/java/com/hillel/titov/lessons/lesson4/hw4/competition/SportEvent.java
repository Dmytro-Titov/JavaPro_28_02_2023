package com.hillel.titov.lessons.lesson4.hw4.competition;

import com.hillel.titov.lessons.lesson4.hw4.competition.obstacles.Obstacle;
import com.hillel.titov.lessons.lesson4.hw4.competition.obstacles.RunningTrack;
import com.hillel.titov.lessons.lesson4.hw4.competition.obstacles.Wall;
import com.hillel.titov.lessons.lesson4.hw4.competition.participants.Cat;
import com.hillel.titov.lessons.lesson4.hw4.competition.participants.Human;
import com.hillel.titov.lessons.lesson4.hw4.competition.participants.Participant;
import com.hillel.titov.lessons.lesson4.hw4.competition.participants.Robot;

import java.util.ArrayList;
import java.util.List;

public class SportEvent {
    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<>();
        participants.add(new Human("Oleksandr Shaitan"));
        participants.add(new Robot("K-2SO"));
        participants.add(new Cat("Barsik"));
        participants.add(new Human("Dmytro Titov"));

        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(new RunningTrack(5000));
        obstacles.add(new Wall(1.8));

        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.overcome(participant)) {
                    break;
                }
            }
            System.out.println();
        }
    }
}
