import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken())+Integer.parseInt(br.readLine());
	
		bw.write(String.valueOf((A+B/60)%24)+" "+String.valueOf(B%60));
		bw.flush();
	}
}