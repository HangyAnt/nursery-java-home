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
            getChildrenDoSomething();
            evaluateResult(i + 1); // Plus 1, because we started with 0.
        }
    }

    private void getChildrenDoSomething() {
        groups.forEach(group -> {
            int random = ThreadLocalRandom.current().nextInt();
            if (random % 4 == 0) {
                playBall(group);
            }
            if (random % 4 == 1) {
                dance(group);
            }
            if (random % 4 == 2) {
                draw(group);
            } else {
                sing(group);
            }
        });
    }

    private void evaluateResult(int numOfHalfAnHours) {
        if (countWhimperingChildren() > 2) {
            System.out.println("\033[0;31m*** Chaos in the nursery! ***\033[0m");
            logComplacency(numOfHalfAnHours);
            System.out.print("\n");
            System.exit(0);
        } else {
            System.out.println("\033[0;34m*** Tranquility in the nursery. :) ***\033[0m");
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
        System.out.println("*** Evaluation after " + (float) numOfHalfAnHours / 2 + " hours ***");
        int groupNumber = 1;
        groups.forEach(group -> {
            System.out.println(group.getName() + ":");
            group.getGroup().forEach(child ->
                    System.out.printf("%-27s complacency: %2d\n", child.toString(), child.getComplacency()));
        });
    }

}
