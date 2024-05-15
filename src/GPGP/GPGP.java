package GPGP;

import java.util.LinkedList;
import java.util.Queue;

public class GPGP {
	static int minIndex(int numbers[],boolean visited[]) {
		int minValue = 999;
		int minIndex = 0;
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] < minValue && !visited[i]) {
				minValue = numbers[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	//TODO visited dect

	public static void main(String[] args) {
		int gp[][] = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				gp[i][j] = 0;
			}
		}
		gp[1][0] = 4;
		gp[0][1] = 4;

		gp[0][2] = 2;
		gp[2][0] = 2;

		gp[2][3] = 2;
		gp[3][2] = 2;

		gp[2][5] = 4;
		gp[5][2] = 4;

		gp[3][4] = 3;
		gp[4][3] = 3;

		gp[1][4] = 3;
		gp[4][1] = 3;

		gp[3][5] = 1;
		gp[5][3] = 1;

		gp[5][4] = 1;
		gp[4][5] = 1;

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(gp[i][j]);
				if (j == 5)
					System.out.println("");

			}
		}

		boolean[] visited = new boolean[6];

		int[] length = new int[6];

		for (var i=0;i<length.length;i++) {
			length[i] = 99;
		}

		int[] path = new int[6];

		Queue<Integer> q = new LinkedList<Integer>();

		visited[0] = true;

		length[0] = 0;

		path[0] = 0;

		q.add(0);

		while (!q.isEmpty()) {
			int top = q.remove();
			visited[top] = true;
			if(path[5]==5)
				break;
			for (int i = 0; i < 6; i++) {
				if (gp[top][i] > 0 && visited[i] == false) {
					if (gp[top][i] + length[top] < length[i]) {//original gp[top][i] + length[path[i]] < length[i]

						path[i] = top;
						length[i] = gp[top][i] + length[path[i]];
					}
				}
			}
			q.add(minIndex(length,visited));

		}
		for (var i=0;i<length.length;i++) {
			System.out.print(length[i]);
		}

	}
}
