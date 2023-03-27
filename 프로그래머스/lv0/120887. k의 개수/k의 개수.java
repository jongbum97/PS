class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int t = i ; t <= j ; t++){
            int num = t;
            while(num>0){
                if(num%10==k) answer++;
                num/=10;
            }
        }
        return answer;
    }
}