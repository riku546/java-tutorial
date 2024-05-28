class Student {
    public int num;
}

public class yotube_class {
    public static void main(String[] args) {
        Student tarou = new Student();
        tarou.num = 10;
        show(tarou);
        tarou.num = 20;
        System.out.println(tarou.num);
        

    }

    public static void show(Student x){
        System.out.println(x.num);
    }
}
