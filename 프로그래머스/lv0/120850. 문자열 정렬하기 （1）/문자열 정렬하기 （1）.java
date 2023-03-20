import java.util.*;

class Solution {
    public ArrayList solution(String my_string) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i<my_string.length(); i++){
            if(my_string.charAt(i)>='0' && my_string.charAt(i)<='9'){
                list.add(Integer.parseInt(my_string.charAt(i)+""));
            }
        }
        Collections.sort(list);
        
        return list;
    }
}