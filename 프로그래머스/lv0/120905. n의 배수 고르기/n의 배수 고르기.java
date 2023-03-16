class Solution {
    public int[] solution(int n, int[] numlist) {
        
        int count = 0;
        int num = 0;
        for(int i =0; i<numlist.length; i++){
            if(numlist[i]%n==0){
                num++;
            }
        }
        int[] answer = new int[num];
        for(int i =0; i<numlist.length; i++){
            if(numlist[i]%n==0){
                answer[count++]=numlist[i];
            }
        }
       
        return answer;
    }
}