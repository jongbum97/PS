class Solution {
    public long solution(long a, long b) {
        long answer = 0;
        if(a>b){
            for(long i=0; i<=a-b ; i++){
                answer+=b+i;
            }
        }
        else if(a<b){
            for(long i=0; i<=b-a ; i++){
                answer+=a+i;
            }
        }
        else{
            answer=a;
        }
        return answer;
    
    }
}