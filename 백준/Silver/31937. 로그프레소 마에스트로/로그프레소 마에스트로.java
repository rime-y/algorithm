import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] isVirus = new boolean[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<K;i++) {
			isVirus[Integer.parseInt(st.nextToken())] = true;
		}
		List<int[]> logs = new ArrayList<>();
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			logs.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
//		logs.sort(Comparator.comparingInt(arr -> arr[0]));
		logs.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		for(int i = 1;i<=N;i++) {
			if(!isVirus[i]) continue;
			
			boolean[] getVirus = new boolean[N+1];
			getVirus[i] = true;
			int count = 1;
			for(int j = 0;j<M;j++) {
				if(getVirus[logs.get(j)[1]]) {
					if(!isVirus[logs.get(j)[2]]) { // 비적합
						count = -1;
						break;
					}
					if(!getVirus[logs.get(j)[2]] && isVirus[logs.get(j)[2]]) { // 적합
						getVirus[logs.get(j)[2]] = true;
						count++;
					}
				}
				
			}
			
			if(count == K) {
				bw.write(String.valueOf(i));
				break;
			}
		}
		
		bw.flush();
		
	}
}