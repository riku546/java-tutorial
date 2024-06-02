class old{
  public void hello(){
    System.out.println("old");
  }
}

class New extends old{
  public void hello(){
    System.out.println("new");
  }
}


class class_keishou4 {
  public static void main(String[] args) {
    old o = new New();
    o.hello();
  }
}
