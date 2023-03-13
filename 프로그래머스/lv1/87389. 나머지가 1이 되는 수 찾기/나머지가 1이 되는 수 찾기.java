class Solution {
    public int solution(int n) {
        int answer = 1000000;
        for(int i=n; i>1; i-- ){
            if(n%i==1){
                answer = (answer<i)? answer:i;
            }
        }
        return answer;
    }
}