package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Printer {
    private String model;
    private String type;
    private boolean isColor;
    private boolean isDuplex;
    private int paperTrayCapacity;
    private int paperCount;

    public void print(int pages) {
        if (paperCount >= pages) {
            paperCount =paperCount-pages;
        }
    }

    public void loadPaper(int count) {
        int availableSpace = paperTrayCapacity - paperCount;
        if (count <= availableSpace) {
            paperCount = count+paperCount;
        }
    }

    private static Printer instance;

    public static Printer getInstance() {
        if(instance == null) {
            instance = new Printer();
        }
        return instance;
    }

    public static void main(String[] args) {
        Printer[] printers = {new Printer(),new Printer("Epson", "Inkjet", true, false, 50, 20)
                ,getInstance(),getInstance()};
        for(Printer printer : printers) {
            System.out.println(printer.toString());
        }
    }
}