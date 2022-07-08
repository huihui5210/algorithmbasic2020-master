package JavaTest;

public interface interfaceTest {
    int a =1 ;
    public abstract String print(String test);
    //静态方法    不能有实例方法，因为不能对象化！
    public static String print1(String test){
        System.out.println(test);
        return "a";
    }
}
