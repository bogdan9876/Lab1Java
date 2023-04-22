package ua.lviv.iot.algo.part1.lab1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PrinterWriter {
    public String csvFile = "result.csv";
    public void writeToFile(final List<Printer> printers) {
        if (printers == null || printers.isEmpty()) {
            throw new IllegalArgumentException("Exception detected");
        }
        try (FileWriter writer = new FileWriter(csvFile)) {
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