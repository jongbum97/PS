import java.io.*;
import java.util.*;

public class Main {
	
	static int G, P, parent[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		
		parent = new int[G+1];
		for (int i = 1; i <= G; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < P; i++) {
			int a = Integer.parseInt(br.readLine());
			int p = find(a);
			if(p==0) {
				bw.write(i+"\n");
				bw.close();
				return;
			}
			union(p-1, p);
		}
		bw.write(P+"\n");
		bw.close();
		
	}
	
	static int find(int x) {
		if(parent[x]==x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		parent[y] = x;
	}
	
}