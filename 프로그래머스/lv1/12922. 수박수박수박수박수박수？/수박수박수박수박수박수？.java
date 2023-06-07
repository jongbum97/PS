class Solution {
    public String solution(int n) {
        String answer = "";
        int count = 0;
        while(count<n){
			if(count%2==0){
				answer += "수";
				count++;
			}else {
				answer += "박";
				count++;
			}
		}
        return answer;
    }
}