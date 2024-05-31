import java.util.Scanner;

public class osero {

    public static int[][] directions = {
            { -1, -1 }, // 左下
            { 0, -1 }, // 下
            { 1, -1 }, // 右下
            { 1, 0 }, // 右
            { 1, 1 }, // 右上
            { 0, 1 }, // 上
            { -1, 1 }, // 左上
            { -1, 0 } // 左
    };

    public static int[][] board = {
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 2, 0, 0, 0 },
            { 0, 0, 0, 2, 1, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 },
    };

    // 1が黒、2が白
    public static int turn = 1;

    public static void main(String... args) {
        display_board();
        Scanner scanner = new Scanner(System.in);
        int i = 0;

        while (i < 1) {
            System.out.println("turn:" + turn);
            System.out.println("配置するマスの座標を入力してください（例:0 0）");
            int row_index = scanner.nextInt() - 1;
            int cell_index = scanner.nextInt() - 1;
            if (row_index > 7 || row_index < 0 || cell_index > 7 || cell_index < 0
                    || board[row_index][cell_index] != 0) {

                System.out.println("やり直してください");
                continue;
            }
            put_cell_on_board(row_index, cell_index);
            display_board();

            turn = 3 - turn;
            i++;
        }
        flip_cell_on_board();

        System.out.println("fin");
        scanner.close();
    }

    public static void display_board() {
        for (short i = 0; i < board.length; i++) {
            for (short x = 0; x < board.length; x++) {
                System.out.print("| ");
                if (board[i][x] == 0) {
                    System.out.print("- ");
                } else {
                    System.out.print(board[i][x] + " ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public static void put_cell_on_board(int row_index, int cell_index) {
        board[row_index][cell_index] = turn;

    }

    public static void flip_cell_on_board() {
        for (int i = 0; i < board.length; i++) {
            for (int x = 0; x < board.length; x++) {
                if (board[i][x] == 0) {
                    for (int y = 0; y < directions.length; y++) {
                        int row = i + directions[y][1];
                        int cell = x + directions[y][0];
                        if (row > 7 || row < 0 || cell > 7 || cell < 0) {
                            break;

                        }
                        
                        if(board[i][x] !=turn){
                            
                        }
                    }
                }
            }
        }
    }

}