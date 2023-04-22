package ua.lviv.iot.algo.part1.lab1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrinterWriterTest {
    private PrinterWriter printerWriter;
    private String csvFile;

    @BeforeEach
    void setUp() throws Exception {
        printerWriter = new PrinterWriter();
        csvFile = printerWriter.csvFile;
    }

    @AfterEach
    void tearDown() throws Exception {
        printerWriter = null;
        csvFile = null;
    }

    @Test
    void testWriteToFileSuccessful() throws IOException {
        List<Printer> printers = Arrays.asList(
                new LaserPrinter(10,"RealRif","Laser",true,true,
                        250,0,250, 500),
                new LaserPrinter(0, "Soliq", "Laser", true, false,
                        500, 0, 500, 1000),
                new InkjetPrinter("CMYK", 50, 100, 80, 60,
                        40, "NOE", "Inkjet", true, true, 100, 50,
                        50, 200),
                new InkjetPrinter("CMYK", 80, 6, 77, 255,
                        0, "Marok", "Inkjet", true, false, 50, 30,
                        30, 100),
                new MatrixPrinter(4, 8, "Epson", "Matrix", false,
                        false, 150, 50, 100, 300),
                new MatrixPrinter(7, 4, "HP", "Matrix", false,
                        true, 300, 200, 100, 600),
                new LedPrinter(4, 1.25, "Miwa 04", "LED", true,
                        true, 250, 150, 100, 1000),
                new LedPrinter(1, 1.0, "Lazur", "LED", true,
                        false, 18, 18, 0, 180)
        );
        printerWriter.writeToFile(printers);

        List<String> expectedLines = Arrays.asList(
                "model, type, isColor, isDuplex, paperTrayCapacity, paperCount, remainingPagesCount, pagesCapability, pagesDone",
                "RealRif,Laser,true,true,250,0,250,500, 10",
                "model, type, isColor, isDuplex, paperTrayCapacity, paperCount, remainingPagesCount, pagesCapability, pagesDone",
                "Soliq,Laser,true,false,500,0,500,1000, 0",
                "model, type, isColor, isDuplex, paperTrayCapacity, paperCount, remainingPagesCount, pagesCapability, colorType, colorLevel, cyan, magenta, yellow, black",
                "NOE,Inkjet,true,true,100,50,50,200, CMYK, 50, 100, 80, 60, 40",
                "model, type, isColor, isDuplex, paperTrayCapacity, paperCount, remainingPagesCount, pagesCapability, colorType, colorLevel, cyan, magenta, yellow, black",
                "Marok,Inkjet,true,false,50,30,30,100, CMYK, 80, 6, 77, 255, 0",
                "model, type, isColor, isDuplex, paperTrayCapacity, paperCount, remainingPagesCount, pagesCapability, needlesWorks, sensors",
                "Epson,Matrix,false,false,150,50,100,300, 4, 8",
                "model, type, isColor, isDuplex, paperTrayCapacity, paperCount, remainingPagesCount, pagesCapability, needlesWorks, sensors",
                "HP,Matrix,false,true,300,200,100,600, 7, 4",
                "model, type, isColor, isDuplex, paperTrayCapacity, paperCount, remainingPagesCount, pagesCapability, countOfLightPanels, zoom",
                "Miwa 04,LED,true,true,250,150,100,1000, 4, 1.25",
                "model, type, isColor, isDuplex, paperTrayCapacity, paperCount, remainingPagesCount, pagesCapability, countOfLightPanels, zoom",
                "Lazur,LED,true,false,18,18,0,180, 1, 1.0"

        );
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        List<String> actualLines = new ArrayList<>();
        String line = null;
        while ((line = reader.readLine()) != null) {
            actualLines.add(line);
        }
        reader.close();

        assertEquals(expectedLines, actualLines);
    }

    @Test
    void testWriteToFileEmptyList() throws IOException {
        List<Printer> printers = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> printerWriter.writeToFile(printers));
    }

    @Test
    void testAlreadyExistingFileOverride() throws IOException {
        File tempFile = Files.createTempFile("result", ".csv").toFile();

        try {
            Files.write(tempFile.toPath(), "This is a temporary file".getBytes());

            printerWriter.csvFile = tempFile.getAbsolutePath();

            List<Printer> printers = Arrays.asList(
                    new LaserPrinter(10,"RealRif","Laser",true,true,
                            250,0,250, 500)
            );
            printerWriter.writeToFile(printers);

            List<String> expectedLines = Arrays.asList(
                    "model, type, isColor, isDuplex, paperTrayCapacity, paperCount, remainingPagesCount, pagesCapability, pagesDone",
                    "RealRif,Laser,true,true,250,0,250,500, 10"
            );
            List<String> actualLines = Files.readAllLines(tempFile.toPath());
            assertEquals(expectedLines, actualLines);
        } finally {
            tempFile.delete();
        }
    }



}
