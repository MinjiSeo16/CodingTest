import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		//1. N까지 소수 구하기
		boolean[] isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i * i <= N; i++) {
			if(isPrime[i]) {
				for (int j = i * i; j <= N; j += i) {
					isPrime[j] = false;
				}
			}
		}

		List<Integer> primes = new ArrayList<>();
		for (int i = 2; i <= N; i++) {
			if(isPrime[i]) primes.add(i);
		}

		//2. 투 포인터로 소수 합 계산
		int left = 0;
		int right = 0;
		int sum = 0;
		int count = 0;

		while (true) {
			if (sum >= N) {
				//합이 N이상이면 왼쪽 포인터 이동
				if(sum == N) count++;
				sum -= primes.get(left++);
			} else {
				//합이 N보다 작으면 오른쪽 포인터 이동
				if(right == primes.size()) break;
				sum += primes.get(right++);
			}
		}

		System.out.println(count);
	}
}