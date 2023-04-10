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
};