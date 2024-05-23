package com.example.hqtqlsv.Model;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean isLeapYear() {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isValidDate() {
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > 31) {
            return false;
        }
        if (isLeapYear() && month == 2) {
            return day <= 29;
        } else if (!isLeapYear() && month == 2) {
            return day <= 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30;
        } else {
            return true;
        }
    }

    public void setDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date getNextDate() {
        if (isValidDate()) {
            int nextDay = day + 1;
            int nextMonth = month;
            int nextYear = year;

            if (nextDay > getDaysInMonth(month, year)) {
                nextDay = 1;
                nextMonth++;
            }
            if (nextMonth > 12) {
                nextMonth = 1;
                nextYear++;
            }

            return new Date(nextDay, nextMonth, nextYear);
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    public Date getPreviousDate() {
        if (isValidDate()) {
            int previousDay = day - 1;
            int previousMonth = month;
            int previousYear = year;

            if (previousDay < 1) {
                previousMonth--;
                if (previousMonth < 1) {
                    previousMonth = 12;
                    previousYear--;
                }
                previousDay = getDaysInMonth(previousMonth, previousYear);
            }

            return new Date(previousDay, previousMonth, previousYear);
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    private int getDaysInMonth(int month, int year) {
        if (month == 2) {
            return isLeapYear() ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}
