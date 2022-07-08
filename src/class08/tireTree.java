package class08;

public class tireTree {
    //默认就小写字母把
    //同一个起点， 且后续需要创建出来！
    private  Node root ;

    public tireTree() {
        root = new Node();
    }

    public  class Node {
        public int pass;
        public int end;
        public Node[] nexts;

        public Node() {
            pass = 0;
            end = 0;
            nexts = new Node[26];
        }
    }

    public  int  preStr(String  str){
        //搜索！
        if (str == null || str.length() ==0){return  0;}
        char[] chars = str.toCharArray();
            Node head = root;
        for (int  i = 0 ;i<chars.length;i++){
            if (head.nexts[chars[i] -'a'] ==null){
                return 0;
            }
            head = head.nexts[chars[i]-'a'];
        }
        return head.pass;
    }

//查这个字母出现过多少次
    public   int  searcher(String str){
        if (str == null){return  0;}
        char[] chars = str.toCharArray();
            Node head = root;
        for (int  i = 0; i<chars.length ;i++){
            int now = chars[i] - 'a' ;
            if (head.nexts[now] == null){
                return  0;
            }
            head = head.nexts[now];
        }
        return head.end;
    }

    public   void delete(String str){
        if (searcher(str) == 0 ){
            return;
        }
        char[] chars = str.toCharArray();
        Node head = root;
        head.pass--;
        //如果没有end == 0 ，就不用删除
        for (int  i = 0; i<chars.length ; i++){
            if (head.pass == 0){
                head = null;
            }
            head = head.nexts[chars[i] - 'a'];
            head.pass--;
        }
        head.end--;
    }

    public   void add(String str){
        if (str == null){return;}
        char[] chars = str.toCharArray();
        Node cur = root; //root是null吗？
        cur.pass++;
        for (int  i = 0; i<chars.length ;i++){
            int  now = chars[i] - 'a';
            if (cur.nexts[now] == null){
                Node next = new Node();
                cur.nexts[now] = next;
                cur = next;
            }else {
                cur = cur.nexts[now];
            }
            cur.pass++;
        }
            cur.end++;
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abcd";
        String str3 = "abcde";
        String str4 = "abc";
        String str5 = "abcdg";
        tireTree tireTree = new tireTree();
        tireTree.add(str1);
        tireTree.add(str2);
        tireTree.add(str3);
        tireTree.add(str4);
        tireTree.add(str5);
        System.out.println(tireTree.searcher(str1));
        tireTree.delete(str1);
        tireTree.delete(str1);
        System.out.println(tireTree.preStr("abc"));
        System.out.println(tireTree.searcher(str1));
    }


}
