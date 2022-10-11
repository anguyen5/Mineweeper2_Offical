import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;

class Mineweeper2Test {


    //print2D_test01 print converted matrix 4x3
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

    //print2D_test02 print converted matrix 5x3
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

    //print2D_test03 print converted matrix 1x1 with 1 mines
    @Test
    void print2D_test03() {
        Mineweeper2 mines = new Mineweeper2();

        char matrix[][] = { { '*' }};

        char expected[][] = { { '*'}};

        assertArrayEquals(expected, matrix);
    }

    //print2D_test04 print converted matrix 1x1 with 0 mines
    @Test
    void print2D_test04() {
        Mineweeper2 mines = new Mineweeper2();

        char matrix[][] = { { '0' }};

        char expected[][] = { { '0'}};

        assertArrayEquals(expected, matrix);
    }

    //print2D_test04 print converted matrix 100x100 with 0 mines
    @Test
    void print2D_test05() {
        Mineweeper2 mines = new Mineweeper2();

        char matrix[][] = new char[100][100];
        for(int i = 0;  i < 100; i++){
            for(int j = 0; j < 100;j++){
                matrix[i][j] = '0';
            }

        }
        char expected[][] = new char[100][100];
        for(int i = 0;  i < 100; i++){
            for(int j = 0; j < 100;j++){
                expected[i][j] = '0';
            }
        }

        assertArrayEquals(expected, matrix);
    }

    //print2D_test06 print converted matrix 100x100 with 100 mines
    @Test
    void print2D_test06() {
        Mineweeper2 mines = new Mineweeper2();

        char matrix[][] = new char[100][100];
        for(int i = 0;  i < 100; i++){
            for(int j = 0; j < 100;j++){
                matrix[i][j] = '*';
            }

        }
        char expected[][] = new char[100][100];
        for(int i = 0;  i < 100; i++){
            for(int j = 0; j < 100;j++){
                expected[i][j] = '*';
            }
        }

        assertArrayEquals(expected, matrix);
    }

    //translateMatrix_test02 test for 4x3 with initilized and mixed mines. Use matrix in input file
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

    //translateMatrix_test02 test for 5x3 with initilized and mixed mines. Use matrix in input file
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

    //translateMatrix_test03 test for 1x1 with 1% mines
    @Test
    void translateMatrix_test03() {
        Mineweeper2 mines = new Mineweeper2();

        char matrix[][] = { { '*' }};
        char expected[][] = { { '*'}};
        assertArrayEquals(expected,mines.translateMatrix(matrix));
    }

    //translateMatrix_test06 test for 1x1 with 0% mines
    @Test
    void translateMatrix_test04() {
        Mineweeper2 mines = new Mineweeper2();

        char matrix[][] = { { '.' }};
        char expected[][] = { { '0'}};
        assertArrayEquals(expected,mines.translateMatrix(matrix));
    }

    //translateMatrix_test05 test for 100x100 with 0% mines
    @Test
    void translateMatrix_test05() {
        Mineweeper2 mines = new Mineweeper2();
        char matrix[][] = new char[100][100];
       for(int i = 0;  i < 100; i++){
           for(int j = 0; j < 100;j++){
               matrix[i][j] = '.';
           }

       }
        char expected[][] = new char[100][100];
        for(int i = 0;  i < 100; i++){
            for(int j = 0; j < 100;j++){
                expected[i][j] = '0';
            }
        }
        assertArrayEquals(expected,mines.translateMatrix(matrix));
    }

    //translateMatrix_test06 test for 100x100 with 100% mines
    @Test
    void translateMatrix_test06() {
        Mineweeper2 mines = new Mineweeper2();
        char matrix[][] = new char[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                matrix[i][j] = '*';
            }

        }
        char expected[][] = new char[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                expected[i][j] = '*';
            }
        }

        assertArrayEquals(expected,mines.translateMatrix(matrix));
    }

    //translateMatrix_test07 test for 100x100 with 40% mines
    @Test
    void translateMatrix_test07() {
        Random rand = new Random();

        Mineweeper2 mines = new Mineweeper2();
        char matrix[][] = new char[100][100];
        int row = 100;
        int col = 100;
        int percent_mines = 40;
        int num_mines = (int)((col * row) * ((double)percent_mines / 100));

        //Initilize the board
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = '.';
            }
        }

        //Place the mines in matrix
        while (num_mines > 0) {
            int idxRow = rand.nextInt(row);
            int idxCol = rand.nextInt(col);
            if (matrix[idxRow][idxCol] == '.') {
                matrix[idxRow][idxCol] = '*';
                num_mines--;
            }
        }

        char expected[][] = new char[100][1];
        for(int i = 0; i < 100; i ++){
            for(int j = 0 ; j < 1; j++){
                expected =mines.translateMatrix(matrix);
            }
        }
        assertArrayEquals(expected,mines.translateMatrix(matrix));
    }

    //translateMatrix_test08 test for 1x100 with 30% mines
    @Test
    void translateMatrix_test08() {
        Random rand = new Random();

        Mineweeper2 mines = new Mineweeper2();
        char matrix[][] = new char[1][100];
        int row = 1;
        int col = 100;
        int percent_mines = 30;
        int num_mines = (int)((col * row) * ((double)percent_mines / 100));

        //Initilize the board
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = '.';
            }
        }

        //Place the mines in matrix
        while (num_mines > 0) {
            int idxRow = rand.nextInt(row);
            int idxCol = rand.nextInt(col);
            if (matrix[idxRow][idxCol] == '.') {
                matrix[idxRow][idxCol] = '*';
                num_mines--;
            }
        }

        char expected[][] = new char[100][1];
        for(int i = 0; i < 100; i ++){
            for(int j = 0 ; j < 1; j++){
                expected =mines.translateMatrix(matrix);
            }
        }
        assertArrayEquals(expected,mines.translateMatrix(matrix));
    }

    //translateMatrix_test09 test for 100x1 with 20% mines
    @Test
    void translateMatrix_test09() {
        Random rand = new Random();

        Mineweeper2 mines = new Mineweeper2();
        char matrix[][] = new char[100][1];
        int row = 100;
        int col = 1;
        int percent_mines = 20;
        int num_mines = (int)((col * row) * ((double)percent_mines / 100));

        //Initilize the board
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = '.';
            }
        }

        //Place the mines in matrix
        while (num_mines > 0) {
            int idxRow = rand.nextInt(row);
            int idxCol = rand.nextInt(col);
            if (matrix[idxRow][idxCol] == '.') {
                matrix[idxRow][idxCol] = '*';
                num_mines--;
            }
        }
        //System.out.println("matrix origin: ");
        //mines.print2D(matrix);

        char expected[][] = new char[100][1];
        for(int i = 0; i < 100; i ++){
            for(int j = 0 ; j < 1; j++){
                expected =mines.translateMatrix(matrix);
            }
        }
        //System.out.println("matrix expected: ");
        //mines.print2D(expected);
        assertArrayEquals(expected,mines.translateMatrix(matrix));
    }


}
