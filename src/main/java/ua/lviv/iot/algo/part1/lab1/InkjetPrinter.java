package ua.lviv.iot.algo.part1.lab1;

import lombok.ToString;

@ToString(callSuper = true)
public final class InkjetPrinter extends Printer {
    private static final int REQUIRED_COLOUR_PER_PAGE = 10;
    private final String colorType;
    private final int colorLevel;
    private final int cyan;
    private final int magenta;
    private final int yellow;
    private final int black;

    public InkjetPrinter(final String colorType, final int colorLevel,
                         final int cyan, final int magenta,
                         final int yellow, final int black, final String model,
                         final String type, final boolean isColor,
                         final boolean isDuplex, final int paperTrayCapacity,
                         final int paperCount, final int remainingPages,
                         final int pagesCapability) {
                super(model, type, isColor, isDuplex,
                paperTrayCapacity, paperCount, remainingPages, pagesCapability);
        this.colorType = colorType;
        this.colorLevel = colorLevel;
        this.cyan = cyan;
        this.magenta = magenta;
        this.yellow = yellow;
        this.black = black;
    }

    public String getHeaders() {
        return super.getHeaders() + ", colorType, colorLevel, cyan, magenta, yellow, black";
    }

    public String toCSV() {
        return super.toCSV() + ", " + colorType + ", " + colorLevel + ", " + cyan + ", " + magenta + ", " + yellow + ", " + black;
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
        return (black + yellow + cyan + magenta) / REQUIRED_COLOUR_PER_PAGE;
    }
}
