class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int num1 = -10000;
        int num2 = -10000;
        int num3 = 10000;
        int num4 = 10000;
        int idx1 = 0;
        int idx2 = 0;
        for(int i = 0 ; i < numbers.length ; i++){
            if(num1<numbers[i]){
                num1 = numbers[i];
                idx1 = i;
            }
        }
        for(int i = 0 ; i < numbers.length ; i++){
            if(i==idx1){continue;}
            if(num2<numbers[i]){
                num2 = numbers[i];
            }
        }
        for(int i = 0 ; i < numbers.length ; i++){
            if(num3>numbers[i]){
                num3 = numbers[i];
                idx2 = i;
            } 
        }
            for(int i = 0 ; i < numbers.length ; i++){
                if(i==idx2){continue;}
                if(num4>numbers[i]){
                    num4 = numbers[i];
                }
            }
        return ((num1*num2>num3*num4)? num1*num2:num3*num4);
    }
}
    