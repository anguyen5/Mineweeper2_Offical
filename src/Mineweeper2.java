/**
 * @author An Nguyen, Satinder Singh, Xuan Dao
 * @version 10/10/2022
 * Professor Tom Capaul
 * Group Project 1
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *  This class takes text from System to generate a 2D array containing
 *  mines and numbers indicating how many mines are nearby cells
 *
 */

public class Minesweeper2 {
    /*
     * This method takes in a String array of argument
     * @param String[] called theArgs
     * @return void
     */

    public static void main(String[] theArgs) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        if (theArgs.length == 1){
            scan = new Scanner(new File(theArgs[0]));
        }
        int countField = 0;
        while (scan.hasNext()) {
            int row = scan.nextInt();
            int col = scan.nextInt();
            char[][] matrixMines = new char[row][col];

            if(row == 0){
                break;
            }
            countField += 1;
            scan.nextLine(); // reads "enter" from keyboard
            for (int i = 0; i < row; i++) {
                String str = scan.nextLine();
                for (int j = 0; j < col; j++) {
                    matrixMines[i][j] = str.charAt(j);
                }
            }

            System.out.println("Field #" + countField +":");
            //print2D(matrixMines);

            //translate matrix
            char[][] matrixConverted = translateMatrix(matrixMines);
            System.out.println(print2D(matrixConverted));
        }

    }

    /*
     *  This method prints the 2D array as a String in the correct format
     *  @param Takes in a 2D array of char
     *  @return String conversion of char in the array
     */
     public static String print2D(final char theMatrix[][]) {
         String str = "";
         for (int i = 0; i < theMatrix.length; i++) {
             // Loop through all elements of current row
             for (int j = 0; j < theMatrix[i].length; j++) {
                 str += theMatrix[i][j];
                 //System.out.print([i][j]);
             }
             str += "\n";

         }
         System.out.print(str);
         return str;
     }
    /*
     *  This method translate the 2D array from '*' and '.' to '*' and a number
     *  that tells how many mines are located adjacent to the cell
     *  @param Takes in a 2D array of char
     *  @return a 2D array of converted chars
     */
    public static char[][] translateMatrix(final char theMatrix[][]) {
        int count;
        char matrixConverted[][] = new char[theMatrix.length][theMatrix[0].length];
        for (int i = 0; i < theMatrix.length; i++) {
            for (int j = 0; j < theMatrix[i].length; j++) {
                count = 0;
                if (i - 1 >= 0 && theMatrix[i - 1][j] == '*') { //north
                    count += 1;
                }
                if (i + 1 < theMatrix.length && theMatrix[i + 1][j] == '*') { // south
                    count += 1;
                }

                if ( j + 1 < theMatrix[i].length && theMatrix[i][j + 1] == '*') { //east
                    count += 1;
                }
                if (j - 1 >= 0 && theMatrix[i][j - 1] == '*') { //west
                    count += 1;
                }
                if ((i - 1 >= 0 && j + 1 < theMatrix[i].length) && theMatrix[i - 1][j + 1] == '*') { //north-east
                    count += 1;
                }
                if ((i - 1 >= 0 && j - 1 >= 0) && theMatrix[i - 1][j - 1] == '*') { //north-west
                    count += 1;
                } if ((i + 1 < theMatrix.length && j + 1 < theMatrix[i].length) && theMatrix[i + 1][j + 1] == '*') { //south-east
                    count += 1;
                } if ((i + 1 < theMatrix.length && j - 1 >= 0) && theMatrix[i + 1][j - 1] == '*') { //south-west
                    count += 1;
                }
                if(theMatrix[i][j] == '*'){
                    matrixConverted[i][j] = '*';
                }
                else {
                    matrixConverted[i][j] = (char) (count + '0');
                }

            }
        }
        return matrixConverted;
    }
}
