class Solution {
    public String solution(String my_string, int s, int e) {
        
        char[] ch = my_string.toCharArray();
        String ans = "";
        for(int i=0; i<s; i++){
				ans += ch[i];
			}
			for(int i=e; i>=s; i--){
				ans += ch[i];
			}
			for(int i=e+1; i<ch.length; i++){
				ans += ch[i];
			}
        
        return ans;
    }
}