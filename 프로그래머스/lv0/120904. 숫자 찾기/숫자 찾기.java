class Solution {
    public int solution(int num, int k) {
        int answer = -1;
        int count = 0;
        int idx = 1;
        while(num>0){
            if(num%10==k){
                answer = ++count;
            }
            else{++count;}
            num/=10;
            idx++;
        }
        if(answer==-1){
            idx=-2;
        }
        
        return idx-answer;
    }
}