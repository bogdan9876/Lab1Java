package ua.lviv.iot.algo.part1.lab1;

import lombok.*;
@ToString(callSuper = true)
public class LedPrinter extends Printer{
    private int countOfLightPanels;
    private double zoom;
    public LedPrinter(int countOfLightPanels, double zoom, String model,
                         String type, boolean isColor, boolean isDuplex, int paperTrayCapacity,
                         int paperCount, int remainingPagesCount, int pagesCapability){
        super(model, type, isColor, isDuplex, paperTrayCapacity, paperCount, remainingPagesCount, pagesCapability);
        this.countOfLightPanels=countOfLightPanels;
        this.zoom=zoom;
    }
    @Override
    public void print(int pages) {
        int amountPaperAfterPrint = getPaperCount() - pages;
        setPaperCount(amountPaperAfterPrint);
    }

    @Override
    public void loadPaper(int count) {
        int amountPaperAfterPrint = getPaperCount() + count;
        setPaperCount(amountPaperAfterPrint);
    }

    @Override
    public int getRemainingPagesCount() {
        return getPagesCapability();
    }
}