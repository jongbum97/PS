class Solution {
    public int[] solution(long n) {
        long m = n;
        int length =0;
        while(m>0){
            m/=10;
            length++;
        }
        
        int[] answer = new int[length];
        
        int i = 0;
        while(n>0){
            answer[i]=(int)(n%10);
            n/=10;
            i++;
        }
        
        return answer;
    }
}