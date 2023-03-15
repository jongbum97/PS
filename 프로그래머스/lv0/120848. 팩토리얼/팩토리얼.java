class Solution {
    public int solution(int n) {
        int answer = 0;
        int num =1;
        int i = 2;
        while(num<=n){
            num=num*(i++);
        }
        return i-2;
    }
}