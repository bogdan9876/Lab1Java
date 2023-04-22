package ua.lviv.iot.algo.part1.lab1;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public final class PrinterManager {
    public static List<Printer> printers = new LinkedList<Printer>();

    public void addPrinter(final Printer printer) {
        printers.add(printer);
    }

    public List<Printer> findByType(final String type) {
        return printers.stream()
                        .filter(p -> p.getType().equals(type))
                        .collect(Collectors.toList());
    }

    public List<Printer> findLargeVolumePrinter(final int paperTrayCap) {
        return printers.stream()
                        .filter(p -> p.getPaperTrayCapacity() > paperTrayCap)
                        .collect(Collectors.toList());
    }

    public static void main(String args[]){
        PrinterManager printerManager = new PrinterManager();
        printerManager.addPrinter(new LaserPrinter(10,"RealRif","Laser",true,true,
                250,0,250, 500));
        printerManager.addPrinter(new LaserPrinter(0, "Soliq", "Laser", true, false,
                500, 0, 500, 1000));
        printerManager.addPrinter(new InkjetPrinter("CMYK", 50, 100, 80, 60,
                40, "NOE", "Inkjet", true, true, 100, 50,
                50, 200));
        printerManager.addPrinter(new InkjetPrinter("CMYK", 80, 6, 77, 255,
                0, "Marok", "Inkjet", true, false, 50, 30,
                30, 100));
        printerManager.addPrinter(new MatrixPrinter(4, 8, "Epson", "Matrix", false,
                false, 150, 50, 100, 300));
        printerManager.addPrinter(new MatrixPrinter(7, 4, "HP", "Matrix", false,
                true, 300, 200, 100, 600));
        printerManager.addPrinter(new LedPrinter(4, 1.25, "Miwa 04", "LED", true,
                true, 250, 150, 100, 1000));
        printerManager.addPrinter(new LedPrinter(1, 1.0, "Lazur", "LED", true,
                false, 18, 18, 0, 180));

        PrinterWriter printerWriter = new PrinterWriter();
        printerWriter.writeToFile(printers);
    }

    public List<Printer> getPrinters() {
        return printers;
    }

    public void setPrinters(List<Printer> printers) {
        this.printers = printers;
    }
}
