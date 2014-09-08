/*
 * sep 8 cci 1.6
 * test use integer number only.
 * Idea: rotate the outter most row and column in-place, and recursely rotate the inner square.
	* * * * * *
        * ------- *
        *|       |*
	*| alr r |*
	*|       |*
	* ------- *
	* * * * * *
 */

public class Rotation {
	private int[][] imageData;
	private int n; //length of the edge of the square

	public Rotation(){
		imageData = new int[][] {{1,2,3,4}, {5,6,7,8},{9, 10, 11, 12},{13, 14, 15 ,16}};
		n = 4;
	}

	public static void main(String[] args) {
		Rotation r = new Rotation();
		r.printImage();
		r.rotate(0);
		r.printImage();
		
	}


	public void printImage() {
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.print(imageData[i][j]);
			}
			System.out.println();
		}
	}

	private class Pixel {
		byte r;
		byte g;
		byte b;
		byte alpha;
	}

	public void rotate (int row) {
		//if the inner square has size larger than zero, rotate
		if ( row < n / 2)
			rotate(row + 1);
		else
			return;
		//rotate the outter most row and col
		rotateRow(row);
	}
	
	private void rotateRow(int row) {
		int temp;
		int start = row;
		int end = n - row;
		//rotate a row by 90 degree clockwise
		for ( int i = start; i < end-1; i++) {
			temp = imageData[row][i];
			imageData[row][i] 		= imageData[i][n-1-row];
			imageData[i][n-1-row]		= imageData[n-1-row][n-1-i];
			imageData[n-1-row][n-1-i] 	= imageData[n-1-i][row];
			imageData[n-1-i][row] 	= temp;	
		}
	}
}
