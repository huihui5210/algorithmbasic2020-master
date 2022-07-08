package class19;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class SortString {
    public static void sortAndOnly(String str){
        HashSet<Character> help = new HashSet<>();
        for (int i = 0; i<str.length() ; i++){
            help.add(str.charAt(i));
        }
        char[] chars = new char[help.size()];
        Iterator a  = help.iterator();
        int count = 0;
        while (a.hasNext()){
            chars[count++] =  (char)a.next();
        }
        Arrays.sort(chars);
        for (char c:chars){
            System.out.println(c);
        }

    }

    public static void main(String[] args) {
        String a = "aadbc";
        sortAndOnly(a);
    }
}
