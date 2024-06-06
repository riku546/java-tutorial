abstract class animal{
  abstract void speak();
}

class Dog extends animal{
  public void speak(){
    System.out.println("wanwan");
  }
}

class cat extends animal{
  public void speak(){
    System.out.println("nyun");
  }
}

class class_tyousouka {
  public static void main(String[] args) {
    Dog d = new Dog();
    cat c = new cat();

    d.speak();
    c.speak();
  }
}
