/*
 * Sep 9 cci 1.7
 */

public class Matrix {
	public static void main(String[] args) {
		Matrix m = new Matrix(5, 7);
		m.init();
		m.print();
		m.setZero(3,4);
		m.print();		
	}

	private int[][]  matrix;
	private int n, m;

	public Matrix(int n, int m) {
		matrix = new int[n][m];
		this.n = n;
		this.m = m;
	}

	public boolean setZero(int x, int y) {
		if (x < 0 || x > n || y < 0 || y > m)
			return false;

		for (int i = 0; i < n; i++)
			matrix[i][y] = 0;
		
		for (int i = 0; i < m; i++)
			matrix[x][i] = 0;
		
		return true;
	}

	public void init() {
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = i*j+1;
			}
		}
	}

	public void print() {
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
}	
	
