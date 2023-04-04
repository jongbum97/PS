import java.util.*;

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();

		int[] arr = { Math.abs(x - 0), Math.abs(x - w), Math.abs(y - 0), Math.abs(y - h) };

		Arrays.sort(arr);

		System.out.println(arr[0]);

	}
}
