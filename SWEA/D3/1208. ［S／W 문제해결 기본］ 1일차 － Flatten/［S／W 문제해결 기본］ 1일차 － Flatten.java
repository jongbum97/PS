import java.util.Scanner;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int N = sc.nextInt();
            int[] box = new int[100];
            for (int i = 0; i < 100; i++)
                box[i] = sc.nextInt();
 
            int[] height = new int[101];
            for (int i = 0; i < box.length; i++) {
                height[box[i]]++;
            }
            while (N > 0) {
                for (int i = 100; i >= 0; i--) {
                    if (height[i] != 0) {
                        height[i]--;
                        height[i-1]++;
                        break;
                    }
                }
                for (int i = 0; i <= 100; i++) {
                    if (height[i] != 0) {
                        height[i]--;
                        height[i + 1]++;
                        break;
                    }
                }
                N--;
            }
             
            int max = 100;
            for (int i = 100; i >= 0; i--) {
                if (height[i] != 0) {
                    max = i;
                    break;
                }
            }
            int min = 0;
            for (int i = 0; i <= 100; i++) {
                if (height[i] != 0) {
                    min = i;
                    break;
                }
            }
 
            System.out.println("#" + tc + " " + (max - min));
 
        }
    }
         
     
}