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
            paperCount -= pages;
            System.out.println("Printing " + pages + " pages.");
        } else {
            System.out.println("Not enough paper in tray.");
        }
    }

    public void loadPaper(int count) {
        int availableSpace = paperTrayCapacity - paperCount;
        if (count <= availableSpace) {
            paperCount += count;
        }
        else {
            paperCount = paperTrayCapacity;
            System.out.println("Paper tray is full.");
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
        Printer[] printers = new Printer[4];
        printers[0] = new Printer();
        printers[1] = new Printer("Epson", "Inkjet", true, false, 50, 20);
        printers[2] = getInstance();
        printers[3] = getInstance();

        for (int i = 0; i < printers.length; i++) {
            System.out.println(printers[i].toString());
        }
    }

}
