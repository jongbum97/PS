class Solution {
    public long solution(long n) {
        long answer = -1;
        for(long i=1; i<=Math.pow(n,0.5); i++){
            if(Math.pow(i,2)==n){
                answer=(long)Math.pow(i+1,2);
            }
        }
        return answer;
    }
}