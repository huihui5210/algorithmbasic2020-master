package class12;

import java.util.ArrayList;
import java.util.Map;

public class PracticeIsBST1 {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int data) {
            this.value = data;
        }
    }
    //中序遍历
    public static boolean isBSTmethod1(Node head){
        if (head==null){return false;}
        ArrayList<Integer> ans =new ArrayList<>();
        process(head,ans);
        boolean flag = true;
        for (int  i = 0; i<ans.size()-1; i++){
            if (ans.get(i) >ans.get(i+1)){flag = false; break;}
        }
        return flag;
    }
    public static void process(Node head,ArrayList<Integer> ans){
        if (head == null){return;}
        process(head.left,ans);
        ans.add(head.value);
        process(head.right,ans);
    }

    public static boolean isBST(Node head){
        if (head == null){
            return true;
        }
        boolean ans = process1(head).flag;
        return ans;
    }
    //这里面的类
    //没有将所有的可能性列完   节点X需要和左树max ，右树min比较！
    public static class Info{
        Integer max;
        Integer min;
        Boolean flag;

        public Info(Integer max, Integer min, Boolean flag) {
            this.max = max;
            this.min = min;
            this.flag = flag;
        }
    }

    public static Info process1(Node head){
        //注意需要单独处理
        if (head == null){return null;}
        Info left  = process1(head.left);
        Info right = process1(head.right);
        Integer min = head.value;
        //min 是x上最小的值
        if (left !=null){
            min = Math.min(min,left.min);
        }
        if (right !=null){
            min = Math.min(min,right.min);
        }
        Integer max = head.value;
        if (right !=null){
            max = Math.max(max ,right.max);
        }
        if (left !=null){
            max = Math.max(max ,left.max);
        }

        boolean flag =true;
        if(left!=null && left.max > head.value){
            flag = false;
        }
        if(right!=null && right.min < head.value){
            flag = false;
        }
        if ( left!=null && !left.flag ){
            flag = false;
        }
        if ( right!=null && !right.flag ){
            flag = false;
        }

        return new Info(max,min,flag);
    }


    public static void main(String[] args) {
        Node head = new Node(2);
         head.left = new Node(1);
         head.right = new Node(3);
        System.out.println(isBSTmethod1(head));
        System.out.println(isBST(head));
    }
}
