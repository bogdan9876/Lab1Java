package ua.lviv.iot.algo.part1.lab1;

import java.util.List;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public abstract class Printer {
    private String model;
    private String type;
    private boolean isColor;
    private boolean isDuplex;
    private int paperTrayCapacity;
    private int paperCount;
    private int remainingPagesCount;
    private int pagesCapability;

    public abstract void print(int pages);

    public abstract void loadPaper(int count);

    public abstract int getRemainingPagesCount();
}
