import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [][] backboard = new int[100][100];
		int n = sc.nextInt();
		int x = 0;
		int y = 0;
		int sum = 0;
		
		for(int i=0; i<n; i++)
		{
			x = sc.nextInt();
			y = sc.nextInt();
			
			for(int j=x; j<x+10; j++)
			{
				for(int g=y; g<y+10; g++)
				{
					if(backboard[j][g] == 1)
						sum++;
					else backboard[j][g] = 1;
				}
			}
		}
		System.out.println(n*100 - sum);
	}
}