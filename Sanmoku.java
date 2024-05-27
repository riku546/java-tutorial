import java.util.Scanner;

public class Sanmoku {
    static int[][] board = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    static int turn = 1;


    public static void main(String[] args) {

        print_board(board);
        print_turn();
        System.out.println(input_num());

    }

    public static void print_board(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            System.out.println("-------------");
            for (int x = 0; x < board.length + 1; x++) {

                System.out.print("|   ");


            }

            System.out.println();
        }


        System.out.println("-------------");



    }

    public static void print_turn() {
        System.out.println("turn:" + turn);
        turn = 3 - turn;
    }

    public static int input_num(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();
        return num;
        
    }
}
