import java.util.*;public class Main {public static void main(String[] args) {Scanner sc=new Scanner(System.in);int N = sc.nextInt();int[] t = new int[N];for(int i=0; i<N; i++){t[i]=sc.nextInt();}int a = 0;Arrays.sort(t);for(int i=0;i<N;i++){a+=t[i]*(N-i);}System.out.println(a);}}