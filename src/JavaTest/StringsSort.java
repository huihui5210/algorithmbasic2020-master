package JavaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class StringsSort {
        public static void main(String[] args) throws IOException {
//            Scanner scanner = new Scanner(System.in);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str;
            while ((str = br.readLine()) != null) {
                int count = Integer.valueOf(str);
                String[] strings =new String[count];
                for (int i = 0; i<count ; i++){
                    strings[i] = br.readLine();
                }
                System.out.println(sortStrings(strings));
            }
        }

    public static String sortStrings(String[] strings) {
            Arrays.sort(strings, (str1,str2)->{
                return (str1+str2).compareTo(str2+str1);      });
            StringBuilder sb =new StringBuilder();
            for (String str: strings){
                sb.append(str);
            }
            return sb.toString();
    }

//    public static String sortString(String str){
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            StringBuilder sb = new StringBuilder();
//            for (char ch: chars){
//                sb.append(ch);
//            }
//            return sb.toString();
//        }

}


