class Test{
  int id;
  int num;
  int max;
  public static void main(String[] args) {

    Runtime r = Runtime.getRuntime();

    System.out.println(r.maxMemory() / 1024);


    int a = 30000000;
    Test t[] = new Test[a];

    for(int i = 0; i < a; i++){
      t[i] = new Test();


    }
    Runtime s = Runtime.getRuntime();

    System.out.println(s.freeMemory() / 1024);

  }
}
