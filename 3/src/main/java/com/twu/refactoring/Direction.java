package com.twu.refactoring;

import java.util.Arrays;

public class Direction {
    private final char direction;
    private final char[] strings = {'N','W','S','E'};

    public Direction(char direction) {
        this.direction = direction;
    }

    public Direction turnRight() {
        return turn(-1);
    }

    public Direction turnLeft() {
        return turn(1);
    }

    private Direction turn(int turnRightInstruction) {
        int position = Arrays.binarySearch(strings, direction);
        if (!verifyInstruction()) {
            throw new IllegalArgumentException();
        }
        //need refactor
        if (position + turnRightInstruction < 0) {
            return new Direction(strings[strings.length - 1]);
        } else if (position + turnRightInstruction > strings.length) {
            return new Direction(strings[0]);
        }
        return new Direction(strings[position + turnRightInstruction]);
    }

    private boolean verifyInstruction() {
        for (char val : strings) {
            if (val == direction)
                return true;
        }
        return false;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction1 = (Direction) o;

        if (direction != direction1.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
