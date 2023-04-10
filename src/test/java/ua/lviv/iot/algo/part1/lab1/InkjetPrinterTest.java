package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class InkjetPrinterTest {
    Printer printer1;

    @BeforeEach
    public void setUp() {
        printer1 = new InkjetPrinter("RGB", 4, 20, 15, 30, 10, "Epson 3000",
                "Inkjet", true, true, 150, 50, 100, 500);
    }

    @DisplayName("Test print function in printer")
    @Test
    public void testPrint() {
        printer1.print(20);
        assertEquals(30, printer1.getPaperCount());
    }
    @DisplayName("Test print function in printer")
    @Test
    public void testLoad() {
        printer1.loadPaper(70);
        assertEquals(120, printer1.getPaperCount());
    }
    @DisplayName("Test GetRemainingPagesCount function in printer")
    @Test
    public void testGetRemainingPagesCount() {
        assertEquals(7, printer1.getRemainingPagesCount());
    }
}
