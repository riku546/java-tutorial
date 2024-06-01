class New{
  private int num;

  public void setNum(int x){
    this.num = x;
  }

  public int getNum(){
    return this.num;
  }


}


class class_kapuseru2 {
  public static void main(String[] args) {
    New o = new New();
    o.setNum(100);
    System.out.println(o.getNum());

  }
}
