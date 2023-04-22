package ua.lviv.iot.algo.part1.lab1;

import lombok.ToString;

@ToString(callSuper = true)
public final class LedPrinter extends Printer {
    private final int countOfLightPanels;
    private final double zoom;

    public LedPrinter(final int countOfLightPanels, final double zoom,
                      final String model,
                      final String type, final boolean isColor,
                      final boolean isDuplex, final int paperTrayCapacity,
                      final int paperCount, final int remainingPagesCount,
                      final int pagesCapability) {
        super(model, type, isColor, isDuplex, paperTrayCapacity,
                paperCount, remainingPagesCount, pagesCapability);
        this.countOfLightPanels = countOfLightPanels;
        this.zoom = zoom;
    }

    @Override
    public void print(final int pages) {
        final int amountPaperAfterPrint = getPaperCount() - pages;
        setPaperCount(amountPaperAfterPrint);
    }

    @Override
    public void loadPaper(final int count) {
        final int amountPaperAfterLoad = getPaperCount() + count;
        setPaperCount(amountPaperAfterLoad);
    }

    @Override
    public int getRemainingPagesCount() {
        return getPagesCapability();
    }
}
