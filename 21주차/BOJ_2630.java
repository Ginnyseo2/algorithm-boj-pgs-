import java.util.*;
public class BOJ_2630 {
	static int[][] paper;
	static int white, blue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		paper = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		
		calculation(0, 0, N);

		System.out.println(white);
		System.out.println(blue);
	}

	private static void calculation(int row, int col, int N) {
		if (check(row, col, N)) {
			if (paper[row][col] == 0) {
				white++;
			}
			else {
				blue++;
			}
			return;
		}
		
		int size = N / 2;
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				calculation(row + i * size, col + j * size, size);
			}
		}
		
	}

	private static boolean check(int row, int col, int N) {
		int color = paper[row][col];
		
		//해당 범위에서 색이 다 같으면 true, 하나라도 다르면 false 반환
		for (int i = row; i < row + N; i++) {
			for (int j = col; j < col + N; j++) {
				if (color != paper[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
