package ua.lviv.iot.algo.part1.lab1;

import lombok.*;
@ToString(callSuper = true)
public class InkjetPrinter extends Printer{
    private static final int REQUIRED_COLOUR_PER_PAGE = 10;
    private String colorType;
    private int colorLevel;
    private int cyan;
    private int magenta;
    private int yellow;
    private int black;
   public InkjetPrinter(String colorType, int colorLevel, int cyan, int magenta, int yellow, int black, String model,
                 String type, boolean isColor, boolean isDuplex, int paperTrayCapacity,
                 int paperCount, int remainingPagesCount, int pagesCapability){
      super(model, type, isColor , isDuplex, paperTrayCapacity, paperCount, remainingPagesCount, pagesCapability);
      this.magenta = magenta;
      this.colorType = colorType;
      this.colorLevel = colorLevel;
      this.cyan = cyan;
      this.yellow = yellow;
      this.black = black;
    }
    @Override
    public void print(int pages) {}
    @Override
    public void loadPaper(int count) {}

    @Override
    public int getRemainingPagesCount() {
        return (black+yellow+cyan+magenta)/REQUIRED_COLOUR_PER_PAGE;
    }
}
