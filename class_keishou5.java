class old{
  public void  hello(){
    System.out.println("super");
  }
}

class New extends old{
  public void hello(){
    System.out.println("children");
  }
}


class class_keishou5 {
  public static void main(String[] args) {
    old [] a = new old[2];
    a[0] = new old();
    a[1] = new New();

    for(int i = 0; i < 2 ; i++){
      a[i].hello();
    }
  }
}
