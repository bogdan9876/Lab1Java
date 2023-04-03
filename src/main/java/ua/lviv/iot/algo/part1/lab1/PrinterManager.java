package ua.lviv.iot.algo.part1.lab1;

import java.security.PublicKey;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PrinterManager{
    static List<Printer> printers = new LinkedList<Printer>();
    public void addPrinter(final Printer printer){
        printers.add(printer);
    }

    public List<Printer> findByType(String type) {
        return printers.stream()
                        .filter(p -> p.getType().equals(type))
                        .collect(Collectors.toList());
    }
    public List<Printer> findLargeVolumePrinter(int paperTrayCapacity) {
        return printers.stream()
                        .filter(p -> p.getPaperTrayCapacity() > paperTrayCapacity)
                        .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        PrinterManager object = new PrinterManager();
        object.addPrinter(new LaserPrinter(10,"RealRif","laser",true,true,250,0,250, 500));
        object.addPrinter(new LaserPrinter(0, "Soliq", "laser", true, false, 500, 0, 500, 1000));
        object.addPrinter(new MatrixPrinter(4, 8, "Epson", "matrix", false, false, 150, 50, 100, 300));
        object.addPrinter(new MatrixPrinter(7, 4, "HP", "matrix", false, true, 300, 200, 100, 600));
        object.addPrinter(new LedPrinter(4, 1.25, "Miwa 04", "LED", true, true, 250, 150, 100, 1000));
        object.addPrinter(new LedPrinter(1, 1.0, "Lazur", "LED", true, false, 18, 18, 0, 180));
        object.addPrinter(new InkjetPrinter("CMYK", 50, 100, 80, 60, 40, "", "Injet", true, true, 100, 50, 50, 200));
        object.addPrinter(new InkjetPrinter("CMYK", 80, 6, 77, 255, 0, "Marok", "Injet", true, false, 50, 30, 30, 100));


        for (Printer printer : printers) {
            System.out.println(printer.toString());
        }
        System.out.println(object.findByType("laser"));
        System.out.println(object.findLargeVolumePrinter(499));
    }
};