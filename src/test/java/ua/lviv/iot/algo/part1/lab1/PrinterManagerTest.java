package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class PrinterManagerTest {

    PrinterManager printerManager;

    @BeforeEach
    public void setup() {
        printerManager = new PrinterManager();
        printerManager.printers.clear();
        printerManager.addPrinter(new LaserPrinter(10,"RealRif","Laser",true,true,
                250,0,250, 500));
        printerManager.addPrinter(new LaserPrinter(0, "Soliq", "Laser", true, false,
                500, 0, 500, 1000));
        printerManager.addPrinter(new MatrixPrinter(4, 8, "Epson", "Matrix", false,
                false, 150, 50, 100, 300));
        printerManager.addPrinter(new MatrixPrinter(7, 4, "HP", "Matrix", false,
                true, 300, 200, 100, 600));
        printerManager.addPrinter(new LedPrinter(4, 1.25, "Miwa 04", "LED", true,
                true, 250, 150, 100, 1000));
        printerManager.addPrinter(new LedPrinter(1, 1.0, "Lazur", "LED", true,
                false, 18, 18, 0, 180));
        printerManager.addPrinter(new InkjetPrinter("CMYK", 50, 100, 80, 60,
                40, "T44", "Inkjet", true, true, 100, 50,
                50, 200));
        printerManager.addPrinter(new InkjetPrinter("CMYK", 80, 6, 77, 255,
                0, "Marok", "Inkjet", true, false, 50, 30,
                30, 100));
    }

    @Test
    public void testFindByType() {
        List<Printer> foundedPrinters = printerManager.findByType("LED");
        Assertions.assertEquals(2, foundedPrinters.size());
        for (Printer printer : foundedPrinters) {
            Assertions.assertEquals("LED", printer.getType());
        }
    }

    @Test
    public void testFindLargeVolumePrinter() {
        List<Printer> foundedPrinters1 = printerManager.findLargeVolumePrinter(499);
        Assertions.assertEquals(1, foundedPrinters1.size());
        for (Printer printer1 : foundedPrinters1) {
            Assertions.assertTrue(printer1.getPaperTrayCapacity() > 499);
        }
    }
}
