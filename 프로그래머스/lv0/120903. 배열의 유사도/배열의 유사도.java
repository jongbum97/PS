class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for(String a1 : s1){
            for(String a2 : s2){
                if(a1.equals(a2))
                    answer++;
            }
        }
        return answer;
    }
}