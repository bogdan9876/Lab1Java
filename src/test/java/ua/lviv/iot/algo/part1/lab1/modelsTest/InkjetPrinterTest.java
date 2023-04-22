package ua.lviv.iot.algo.part1.lab1.modelsTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab1.models.InkjetPrinter;

import static org.junit.Assert.assertEquals;

public class InkjetPrinterTest {
    private InkjetPrinter printer1;

    @BeforeEach
    public void setUp() {
        printer1 = new InkjetPrinter("RGB", 4, 20, 15, 30, 10, "Epson 3000",
                "Inkjet", true, true, 150, 50, 100, 500);
    }

    @Test
    public void testPrint() {
        printer1.print(20);
        assertEquals(30, printer1.getPaperCount());
    }

    @Test
    public void testLoad() {
        printer1.loadPaper(70);
        assertEquals(120, printer1.getPaperCount());
    }

    @Test
    public void testGetRemainingPagesCount() {
        assertEquals(7, printer1.getRemainingPagesCount());
    }
}
