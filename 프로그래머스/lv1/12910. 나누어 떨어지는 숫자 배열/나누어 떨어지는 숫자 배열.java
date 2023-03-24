import java.util.*;
class Solution {
    public ArrayList solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>();
        int count =0;
        for(int e : arr){
            if(e%divisor==0){
                answer.add(e);
                count++;
            }
        }
        Collections.sort(answer);
        if(count==0){
            answer.add(-1);
        }
        return answer;
    }
}