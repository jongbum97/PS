import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; ++t) {
			String[] str = br.readLine().split(" ");
			double p = Double.parseDouble(str[0]);
			double q = Double.parseDouble(str[1]);
			String result = "YES";
			
			double s1 = (1-p)*q;
			double s2 = p*(1-q)*q;
			if(s1 >= s2) {
				result = "NO";
			}
			bw.write("#"+t+" "+result+"\n");
		}
		bw.close();
		br.close();

	}

}