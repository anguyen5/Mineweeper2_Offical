import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// java src/Mineweeper2.java test_input.txt

public class Mineweeper2 {
    public static void main(String[] args) throws FileNotFoundException {
        String str_output = "";
        File file;

        if(args.length > 0)
            file = new File(args[0]);
        else
            file = new File("minesweeper_input.txt");

        Scanner scan = new Scanner(file);

        int cnt_field = 0;
        while (scan.hasNext()) {
            //String firstLine = scan.nextLine();
            int row = scan.nextInt();
            int col = scan.nextInt();
            char[][] matrix_mines = new char[row][col];
            cnt_field +=1;
            if(row == 0 && col == 0){
                str_output += "End of program.";
                System.out.println("End of program.");
                break;
            }

            scan.nextLine(); // reads "enter" from keyboard
            for (int i = 0; i < row; i++) {
                String str = scan.nextLine();
                for (int j = 0; j < col; j++) {
                    matrix_mines[i][j] = str.charAt(j);
                }
            }

            //output Field
            str_output += "Field #" + cnt_field +":\n";
            System.out.println("Field #" + cnt_field +":");
            //print2D(matrix_mines);

            //translate matrix
           char[][] matrix_converted = translateMatrix(matrix_mines);
           str_output += print2D(matrix_converted) + "\n";
        }

       /* if(args.length > 1)
            outputFile(str_output, args[1]);
        else
            outputFile(str_output, "test_output.txt");*/

        //write output file
        try {
            File output;
            FileWriter myWriter;
            if(args.length > 1){
                output = new File(args[0]);
                myWriter = new FileWriter(output);
            }
            else {
                output = new File("test_output.txt");
                myWriter = new FileWriter(output);
            }
            myWriter.write(str_output);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static String print2D(char matrix[][]) {
        String str = "";
        for (int i = 0; i < matrix.length; i++) {
            // Loop through all elements of current row
            for (int j = 0; j < matrix[i].length; j++) {
                str += matrix[i][j];
                //System.out.print(matrix[i][j]);
            }
            str += "\n";

        }
        System.out.print(str);
        return str;
    }

    public static char[][] translateMatrix(char matrix[][]) {
        int cnt_mines = 0;
        int cnt;
        char matrix_converted[][] = new char[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                cnt = 0;
                if (i - 1 >= 0 && matrix[i - 1][j] == '*') { //north
                    cnt += 1;
                }
                if (i + 1 < matrix.length && matrix[i + 1][j] == '*') { // south
                    cnt += 1;
                }

                if ( j + 1 < matrix[i].length && matrix[i][j + 1] == '*') { //east
                    cnt += 1;
                }
                if (j - 1 >= 0 && matrix[i][j - 1] == '*') { //west
                    cnt += 1;
                }
                if ((i - 1 >= 0 && j + 1 < matrix[i].length) && matrix[i - 1][j + 1] == '*') { //north-east
                    cnt += 1;
                }
                if ((i - 1 >= 0 && j - 1 >= 0) && matrix[i - 1][j - 1] == '*') { //north-west
                    cnt += 1;
                } if ((i + 1 < matrix.length && j + 1 < matrix[i].length) && matrix[i + 1][j + 1] == '*') { //south-east
                    cnt += 1;
                } if ((i + 1 < matrix.length && j - 1 >= 0) && matrix[i + 1][j - 1] == '*') { //south-west
                    cnt += 1;
                }
                if(matrix[i][j] == '*'){
                    matrix_converted[i][j] = '*';
                }
                else {
                    matrix_converted[i][j] = (char) (cnt + '0');
                }

            }
        }
        return matrix_converted;
    }

    public static void outputFile (String str, String filename){
        try {
            File output = new File(filename);
            FileWriter myWriter = new FileWriter(output);
            myWriter.write(str);
            myWriter.close();
            //System.out.println(str);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
