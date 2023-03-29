class Solution {
    public String solution(String s) {
        String answer = "";
        int N = s.length();
        if(N%2==0){
            answer = s.charAt(N/2-1)+""+s.charAt(N/2);
        } else{
            answer = s.charAt(N/2)+"";
        }
            
        return answer;
    }
}