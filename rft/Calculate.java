package rft;

class Calculate{
    int cube(int x){
  return x*x*x;
  }

  public  static void main(String args[]){
 // int result=Calculate.cube(5);
Calculate ob1=new Calculate();
int result=ob1.cube(5);System.out.println(result);
  }
}
