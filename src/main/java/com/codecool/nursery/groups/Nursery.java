package com.codecool.nursery.groups;

import com.codecool.nursery.children.Child;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Nursery {

    private final List<Child> CHILDREN;
    private List<Group> groups;
    private Group group1;
    private Group group2;
    private Group group3;

    private final int TWELVE_HALF_AN_HOUR = 12;

    public Nursery(ArrayList<Child> children, String name1, String name2, String name3) {
        this.CHILDREN = children;
        groups = new ArrayList<>(
                List.of(
                        group1 = new Group(name1),
                        group2 = new Group(name2),
                        group3 = new Group(name3)
                )
        );
    }

    private void playBall(Group group) {
        for (Child child : group.getGroup()) {
            child.playBall();
        }
    }

    private void dance(Group group) {
        for (Child child : group.getGroup()) {
            child.dance();
        }
    }

    private void draw(Group group) {
        for (Child child : group.getGroup()) {
            child.draw();
        }
    }

    private void sing(Group group) {
        for (Child child : group.getGroup()) {
            child.sing();
        }
    }

    private void assignChildrenToGroups() {
        Collections.shuffle(CHILDREN);
        int groupIndex = 0;
        for (int i = 0; i < CHILDREN.size(); ) {
            Child child = CHILDREN.get(i);
            switch (i % groups.size()) {
                case 0:
                    if (group1.getGroup().size() < CHILDREN.size() / groups.size()) {
                        group1.getGroup().add(child);
                    } else {
                        group1.getGroup().set(groupIndex, child);
                    }
                    break;
                case 1:
                    if (group2.getGroup().size() < CHILDREN.size() / groups.size()) {
                        group2.getGroup().add(child);
                    } else {
                        group2.getGroup().set(groupIndex, child);
                    }
                    break;
                case 2:
                    if (group3.getGroup().size() < CHILDREN.size() / groups.size()) {
                        group3.getGroup().add(child);
                    } else {
                        group3.getGroup().set(groupIndex, child);
                    }
                    break;
            }
            i++;
            if (i % groups.size() == 0) {
                groupIndex++;
            }
        }
    }

    public void simulateOneDay() {
        for (int i = 0; i < TWELVE_HALF_AN_HOUR; i++) {
            assignChildrenToGroups();
            makeChildrenDoSomething();
            evaluateResult(i + 1); // Plus 1, because we started with 0.
        }
    }

    private void makeChildrenDoSomething() {
        groups.forEach(group -> {
            int random = ThreadLocalRandom.current().nextInt();
            switch (random % 4) {
                case 0:
                    playBall(group);
                    break;
                case 1:
                    dance(group);
                    break;
                case 2:
                    draw(group);
                    break;
                case 3:
                    sing(group);
                    break;
            }
        });
    }

    private void evaluateResult(int numOfHalfAnHours) {
        if (countWhimperingChildren() > 2) {
            System.out.printf("\033[0;31m%s*** Chaos in the nursery! :/ ***%s\033[0m\n", " ".repeat(7), " ".repeat(7));
            logComplacency(numOfHalfAnHours);
            System.out.print("\n");
            System.exit(0);
        } else {
            System.out.printf("\033[0;34m%s*** Tranquility in the nursery. :) ***%s\033[0m\n", " ".repeat(4), " ".repeat(4));
            logComplacency(numOfHalfAnHours);
            System.out.print("\n");
        }
    }

    private int countWhimperingChildren() {
        int mostWhimperingChildren = 0;
        for (int i = 0; i < groups.size(); i++) {
            int numOfWhimperingChildren = groups.get(i).getGroup()
                    .stream()
                    .reduce(0, (numOfWhimpering, child) ->
                            child.isWhimpering() ? numOfWhimpering + 1 : numOfWhimpering, Integer::sum);
            mostWhimperingChildren = Math.max(numOfWhimperingChildren, mostWhimperingChildren);
        }
        return mostWhimperingChildren;
    }

    private void logComplacency(int numOfHalfAnHours) {
        System.out.printf("%s*** Evaluation after " + (float) numOfHalfAnHours / 2 + " hour%s ***%s\n",
                " ".repeat(6), numOfHalfAnHours > 2 ? "s" : " ", " ".repeat(6));
        groups.forEach(group -> {
            System.out.println("\033[4;32m××× " + group.getName() + ":\033[0m");
            group.getGroup().forEach(child ->
                    System.out.printf("%-30s complacency: %2d\n", child.toString(), child.getComplacency()));
        });
    }

}
