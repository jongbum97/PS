import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int T;
    static int[] a;
    static boolean[] visited;
    static int[] dy = new int[]{0, -1, 0, 1};
    static int[] dx = new int[]{1, 0, -1, 0};

    static int NSize = 51;
    static int[][][] check = new int[NSize][NSize][4];
    static char[][] input = new char[NSize][NSize];
    static int N;
    static int startY, startX, endY, endX;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(bf.readLine());
            String a = st.nextToken();
            input[i] = a.toCharArray();
        }

        //init check array.
        for (int i = 0 ; i < NSize ; i++) {
            for (int j = 0 ; j < NSize ; j++) {
                for (int k = 0 ; k < 4 ; k++) {
                    check[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        boolean flag = false;
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                if (input[i][j] == '#' && !flag) {
                    input[i][j] = '.';
                    startY = i;
                    startX = j;
                    flag = true;
                } else if (input[i][j] == '#' && flag) {
                    input[i][j] = '.';
                    endY = i;
                    endX = j;
                }
            }
        }

        bfs();
        System.out.println(min);
    }

    static void bfs() {
        Queue<Data> q = new LinkedList<>();

        for (int dir = 0 ; dir < 4 ; dir++) {
            q.add(new Data(startY, startX, dir, 0));
        }

        while(!q.isEmpty()) {
            Data current = q.poll();

            if (current.y == endY && current.x == endX) {
                if (min > current.count) min = current.count;
            }
            int thereY = current.y + dy[current.dir];
            //ex) current.dir방향이 '아래'였으면 1,0만큼 좌표가 움직여야 함.
            //    이 만큼 인접 정점으로 움직인 결과가 there임
            int thereX = current.x + dx[current.dir];
            int thereDir = current.dir;
            int thereCount = current.count;

            if (!isValid(thereY, thereX)) continue;

            if (input[thereY][thereX] == '!') {
                int dir = thereDir; // "/ 대각선"
                if (dir == 0) dir = 3;
                else if (dir == 1) dir = 2;
                else if (dir == 2) dir = 1;
                else if (dir == 3) dir = 0;
                if (check[thereY][thereX][dir] > thereCount + 1) {
                    check[thereY][thereX][dir] = thereCount + 1;
                    q.add(new Data(thereY, thereX, dir, thereCount + 1));

                }

                dir = thereDir;// "\ 대각선"
                if (dir == 0) dir = 1;
                else if (dir == 1) dir = 0;
                else if (dir == 2) dir = 3;
                else if (dir == 3) dir = 2;
                if (check[thereY][thereX][dir] > thereCount + 1) {
                    check[thereY][thereX][dir] = thereCount + 1;
                    q.add(new Data(thereY, thereX, dir, thereCount + 1));
                }
            }
                
            if (check[thereY][thereX][thereDir] > thereCount) {
                check[thereY][thereX][thereDir] = thereCount;
                q.add(new Data(thereY, thereX, thereDir, thereCount));
            }
        }
    }

    static class Data {
        int y, x, dir, count;

        Data(int y, int x, int dir, int count) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.count = count;
        }
    }

    static boolean isValid(int y, int x) {
        if ((y >= 0 && y < N && x >= 0 && x < N) && input[y][x] != '*') return true;
        else return false;
    }
}