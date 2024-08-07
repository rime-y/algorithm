import java.io.*;
import java.util.*;

public class Main {
	static boolean flag;
	static int N, M, ri, rj, bi, bj, oi, oj;
	static char[][] map;
	static int[] dr = {0,0,-1,1}, dc = {-1,1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i = 0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j =0;j<M;j++) {
				if(map[i][j] == 'R') { ri = i; rj = j; map[i][j] ='.'; }
				else if(map[i][j] == 'B') { bi = i; bj = j; map[i][j] = '.';}
				else if(map[i][j] == 'O'){ oi = i; oj = j; }
			}
		}
		
		//모든 경우 탐색
		//각경우마다 이동하여 유효성 판단
		dfs(0, ri*M+rj, bi*M+bj);
		
		bw.write(flag? "1":"0");
		bw.flush();
	}
	
	static void dfs(int count, int rCor, int bCor) {
		// r, b 좌표로 위치 관리
		if(count == 10 || flag)  return;
		
		// d 0왼쪽 1오른쪽 2위쪽 3오른쪽 
		for(int d = 0;d<4;d++) {
			int[] rs = move(d, rCor, bCor);
			if(rs[0] == 0) {
				dfs(count+1, rs[1], rs[2]);
			} else if(rs[0] == 1) {
				flag = true;
                return;
			}
		}
	}
	
	static int[] move(int d, int rCor, int bCor) {
		// return -1:실패/움직이지않음 0:이동완료 1:종료 
		boolean rStop = false, bStop = false, success = false;
		int crr = rCor / M, crc = rCor % M, cbr = bCor / M, cbc = bCor % M;
		while(!rStop || !bStop) {
			int nrr = crr + dr[d], nrc = crc+dc[d], nbr = cbr+dr[d], nbc = cbc+dc[d];
			if(map[nrr][nrc] == '#') {nrr = crr; nrc = crc; rStop = true;}
			if(map[nbr][nbc] == '#') {nbr = cbr; nbc = cbc; bStop = true;}
			if(!rStop) { //r 전진함
				if (nrr == nbr && nrc == nbc) {
					rStop = true;
				} else if (map[nrr][nrc] == '.') {
					crr = nrr; crc = nrc;
				} else if(map[nrr][nrc] == 'O') {
					rStop = true;
					success = true;
				}
			}
			
			if(!bStop) { //b 전진함
				if (nrr == nbr && nrc == nbc && !success) {
					bStop = true;
				} else if (map[nbr][nbc] == '.') {
					cbr = nbr; cbc = nbc;
				} else if(map[nbr][nbc] == 'O') {
					return new int[] {-1, nrr, nrc, nbr, nbc};
				}
			}
		}
		
		if(success) return new int[] {1, crr*M+crc, cbr*M+cbc};
		int r = crr*M+crc, b = cbr*M+cbc;
		return new int[] {rCor == r && bCor == b? -1:0, r, b};
	}
	
	
}