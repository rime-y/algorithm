import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	// 2147483647 2147483647 100001
	// 나머지 연산 필요 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] abc = br.readLine().split(" ");
		long A = Long.parseLong(abc[0]);
		long B = Long.parseLong(abc[1]);
		long C = Long.parseLong(abc[2]);

		System.out.println((long) (fastPow(A%C, B, C) % C ));
	}

	static long fastPow(long c, long n, long c2) {
		long res = 1;
		while (n > 0) {
			if (n % 2 == 1)
				res = (res%c2 * c%c2) %c2;
			c = (c%c2 * c%c2)%c2;
			n /= 2;
		}
		return res;
	}
}
