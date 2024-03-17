package ua.lviv.iot.algo.part1.lab5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FinderTest {

    @Test
    void testFindImagesFiles() {
        String text = "misha222.png 1misha222.gif misha222.pnghjjk.png misha222.pngg misha222";
        String searchWord = "misha";

        Finder finder = new Finder();
        String result = finder.findImagesFiles(text, searchWord);

        Assertions.assertEquals("misha222.png\n1misha222.gif\nmisha222.pnghjjk.png\n", result);
    }

    @Test
    void testEmptyText() {
        String text = "";
        String searchWord = "misha";

        Finder finder = new Finder();
        String result = finder.findImagesFiles(text, searchWord);

        Assertions.assertNull(result);
    }

    @Test
    void testWrongSearch() {
        String text = "misha222.png 7k7k misha222.gif misha222.pnghjjk.png misha222.pngg misha222";
        String searchWord = "roman333";

        Finder finder = new Finder();
        String result = finder.findImagesFiles(text, searchWord);

        Assertions.assertNull(result);
    }
}

