package JavaTest;

import java.util.Arrays;
import java.util.Scanner;

public class StringSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.next();
            System.out.println(sortString(str));
        }
    }

    public static String sortString(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        for (char ch: chars){
            sb.append(ch);
        }
        return sb.toString();
    }

}
