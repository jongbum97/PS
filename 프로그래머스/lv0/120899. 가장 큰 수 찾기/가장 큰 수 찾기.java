class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int num1 = 0;
        int idx1 = 0;
        for(int i = 0 ; i < array.length ; i++){
            if(num1<array[i]){
                num1 = array[i];
                idx1 = i;
            }
        }
        answer[0]=num1;
        answer[1]=idx1;
        
        
        
        return answer;
    }
}