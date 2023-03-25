class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        int idx = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[idx]>arr[i]){
                idx=i;
            }
        }
        for(int i=0; i<arr.length; i++){
            if(i<idx)
            answer[i]=arr[i];
            else if(i>idx)
                answer[i-1]=arr[i];
            
        }
        if(answer.length==0){
            arr[0]=-1;
            return arr;
        }
        return answer;
    }
}