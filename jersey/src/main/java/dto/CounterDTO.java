package dto;

import java.time.LocalDateTime;

public class CounterDTO {

    private LocalDateTime date;
    private int counter;

    public CounterDTO() {
    }

    public CounterDTO(LocalDateTime date, int value) {
        this.date = date;
        this.counter = value;
    }

    public void setCounter(int value) {
        this.counter = value;
    }

    public int getValue() {
        return this.counter;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDate() {
        return this.date;
    }
}
