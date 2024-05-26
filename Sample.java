import java.util.Random;
import java.util.Scanner;

public class Sample {
    public static void main(String[] args) {
        Random random = new Random();
        int num = random.nextInt(3);
        System.out.println("0:グー , 1:パー  , 2:チョキ");

        Scanner scanner = new Scanner(System.in);
        int input_num = scanner.nextInt();
        scanner.close();
        judgment(num, input_num);

    }

    public static void judgment(int random_num, int input_num) {
        if (random_num == input_num) {
            System.out.println("引き分け");
            return;
        }

        if (input_num == 0) {
            if (random_num == 1) {
                System.out.println("負け");

            }

            if(random_num == 2){
                System.out.println("勝ち");
            }
        }
        if (input_num == 1) {
            if (random_num == 0) {
                System.out.println("勝ち");

            }

            if(random_num == 2){
                System.out.println("負け");
            }
        }
        if (input_num == 2) {
            if (random_num == 1) {
                System.out.println("勝ち");

            }

            if(random_num == 0){
                System.out.println("負け");
            }
        }
    }

}


