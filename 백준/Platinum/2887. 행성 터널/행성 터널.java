import java.io.*;
import java.util.*;

public class Main {
	
	static int N, p1, p2, p3, M=Integer.MAX_VALUE, parent[];
	static Planet px[], py[], pz[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		px = new Planet[N];
		py = new Planet[N];
		pz = new Planet[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			px[i] = py[i] = pz[i] = new Planet(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(px, (a,b)->a.x-b.x);
		Arrays.sort(py, (a,b)->a.y-b.y);
		Arrays.sort(pz, (a,b)->a.z-b.z);
		
		PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[2]-b[2]);
		
		for (int i = 0; i < N-1; i++) {
			Planet p1 = px[i];
			Planet p2 = px[i+1];
			queue.add(new int[] {p1.num, p2.num, Math.abs(p1.x-p2.x)});
		}
		for (int i = 0; i < N-1; i++) {
			Planet p1 = py[i];
			Planet p2 = py[i+1];
			queue.add(new int[] {p1.num, p2.num, Math.abs(p1.y-p2.y)});
		}
		for (int i = 0; i < N-1; i++) {
			Planet p1 = pz[i];
			Planet p2 = pz[i+1];
			queue.add(new int[] {p1.num, p2.num, Math.abs(p1.z-p2.z)});
		}
		
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		
		int ans = 0;
		for (int i = 0; i < N-1; i++) {
			
			while (true) {
				int[] tmp = queue.remove();
				int a = find(tmp[0]);
				int b = find(tmp[1]);
				if(a==b) continue;
				union(a, b);
				ans += tmp[2];
				break;
			}
			
		}
		
		System.out.println(ans);
		
	}

	static int find(int n) {
		if(parent[n]==n) return n;
		return parent[n] = find(parent[n]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		parent[a] = b;
	}
	
	

}
class Planet{
	int num;
	int x;
	int y;
	int z;
	Planet(int num, int x, int y, int z){
		this.num = num;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	public String toString() {
		return "[num=" + num + ", x=" + x + ", y=" + y + ", z=" + z + "]";
	}
}