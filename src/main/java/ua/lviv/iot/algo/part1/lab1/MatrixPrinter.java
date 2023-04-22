package ua.lviv.iot.algo.part1.lab1;

import lombok.ToString;

@ToString(callSuper = true)
public final class MatrixPrinter extends Printer {
    private final int needlesWorks;
    private final int sensors;

    public MatrixPrinter(final int needlesWorks,
                         final int sensors, final String model,
                         final String type, final boolean isColor,
                         final boolean isDuplex, final int paperTrayCapacity,
                         final int paperCount, final int remainingPagesCount,
                         final int pagesCapability) {
        super(model, type, isColor, isDuplex, paperTrayCapacity,
                paperCount, remainingPagesCount, pagesCapability);
        this.needlesWorks = needlesWorks;
        this.sensors = sensors;
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
