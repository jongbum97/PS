import java.util.*;
class Solution
{public static void main(String args[]) throws Exception
{Scanner s = new Scanner(System.in);
int T = s.nextInt();
for(int t=1; t<=T; t++){
String r = s.next();
int a = 0;
for(int i=0; i<r.length(); i++){
if(r.charAt(i)==i+'a'){
a++;}else {break;}}
System.out.println("#"+t+" "+a);}}}