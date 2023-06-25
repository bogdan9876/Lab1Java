package ua.lviv.iot.algo.part1.lab1.service;

import org.springframework.stereotype.Service;
import ua.lviv.iot.algo.part1.lab1.model.LaserPrinter;

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class LaserPrinterService {
    private Map<Integer, LaserPrinter> laserPrinters = new HashMap<>();

    private AtomicInteger idCounter = new AtomicInteger();

    public List<LaserPrinter> getAllLaserPrinters() {
        return new LinkedList<>(laserPrinters.values());
    }

    public LaserPrinter getLaserPrinterById(final int laserPrinterId) {
        return laserPrinters.get(laserPrinterId);
    }

    public LaserPrinter createLaserPrinter(final LaserPrinter laserPrinter) {
        laserPrinter.setId(idCounter.incrementAndGet());
        laserPrinters.put(laserPrinter.getId(), laserPrinter);
        return laserPrinter;
    }

    public LaserPrinter updateLaserPrinter(final int laserPrinterId,
                                           final LaserPrinter laserPrinter) {
        laserPrinter.setId(laserPrinterId);
        return laserPrinters.put(laserPrinterId, laserPrinter);
    }

    public boolean deleteLaserPrinter(final int laserPrinterId) {
        return laserPrinters.remove(laserPrinterId) != null;
    }
}
