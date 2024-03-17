package ua.lviv.iot.algo.part1.lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Finder {

    public String findImagesFiles(final String text, final String searchWord) {
        Pattern pattern = Pattern.compile("(?i)\\b\\d?\\w*[_]?"+ searchWord +"[_]?\\w*(\\.|\\s*)\\w*\\.(jpg|png|gif)\\b");
        Matcher matcher = pattern.matcher(text);
        StringBuilder foundedFiles = new StringBuilder();

        while (matcher.find()) {
            foundedFiles.append(matcher.group()).append("\n");
        }

        if (foundedFiles.length() > 0) {
            return foundedFiles.toString();
        } else {
            return null;
        }
    }

    public static void main(final String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Finder <text> <search_word>");
            return;
        }

        String text = args[0];
        String searchWord = args[1];

        Finder finder = new Finder();
        String foundedNames = finder.findImagesFiles(text, searchWord);
        System.out.println(foundedNames);
    }
}
