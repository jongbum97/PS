import java.util.*;
public class Main {
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
int T=sc.nextInt();
for(int tc=1; tc<=T; tc++){
int N=sc.nextInt();int M=sc.nextInt();long a = 1;
for(int i=0; i<N; i++){a=a*(M-i)/(i+1);}
System.out.println(a);}}}