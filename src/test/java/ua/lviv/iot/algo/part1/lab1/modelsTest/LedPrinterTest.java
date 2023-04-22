package ua.lviv.iot.algo.part1.lab1.modelsTest;

import org.junit.Before;
import org.junit.Test;
import ua.lviv.iot.algo.part1.lab1.models.LedPrinter;

import static org.junit.Assert.*;

public class LedPrinterTest {
    LedPrinter printer1;

    @Before
    public void setUp() {
        printer1 = new LedPrinter(4, 1.0, "ME14", "LED", true, true,
                250, 200, 100, 500);
    }

    @Test
    public void testPrint() {
        printer1.print(50);
        assertEquals(150, printer1.getPaperCount());
    }

    @Test
    public void testLoad() {
        printer1.loadPaper(70);
        assertEquals(270, printer1.getPaperCount());
    }

    @Test
    public void testGetRemainingPagesCount() {
        assertEquals(500, printer1.getRemainingPagesCount());
    }
}


