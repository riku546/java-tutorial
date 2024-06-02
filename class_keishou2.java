class old{
  public old(){
    System.out.println("superclass");
  }
}

class New extends old{
  
  public New(){
    System.out.println("childrenclass");
  }

}

class class_keishou2 {
  public static void main(String[] args) {
    New o = new New();
    
  }
  
}
