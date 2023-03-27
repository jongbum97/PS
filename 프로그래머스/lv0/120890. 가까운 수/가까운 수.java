class Solution {
    public int solution(int[] array, int n) {
        int idx = 0;
        int[] arr = new int[array.length];
        for(int i=0; i<array.length; i++){
            arr[i] = array[i]-n;
        }
        for(int i=0; i<arr.length; i++){
            if(Math.abs(arr[idx])==Math.abs(arr[i])){
                idx = (arr[idx]>arr[i])? i:idx;
            }else if(Math.abs(arr[idx])>Math.abs(arr[i])){
                idx = i;
            }
        }
        
        return array[idx];
    }
}