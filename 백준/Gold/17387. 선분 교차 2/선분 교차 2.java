import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

	static int a[], b[], start, end;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		st = new StringTokenizer(br.readLine());
		b = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

		start = Math.max(Math.min(a[0], a[2]), Math.min(b[0], b[2]));
		end = Math.min(Math.max(a[0], a[2]),  Math.max(b[0], b[2]));
//		System.out.println(start+" ~ "+end);
//		System.out.println(function(a, start) - function(b, start));
//		System.out.println(function(a, end) - function(b, end));
//		System.out.println((function(a, start) - function(b, start)) * (function(a, end) - function(b, end)) <= 0);

		if(start > end){
			System.out.println(0);
		}else if(start == end){
			if(Math.min(Math.max(a[1], a[3]), Math.max(b[1], b[3])) >= Math.max(Math.min(a[1], a[3]), Math.min(b[1], b[3])))
				System.out.println(1);
			else
				System.out.println(0);
		}else if(function(a, start).subtract(function(b, start)).multiply(function(a, end).subtract(function(b, end))).compareTo(BigDecimal.valueOf(0)) <= 0){
			System.out.println(1);
		}else{
			System.out.println(0);
		}

	}

	static BigDecimal function(int[] arr, int x) {
		BigDecimal numerator = BigDecimal.valueOf(arr[3] - arr[1]);
		BigDecimal denominator = BigDecimal.valueOf(arr[2] - arr[0]);
		BigDecimal xMinusX0 = BigDecimal.valueOf(x - arr[0]);
		BigDecimal y1 = BigDecimal.valueOf(arr[1]);

		if (arr[2] - arr[0] == 0) return y1;

		return numerator
				.multiply(xMinusX0)
				.divide(denominator, 10, RoundingMode.HALF_UP)
				.add(y1);
	}

}
