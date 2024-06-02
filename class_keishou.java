class old {
  public int num;
}

class New extends old {
  public int num2;
}

class class_keishou {
  public static void main(String[] args) {
    New o = new New();
    o.num = 10;
    o.num2 = 11;
    System.out.println(o.num );
    System.out.println(o.num2 );
  }
}
