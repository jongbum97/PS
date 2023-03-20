

class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] ch = new char[my_string.length()];
        for(int i =0; i<my_string.length(); i++){
            if(my_string.charAt(i)>='a' && my_string.charAt(i)<='z'){
                answer += Character.toUpperCase(my_string.charAt(i));
            } else{
                answer += Character.toLowerCase(my_string.charAt(i));
            }
            
        }
        
        return answer;
    }
}