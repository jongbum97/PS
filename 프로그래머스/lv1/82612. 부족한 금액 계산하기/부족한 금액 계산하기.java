class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long T = (count+1)*count/2;
        
        answer = (money > T*price)? 0:T*price-money;
        
        
        
        
        
        
        return answer;
    }
}