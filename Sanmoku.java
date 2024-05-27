import java.util.Scanner;

public class Sanmoku {
    static int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    static int turn = 2;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        print_board();
        print_turn();
        System.out.println("横,縦の数字を入力してください(例：１ 1)");


        while (!judge_victory()) {

            int[] input_nums = input_num(scanner);
            if (board[input_nums[0]][input_nums[1]] != 0) {
                System.out.println("やり直してください");
                continue;
            }
            board[input_nums[0]][input_nums[1]] = turn;
            print_board();
            print_turn();
        }

        System.out.println("fin");



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
    }

    public static int[] input_num(Scanner scanner) {
        int[] nums = new int[2];
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        nums[0] = row - 1;
        nums[1] = col - 1;

        return nums;
    }

    public static boolean judge_victory() {


        // 横と縦の３列
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != 0) {
                return true;
            }

            if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != 0) {
                return true;
            }

        }

        // 斜め
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 0) {
            return true;
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1] != 0) {
            return true;
        }



        return false;
    }

}
