package domain;

public enum Dates {

    NOW(0),
    YESTERDAY(1),
    DAYS_AGO_2(2),
    DAYS_AGO_3(3),
    OLDER(0);

    public final int number;

    private Dates(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
