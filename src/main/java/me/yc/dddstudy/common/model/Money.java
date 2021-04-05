package me.yc.dddstudy.common.model;

import java.io.Serializable;
import lombok.Getter;

public class Money implements Serializable {

    private int value;

    public Money(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Money multiply(int multiplier) {
        return new Money(value * multiplier);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
