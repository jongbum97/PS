class Solution {
    public int solution(int n, int m, int[] section) {
        int[] arr = new int[n+m];
		for(int i=0; i<section.length; i++){
			arr[section[i]]++;
		}
		
		int ans = 0;
		for(int i=0; i<n+1; i++){
			if(arr[i]==1){
				for(int j=0; j<m; j++){
					arr[i+j]--;
				}
				ans++;
			}
		}
        return ans;
    }
}