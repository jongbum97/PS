import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] arrs) {
        int[] answer = new int[arrs.length];
        for(int i=0; i<arrs.length; i++){
			int a = arrs[i][0];
			int b = arrs[i][1];
			int c = arrs[i][2];
			int[] aaa = new int[b-a+1];
			int p = 0;
			for(int j=a-1; j<=b-1; j++){
				aaa[p++] = arr[j];
			}
			Arrays.sort(aaa);
			answer[i] = aaa[c-1];
		}
        return answer;
    }
}