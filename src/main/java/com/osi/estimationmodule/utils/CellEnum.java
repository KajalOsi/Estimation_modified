package com.osi.estimationmodule.utils;

public enum CellEnum {
    ROLE(0),
    NO_OF_RESOURCES(1),
    EMP_NAME(2),
    PROJECT_LOCATION(3),
    PRACTICE(4),
    SUB_PRACTICE(5),
    JOB_CODE(6),
    PREMIUM(7),
    JAN(8),
    FEB(9),
    MAR(10),
    APR(11),
    MAY(12),
    JUN(13),
    JUL(14),
    AUG(15),
    SEP(16),
    OCT(17),
    NOV(18),
    DEC(19),
    TOTAL_DAYS(20),
    TOTAL_HOURS(21),
    SUGGESTED_HOURLY_RATE(22),
    HOURLY_RATE(23),
    DAILY_RATE(24),
    TOTAL_FEES(25),
    HOURLY_COST(26),
    STANDARD_TOTAL_COST(27),
    OVERHEAD_COST(28),
    NEW_HOURLY_COST(29),
    TOTAL_COST(30),
    GROSS_MARGIN(31),
    GROSS_MARGIN_PERCENTAGE(32);

    private final int cellId;

    CellEnum(int cellId) {
        this.cellId = cellId;
    }

    public int getCellId() {
        return cellId;
    }

    public static CellEnum fromCellId(int cellId) {
        for (CellEnum cellEnum : values()) {
            if (cellEnum.getCellId() == cellId) {
                return cellEnum;
            }
        }
        return null;
    }
}
