import java.util.Scanner;

public class Sanmoku {
    static int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    static int turn = 2;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        print_board();
        print_turn();

        for (int i = 0; i < 9; i++) {
            int[] input_nums = input_num(scanner);
            board[input_nums[0]][input_nums[1]] = turn;
            print_board();
            print_turn();
        }

        scanner.close();

    }

    public static void print_board() {

        for (int i = 0; i < board.length; i++) {
            System.out.println("-------------");
            for (int x = 0; x < board.length; x++) {
                if (board[i][x] == 0) {
                    System.out.print("| ");
                    System.out.print("- ");
                    if (x == 2) {
                        System.out.print("|");
                    }

                } else if (board[i][x] != 0) {
                    System.out.print("| ");
                    System.out.print(board[i][x] + " ");
                    if (x == 2) {
                        System.out.print("|");
                    }
                }

            }

            System.out.println();
        }


        System.out.println("-------------");
        turn = 3 - turn;



    }

    public static void print_turn() {
        System.out.println("turn:" + turn);
        // turn = 3 - turn;
    }

    public static int[] input_num(Scanner scanner) {
        int[] nums = new int[2];
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        nums[0] = row - 1;
        nums[1] = col - 1;

        return nums;
    }

}
