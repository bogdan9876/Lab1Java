package ua.lviv.iot.algo.part1.lab1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

    public static final String HEADERS = "model, type, isColor, isDuplex, paperTrayCapacity, paperCount, remainingPagesCount, pagesCapability";

    public abstract void print(int pages);

    public abstract void loadPaper(int count);

    public abstract int getRemainingPagesCount();

    public String getHeaders() {
        return HEADERS;
    }

    public String toCSV() {
        return model + "," + type + "," + isColor + "," + isDuplex + "," + paperTrayCapacity + "," + paperCount + "," + remainingPagesCount + "," + pagesCapability;
    }

}
