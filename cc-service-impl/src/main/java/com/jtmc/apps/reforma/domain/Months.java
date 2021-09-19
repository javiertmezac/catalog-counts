package com.jtmc.apps.reforma.domain;

import java.util.HashMap;
import java.util.Map;

public enum Months {

    ENERO(1),
    FEBRERO(2),
    MARZO(3),
    ABRIL(4),
    MAYO(5),
    JUNIO(6),
    JULIO(7),
    AGOSTO(8),
    SEPTIEMBRE(9),
    OCTUBRE(10),
    NOVIEMBRE(11),
    DICIEMBRE(12);

    private static final Map<Integer, Months> BY_MONTH_NUMBER = new HashMap<>();

    static {
        for (Months m : values()) {
            BY_MONTH_NUMBER.put(m.number, m);
        }
    }

    private final int number;
    Months(int number) {
        this.number = number;
    }

    public static Months valueOfNumber(int number) {
        return BY_MONTH_NUMBER.get(number);
    }
}
