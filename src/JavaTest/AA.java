package JavaTest;

public class AA extends A {
    public static void help(String a,String b){
        System.out.println(a+b);
    }

    public static void main(String[] args) {
        help("a");
        help("a" , "b");
        AA a = new AA();
        System.out.println(a.name);
        a.setId(2);
    }
}
