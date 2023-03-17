class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        char[] arr = new char[my_string.length()*n];
        for(int i =0; i<my_string.length()*n; i+=n){
            for(int j=0; j<n ; j++){
                arr[i+j] = my_string.charAt(i/n);
            }
        }
        for(int i=0; i<arr.length; i++){
            answer+=Character.toString(arr[i]);
        }
        return answer;
    }
}