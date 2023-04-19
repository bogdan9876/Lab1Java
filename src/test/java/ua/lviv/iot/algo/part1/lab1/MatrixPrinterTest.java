package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class MatrixPrinterTest {

    MatrixPrinter printer1;

    @BeforeEach
    public void setUp() {
        printer1 = new MatrixPrinter(5, 2, "DELL A54", "Matrix", true,
                true, 250, 70, 100, 500);
    }

    @Test
    public void testPrint() {
        printer1.print(20);
        assertEquals(50, printer1.getPaperCount());
    }

    @Test
    public void testLoad() {
        printer1.loadPaper(70);
        assertEquals(140, printer1.getPaperCount());
    }

    @Test
    public void testGetRemainingPagesCount() {
        assertEquals(500, printer1.getRemainingPagesCount());
    }
}
