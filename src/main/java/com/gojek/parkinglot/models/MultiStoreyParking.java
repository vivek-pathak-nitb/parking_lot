package com.gojek.parkinglot.models;

import java.util.Map;

public class MultiStoreyParking {

    private int levels;
    private Map<Integer, Parking> levelToParkingMap;

    public MultiStoreyParking(final int levels,
                              final Map<Integer, Parking> levelToParkingMap) {
        this.levels = levels;
        this.levelToParkingMap = levelToParkingMap;
    }

    public int getLevels() {
        return levels;
    }

    public Map<Integer, Parking> getLevelToParkingMap() {
        return levelToParkingMap;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public void setLevelToParkingMap(Map<Integer, Parking> levelToParkingMap) {
        this.levelToParkingMap = levelToParkingMap;
    }
}
