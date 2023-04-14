import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	ArrayList<Integer> list = new ArrayList<>();
    	
    	for(int i=0; i<N; i++){
			list.add(Integer.parseInt(br.readLine()));
		}
        
        Collections.sort(list);
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int e : list) {
			bw.write(e+"\n");
		}
        bw.close();
    }
}