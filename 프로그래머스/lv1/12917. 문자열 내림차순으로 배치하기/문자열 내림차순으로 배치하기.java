import java.util.*;
class Solution {
    public String solution(String s) {
        String ans = "";
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        for(int i=ch.length-1; i>=0; i--){
			ans += ch[i];
		}
        
        return ans;
    }
}