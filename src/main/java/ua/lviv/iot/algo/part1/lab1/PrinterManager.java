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
}
