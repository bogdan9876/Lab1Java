package ua.lviv.iot.algo.part1.lab1.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@Setter
public final class LaserPrinter extends Printer {
    private final int pagesDone;

    public LaserPrinter(final int pagesDone, final String model,
                        final String type, final boolean isColor,
                        final boolean isDuplex, final int paperTrayCapacity,
                        final int paperCount, final int remainingPagesCount,
                        final int pagesCapability) {
        super(model, type, isColor, isDuplex,
                paperTrayCapacity, paperCount,
                remainingPagesCount, pagesCapability);
        this.pagesDone = pagesDone;
    }

    public String getHeaders() {
        return super.getHeaders() + ", pagesDone";
    }

    public String toCSV() {
        return super.toCSV() + ", " + pagesDone;
    }

    @Override
    public void print(final int pages) {
        int amountPaperAfterPrint = getPaperCount() - pages;
        setPaperCount(amountPaperAfterPrint);
    }

    @Override
    public void loadPaper(final int count) {
        int amountPaperAfterLoad = getPaperCount() + count;
        setPaperCount(amountPaperAfterLoad);
    }


    @Override
    public int getRemainingPagesCount() {
        return getPagesCapability();
    }
}