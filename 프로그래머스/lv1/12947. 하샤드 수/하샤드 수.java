class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int idx = 0;
        int s = x;
        while(x>0){
            idx+=x%10;
            x/=10;
        }
        if(s%idx!=0){
            answer = false;
        }
        return answer;
    }
}