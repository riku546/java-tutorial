class old {

  public old() {
    System.out.println("引数なし");
  }

  public old(String s) {
    System.out.println(s);
  }

  public old(int x) {
    System.out.println(x);
  }

}

class New extends old {
  public New() {
    super("super");
    System.out.println("children");
  }
}

class class_keishou3 {
  public static void main(String[] args) {
    New o = new New();

  }
}
