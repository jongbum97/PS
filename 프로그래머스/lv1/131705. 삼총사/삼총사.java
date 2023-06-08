class Solution {
    public int solution(int[] n) {
        int answer = 0;
        for(int i=0; i<n.length-2; i++){
			for(int j=i+1; j<n.length-1 ; j++){
				for(int k=j+1; k<n.length ; k++){
					if(n[i]+n[j]+n[k]==0){
						answer++;
					}
				}
			}
		}
        return answer;
    }
}