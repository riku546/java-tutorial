class New{
  private int num;
  public void setNum(int x){
    if(x > 0 && x < 100){
      this.num = x;
    }else{
      System.out.println("error");
      System.exit(0);
    }
  }

  public int getNum(){
    return this.num;
  }

}

public class class_kapuseru3 {
  public static void main(String[] args) {
    New obj = new New();
    obj.setNum(10);
    System.out.println(obj.getNum());
  }  
}
