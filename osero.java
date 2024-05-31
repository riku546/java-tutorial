public class osero {
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
    // 0が黒、１が白
    public static int turn = 0;

    public static void main(String[] args) {
        display_board();

    }

    public static void display_board(){
        for (short i = 0; i< board.length ; i++){
            for (short x = 0; x< board.length ; x++){
                System.out.print("| ");
                if(board[i][x] == 0){
                    System.out.print("- ");
                }else{
                    System.out.print(board[i][x] + " ");
                }
            }
            System.out.print("|");    
            System.out.println();        
        }
    }

}