import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 계단 수
        int[] score = new int[n + 1]; //계단의 점수를 저장할 배열
        int[] dp = new int[n + 1]; //i번째 계단까지 왔을 때 얻을 수 있는 최대 점수 저장

        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine()); // 계단 점수
        }
 
        dp[1] = score[1]; //계단이 1칸일 때 최대 점수
        if (n >= 2) dp[2] = score[1] + score[2]; //계단이 2칸일 때 최대 점수

        for (int i = 3; i <= n; i++) { //3번째 계단부터 최대 점수
            //1. n번째까지 한 칸(n-1) 건너뛰기
            //2. 한 칸 두 번 연속 밟기(n-1, n)
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + score[i - 1]) + score[i];
        }

        System.out.println(dp[n]);
    }
}