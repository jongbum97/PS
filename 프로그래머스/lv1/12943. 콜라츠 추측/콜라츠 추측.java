class Solution {
    public int solution(long num) {
        int answer = -1;
        int count = 0;
        if(num==1){
            answer = 0;
        }
        else{
            while(count++<500 && num!=1){
                if(num%2==0){
                    num = num/2;
                }
                else{
                 num = num*3+1;
                }
            
            }
              if(num==1){
            answer = count-1;
        }
      
        }
        return answer;
    }
}