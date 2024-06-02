
import java.util.Random;
import java.util.Scanner;

public class Main {

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

    public static int[][] Bomb_board = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    };

    public static int[][] User_inputs = {
            { -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1, -1, -1, -1 },
    };

    public static boolean is_first_click = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        display_board();

        while (is_clear() != 10) {

            int input_row = scanner.nextInt() - 1;
            int input_cell = scanner.nextInt() - 1;

            if (is_first_click) {
                put_bomb(input_row, input_cell);
                count_bomb();
                is_first_click = false;
            }

            if (open_cell(input_row, input_cell)) {
                System.out.println("GameOver");
                open_bomb_cell();
                display_board();
                scanner.close();
                return;
            }

            display_board();

        }
        System.out.println("Clear");
        scanner.close();
    }

    public static void open_bomb_cell(){
        for (int i = 0; i < User_inputs.length; i++) {
            for (int x = 0; x < User_inputs.length; x++) {
                if (Bomb_board[i][x] == 11) {
                    User_inputs[i][x] = 11;
                }
            }
        }

    }

    public static int is_clear() {
        int count = 0;
        for (int i = 0; i < User_inputs.length; i++) {
            for (int x = 0; x < User_inputs.length; x++) {
                if (User_inputs[i][x] == -1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void display_board() {
        System.out.println("───────────────────────────────────────────────────────");
        for (short i = 0; i < User_inputs.length; i++) {
            for (short x = 0; x < User_inputs.length; x++) {
                System.out.print("┃  ");
                if (User_inputs[i][x] == -1) {
                    System.out.print("-  ");
                } else if (User_inputs[i][x] == 11) {
                    System.out.print("💣️ ");
                } else {
                    System.out.print(User_inputs[i][x] + "  ");
                }
            }
            System.out.print("┃");
            System.out.println();
            for (short y = 0; y < User_inputs.length; y++) {
                System.out.print("┃     ");
            }
            System.out.print("┃");
            System.out.println();
        }
        System.out.println("───────────────────────────────────────────────────────");

    }

    public static void put_bomb(int input_row, int input_cell) {
        int count = 0;
        Random rand = new Random();

        while (count < 10) {

            int row_index = rand.nextInt(8);
            int cell_index = rand.nextInt(8);
            if (row_index != input_row && cell_index != input_cell && Bomb_board[row_index][cell_index] != 11) {
                Bomb_board[row_index][cell_index] = 11;
                count++;

            }
        }

    }

    public static void count_bomb() {
        for (int row_index = 0; row_index < Bomb_board.length; row_index++) {
            for (int cell_index = 0; cell_index < Bomb_board.length; cell_index++) {
                int count = 0;
                if (Bomb_board[row_index][cell_index] == 0) {
                    for (int y = 0; y < directions.length; y++) {
                        int di_row_index = row_index + directions[y][1];
                        int di_cell_index = cell_index + directions[y][0];

                        if (di_cell_index > 8 || di_cell_index < 0 || di_row_index > 8 || di_row_index < 0)
                            continue;

                        if (Bomb_board[di_row_index][di_cell_index] == 11) {
                            count++;
                        }

                    }
                    Bomb_board[row_index][cell_index] = count;
                }
            }
        }
    }

    public static boolean open_cell(int input_row, int input_cell) {

        if (Bomb_board[input_row][input_cell] == 0) {
            chain_open_empty_cell(input_row, input_cell);
            chain_open_number_cell();

        } else if (Bomb_board[input_row][input_cell] == 11) {
            return true;

        } else {

            User_inputs[input_row][input_cell] = Bomb_board[input_row][input_cell];
        }
        return false;

    }

    public static void chain_open_empty_cell(int input_row, int input_cell) {
        for (int i = 0; i < directions.length; i++) {
            int di_row_index = input_row + directions[i][1];
            int di_cell_index = input_cell + directions[i][0];
            if (di_cell_index > 8 || di_cell_index < 0 || di_row_index > 8 || di_row_index < 0)
                continue;

            if (Bomb_board[di_row_index][di_cell_index] == 0 && User_inputs[di_row_index][di_cell_index] == -1) {
                User_inputs[di_row_index][di_cell_index] = 0;
                chain_open_empty_cell(di_row_index, di_cell_index);
            }

        }
    }

    public static void chain_open_number_cell() {
        for (int i = 0; i < Bomb_board.length; i++) {
            for (int x = 0; x < Bomb_board.length; x++) {
                if (Bomb_board[i][x] > 0 && Bomb_board[i][x] < 11) {
                    for (int y = 0; y < directions.length; y++) {
                        int di_i = i + directions[y][1];
                        int di_x = x + directions[y][0];
                        if (di_i > 8 || di_i < 0 || di_x > 8 || di_x < 0)
                            continue;

                        if (User_inputs[di_i][di_x] == 0) {
                            User_inputs[i][x] = Bomb_board[i][x];
                        }
                    }
                }
            }
        }

    }

}