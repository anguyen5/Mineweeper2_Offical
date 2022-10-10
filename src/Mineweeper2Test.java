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


   

}
