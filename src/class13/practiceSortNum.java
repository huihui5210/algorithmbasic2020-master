package class13;

import java.util.Arrays;

public class practiceSortNum {

    public static String sortNum(String[] strings){

        Arrays.sort(strings, (str1,str2)->{
            if (str1.charAt(0) < str2.charAt(0)){
                return -1;
            }else if (str1.charAt(0) == str2.charAt(0)){
                return   compare(str1,str2);
            }else{
                return 1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : strings){
            sb.append(s);
        }
        return  sb.toString();
    }
    public static int compare(String str1,String str2){
        String s1 = str1 + str2;
        String s2 = str2 + str1;
        return s1.compareTo(s2);
    }


    public static void main(String[] args) {
        String[] strings = new String[]{ "ca","a" , "ab" , "c"};
        System.out.println(sortNum(strings));
    }
}
