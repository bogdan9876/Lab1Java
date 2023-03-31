package ua.lviv.iot.algo.part1.lab1;

import lombok.*;
import java.util.List;

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
    public abstract void print(int pages);
    public abstract void loadPaper(int count);
    private int remainingPagesCount;


    private int pagesCapability;

    public abstract int getRemainingPagesCount();

}
























