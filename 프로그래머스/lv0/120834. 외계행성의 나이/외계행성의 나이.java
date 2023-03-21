class Solution {
    public String solution(int age) {
        String answer = "";
        String answer2="";
        while(age>0){
            answer+=(char)(age%10+'a');
            age/=10;
        }
        for(int i=0; i<answer.length(); i++){
            answer2+=answer.charAt(answer.length()-1-i);
        }
        return answer2;
    }
}