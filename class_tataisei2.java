class old {
  public void hello(){
    System.out.println("old");
  }
}

class New extends old {
  public void hello(){
    super.hello();
    System.out.println("new");
  }
}

class class_tataisei2 {
  public static void main(String[] args) {
    New n = new New();
    n.hello();

  }
  
}
