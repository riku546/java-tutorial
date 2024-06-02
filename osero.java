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

        while (!check_finished()) {
            System.out.println("turn:" + (turn == 1 ? "⚫️" : "⚪️"));
            System.out.println("配置するマスの座標を入力してください（例:1 1）");
            int row_index = scanner.nextInt() - 1;
            int cell_index = scanner.nextInt() - 1;
            if (row_index > 7 || row_index < 0 || cell_index > 7 || cell_index < 0
                    || board[row_index][cell_index] != 0) {

                System.out.println("やり直してください");
                continue;
            }
            put_cell_on_board(row_index, cell_index);
            flip_cell_on_board(row_index, cell_index);
            display_board();

            turn = 3 - turn;
        }

        System.out.println("fin");
        scanner.close();
    }

    public static boolean check_finished() {
        for (int i = 0; i < board.length; i++) {
            for (int x = 0; x < board.length; x++) {
                if (board[i][x] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void display_board() {
        System.out.println("─────────────────────────────────────────────────");
        for (short i = 0; i < board.length; i++) {
            for (short x = 0; x < board.length; x++) {
                System.out.print("┃  ");
                if (board[i][x] == 0) {
                    System.out.print("-  ");
                } else if (board[i][x] == 1) {
                    System.out.print("⚫️" + " ");
                } else {
                    System.out.print("⚪️" + " ");

                }
            }
            System.out.print("┃");
            System.out.println();
            for (short y = 0; y < board.length; y++) {
                System.out.print("┃     ");
            }
            System.out.print("┃");
            System.out.println();
        }
        System.out.println("─────────────────────────────────────────────────");

    }

    public static void put_cell_on_board(int row_index, int cell_index) {
        board[row_index][cell_index] = turn;

    }

    public static void flip_cell_on_board(int row_index, int cell_index) {
        for (int i = 0; i < directions.length; i++) {
            int extension_cell = cell_index + directions[i][1];
            int extension_row = row_index + directions[i][0];
            if (extension_cell > 7 || extension_cell < 0 || extension_row < 0 || extension_row > 7) {
                continue;
            }
            if (board[extension_row][extension_cell] == 3 - turn) {
                extend_fliping_cell(i, extension_cell, extension_row, row_index, cell_index);
            } else {
                continue;
            }

        }
    }

    public static void extend_fliping_cell(int i, int extension_cell, int extension_row, int row_index,
            int cell_index) {

        int count = 1;
        while (true) {

            extension_row += directions[i][0];
            extension_cell += directions[i][1];
            if (extension_cell > 7 || extension_cell < 0 || extension_row < 0 || extension_row > 7 || board[extension_row][extension_cell] == 0) {
                return;
            }



            if (board[extension_row][extension_cell] == turn) {
                for (int s = 0; s < count; s++) {
                    cell_index += directions[i][1];
                    row_index += directions[i][0];

                    board[row_index][cell_index] = turn;

                }
                return;
            }



            count++;

        }

    }

}