class Solution {
    public int solution(String s) {
        String answer;
        if(s.contains("+")){
            answer = s.substring(1,s.length());
            return Integer.parseInt(answer);
        }else if(s.contains("-")){
            answer = s.substring(1,s.length());
            return -1*Integer.parseInt(answer);
        }else{
            return Integer.parseInt(s);
        }
        
    }
}