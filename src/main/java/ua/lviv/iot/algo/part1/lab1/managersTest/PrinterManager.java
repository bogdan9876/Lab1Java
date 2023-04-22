package ua.lviv.iot.algo.part1.lab1.managersTest;

import lombok.Getter;
import lombok.Setter;
import ua.lviv.iot.algo.part1.lab1.models.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public final class PrinterManager {
    private List<Printer> printers = new LinkedList<Printer>();

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
