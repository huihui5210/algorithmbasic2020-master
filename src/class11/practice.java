package class11;

public class practice {
    public static void print(int n){
        //需要对折n次，一共有n层
        process(n,0,false);
    }
    //中序遍历
    public static void process(int n,int index,boolean down){
        //左  false 凹
        if (n == index){
            return;
        }
        process(n,index+1 , false);
        // 右  true  凸
        String str = down? "凸": "凹";
        System.out.println(index + " " + str);
        process(n,index+1,true);
    }

    public static void main(String[] args) {
        print(3);
    }
}
