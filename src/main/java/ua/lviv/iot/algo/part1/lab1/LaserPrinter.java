package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@ToString(callSuper = true)
public class LaserPrinter extends Printer{
    private int pagesDone;
    @Override
    public void print(int pages) {}

    @Override
    public void loadPaper(int count) {}
    public LaserPrinter(int pagesDone, String model,
                        String type, boolean isColor, boolean isDuplex, int paperTrayCapacity,
                        int paperCount, int remainingPagesCount, int pagesCapability){
        super(model, type, isColor, isDuplex, paperTrayCapacity, paperCount, remainingPagesCount, pagesCapability);
        this.pagesDone = pagesDone;
    }
    @Override
    public int getRemainingPagesCount() {
        return getPagesCapability();
    }
}
