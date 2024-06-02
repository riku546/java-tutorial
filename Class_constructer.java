package learn;

public class Class_constructer {
  public int num;
  public String s;

  public Class_constructer(int x) {
    this.num = x;
  }

  public Class_constructer(String x) {
    this.s = x + "desu";
  }

  public static void main(String[] args) {
    Class_constructer c = new Class_constructer(1);
    Class_constructer b = new Class_constructer("f");
    System.out.println(c.num);
    System.out.println(b.s);
  }

}
