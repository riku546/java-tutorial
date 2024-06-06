abstract class Animal{
  abstract void speak();
}

class Dog extends Animal{
  public void speak(){
    System.out.println("wanwan");
  }
}

class cat extends Animal{
  public void speak(){
    System.out.println("kyato");
  }
}

class class_tyoushou {
  public static void main(String[] args) {
    Animal[] a = new Animal[2];
    a[0] = new Dog();
    a[1] = new cat();

    for (int i = 0; i < a.length; i++){
      a[i].speak();
    }


  }
}
