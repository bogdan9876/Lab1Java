package ua.lviv.iot.algo.part1.lab1.modelsTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab1.models.LaserPrinter;

import static org.junit.Assert.assertEquals;

class LaserPrinterTest {

    LaserPrinter printer1;

    @BeforeEach
    public void setUp() {
        printer1 = new LaserPrinter(20, "T2000", "Laser", false, false,
                300, 100, 550, 550);
    }

    @Test
    public void testPrint() {
        printer1.print(60);
        assertEquals(40, printer1.getPaperCount());
    }

    @Test
    public void testLoad() {
        printer1.loadPaper(23);
        assertEquals(123, printer1.getPaperCount());
    }

    @Test
    public void testToString() {
        String display = "LaserPrinter(super=Printer(model=T2000, type=Laser, isColor=false, isDuplex=false, paperTrayCapacity=300, paperCount=100, remainingPagesCount=550, pagesCapability=550), pagesDone=20)";
        assertEquals(display, printer1.toString());
    }

    @Test
    public void testGetRemainingPagesCount() {
        assertEquals(550, printer1.getRemainingPagesCount());
    }
}
