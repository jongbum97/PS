class Solution {
    public long solution(String t, String p) {
        long answer = 0;
        long tl = t.length();
        long pl = p.length();
        long a = Long.parseLong(p);
        
        for(int i=0; i<tl-pl+1; i++){
        	StringBuilder sb = new StringBuilder();
			for(int j=i; j<i+pl; j++){
				sb.append(t.charAt(j));
			}
			long b = Long.parseLong(sb.toString());
			if(b<=a){
				answer++;
			}
		}
        
        return answer;
    }
}