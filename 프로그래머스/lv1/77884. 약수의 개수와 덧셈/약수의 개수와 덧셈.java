class Solution {
    public int solution(int left, int right) {
        int ans = 0;
        for(int i=left; i<=right; i++){
        	int count = 0;
			for(int j=1; j<=i; j++){
				if(i%j==0){
					count++;
				}
			}
			if(count%2==0){
				ans += i;
			}else {
				ans -= i;
			}
		}
        
        
        return ans;
    }
}