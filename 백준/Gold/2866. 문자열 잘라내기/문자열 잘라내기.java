import java.io.*;
import java.util.*;

public class Main {
    //R × C 행렬
    static char[][] table;
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        table = new char[R][C];
        //입력되는 행렬 값 저장
        for(int i=0;i<R;i++){
            String str = br.readLine();
            for(int j=0;j<C;j++){
                table[i][j] = str.charAt(j);
            }
        }
        //이분탐색을 통해서 Count 계산
        int result = search(R, C);
        //Count 값 BufferedWriter 저장
        bw.write(String.valueOf(result));
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //이분 탐색을 통해서 몇 번째 행까지 지울 수 있는지 확인하는 함수
    static int search(int R, int C){
        int start = 0;
        int end = R - 1;
        //이분 탐색 진행
        while(start <= end){
            int mid = (start + end) / 2;
            //mid행까지 지울 수 있을 때
            if(check(mid, R, C)){
                start = mid + 1;
            }else{	//mid행까지 지울 수 없을 때
                end = mid - 1;
            }
        }
        return start;	//Count 값
    }
    //mid행까지 지웠을 때 중복되는 문자열이 존재하는지 확인하는 함수
    static boolean check(int mid, int R, int C){
        //중복을 확인하기 위한 Set
        HashSet<String> set = new HashSet<>();
        //mid + 1 행부터 문자열 만들기 진행
        for(int i=0;i<C;i++){
            StringBuilder str = new StringBuilder();
            //문자열 만들기
            for(int j=mid+1;j<R;j++){
                str.append(table[j][i]);
            }
            //중복되는 문자열이 있을 때
            if(set.contains(str.toString())){
                return false;
            }
            //문자열 추가
            set.add(str.toString());
        }
        return true;
    }
}