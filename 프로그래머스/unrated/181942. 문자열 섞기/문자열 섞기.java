class Solution {
    public String solution(String str1, String str2) {
        
        char[] ch1 = str1.toCharArray();
			char[] ch2 = str2.toCharArray();
			String ans = "";
			for(int i=0; i<str1.length(); i++){
				ans += ch1[i];
				ans += ch2[i];
			}
        
        return ans;
    }
}