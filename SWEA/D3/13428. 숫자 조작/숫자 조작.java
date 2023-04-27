import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for(int t=1;t<=testcase;t++) {
            String line = sc.next();
            int min = Integer.parseInt(line);
            int max = Integer.parseInt(line);
             
            for(int i=0;i<line.length()-1;i++) {
                for(int j=i+1;j<line.length();j++) {
                    char[] arr = line.toCharArray();
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    if(arr[0]!='0') {
                        min = Math.min(min, Integer.parseInt(String.valueOf(arr)));
                        max = Math.max(max, Integer.parseInt(String.valueOf(arr)));
                    }
                }
            }
            System.out.printf("#%d %d %d\n", t, min, max);
             
        }
    }
}
