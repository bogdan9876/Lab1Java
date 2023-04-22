package ua.lviv.iot.algo.part1.lab1.writers;

import ua.lviv.iot.algo.part1.lab1.models.Printer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PrinterWriter {
    public static final String DEFAULT_RESULT_FILE = "result.csv";

    public void writeToFile(final List<Printer> printers) {
        if (printers == null || printers.isEmpty()) {
            throw new IllegalArgumentException("Exception detected");
        }
        try (FileWriter writer = new FileWriter(DEFAULT_RESULT_FILE)) {
            for (Printer printer : printers) {
                writer.write(printer.getHeaders());
                writer.write("\n");
                writer.write(printer.toCSV());
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}