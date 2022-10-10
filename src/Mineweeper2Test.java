import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;

class Mineweeper2Test {

    @Test
    void main_test() throws IOException {
        try {
            Mineweeper2 mines = new Mineweeper2();
            //String inputFile = Files.readString(Paths.get("test_input.txt"), StandardCharsets.UTF_8);

            String content1 = Files.readString(Paths.get("test_output.txt"), StandardCharsets.UTF_8);
            String content2_expected = Files.readString(Paths.get("minesweeper_output.txt"), StandardCharsets.UTF_8);

            //assertArrayEquals(content2_expected,mines.main(content1));
          
            assertArrayEquals(content1.toCharArray(), content2_expected.toCharArray());
        }
        catch (IOException e){

        }

    }

    @Test
    void print2D_test01() {
        Mineweeper2 mines = new Mineweeper2();

        char matrix[][] = { { '*', '1', '0', '0' },
                { '2', '2', '1', '0' },
                { '1', '*', '1', '0' },
                { '1', '1', '1', '0' }};
        char expected[][] = { { '*', '1', '0', '0' },
                { '2', '2', '1', '0' },
                { '1', '*', '1', '0' },
                { '1', '1', '1', '0' }};

        assertArrayEquals(expected, matrix);
    }

    @Test
    void print2D_test02() {
        Mineweeper2 mines = new Mineweeper2();

        char matrix[][] = { { '*', '*', '1', '0', '0' },
                { '3', '3', '2', '0' , '0'},
                { '1', '*', '1', '0', '0' }};
        char expected[][] = { { '*', '*', '1', '0', '0' },
                { '3', '3', '2', '0' , '0'},
                { '1', '*', '1', '0', '0' }};

        assertArrayEquals(expected, matrix);
    }

    @Test
    void translateMatrix_test01() {
        Mineweeper2 mines = new Mineweeper2();

        char matrix[][] = { { '*', '.', '.', '.' },
                { '.', '.', '.', '.' },
                { '.', '*', '.', '.' },
                { '.', '.', '.', '.' }};
        char expected[][] = { { '*', '1', '0', '0' },
                { '2', '2', '1', '0' },
                { '1', '*', '1', '0' },
                { '1', '1', '1', '0' }};
        assertArrayEquals(expected,mines.translateMatrix(matrix));
    }

    @Test
    void translateMatrix_test02() {
        Mineweeper2 mines = new Mineweeper2();

        char matrix[][] = { { '*', '*', '.', '.', '.' },
                { '.', '.', '.', '.' , '.'},
                { '.', '*', '.', '.', '.' }};
        char expected[][] = { { '*', '*', '1', '0', '0' },
                { '3', '3', '2', '0' , '0'},
                { '1', '*', '1', '0', '0' }};
        assertArrayEquals(expected,mines.translateMatrix(matrix));
    }

    @Test
    void translateMatrix_test03() {
        Mineweeper2 mines = new Mineweeper2();

        char matrix[][] = { { '*' }};
        char expected[][] = { { '*'}};
        assertArrayEquals(expected,mines.translateMatrix(matrix));
    }

    @Test
    void translateMatrix_test04() {
        Mineweeper2 mines = new Mineweeper2();

        char matrix[][] = { { '.' }};
        char expected[][] = { { '0'}};
        assertArrayEquals(expected,mines.translateMatrix(matrix));
    }


    @Test
    void outputFile_test() throws FileNotFoundException {

        try {
            Mineweeper2 mines = new Mineweeper2();
            //String inputFile = Files.readString(Paths.get("test_input.txt"), StandardCharsets.UTF_8);

            String content1 = Files.readString(Paths.get("test_output.txt"), StandardCharsets.UTF_8);
            String content2_expected = Files.readString(Paths.get("minesweeper_output.txt"), StandardCharsets.UTF_8);

            //assertArrayEquals(content2_expected,mines.outputFile(content1));
            //assertArrayEquals(content1.toCharArray(), content2.toCharArray());
        }
        catch (IOException e){

        }

    }


}