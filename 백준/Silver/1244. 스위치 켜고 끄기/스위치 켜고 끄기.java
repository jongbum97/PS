import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int switchNum,studentNum,sep,swit;
        int[] status;

        switchNum = Integer.parseInt(br.readLine());
        status = new int[switchNum+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int x = 1; x <= switchNum; x++) {
            status[x] = Integer.parseInt(st.nextToken());
        }

        studentNum = Integer.parseInt(br.readLine());

        for (int x = 0; x < studentNum; x++) {
            st = new StringTokenizer(br.readLine());

            sep = Integer.parseInt(st.nextToken());
            swit = Integer.parseInt(st.nextToken());

            if(sep==1){

                for(int y=swit;y<=switchNum;y+=swit){
                    status[y] = 1 - status[y];
                }

            }else{

                status[swit] = 1 - status[swit];

                for(int y=1;swit-y>0 && swit+y<=switchNum;y++){
                    if (status[swit - y] == status[swit + y]) {
                        status[swit - y] = 1 - status[swit - y];
                        status[swit + y] = 1 - status[swit + y];
                    } else {
                        break;
                    }
                }
            }
        }

        for (int x = 1; x <= switchNum; x++) {
            if(x!=1 && x%20==1)
                bw.write("\n");
            bw.write(String.valueOf(status[x]) + " ");
        }

        bw.flush();


    }


}