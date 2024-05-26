public class t {

    public static void calc(int[] scores) {
        int result = 0;

        for (int i = 0; i < scores.length; i++) {
            result += scores[i];
        }
        System.out.print(result / scores.length);
    }


    public static void main(String[] args) {

        int[] array = {64, 78, 94};
        calc(array);



    }



}


