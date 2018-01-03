package com.algorithms;

public class MaxSquareInAMatrix {

	public static void main(final String[] args) {

		final int[][] arr = createSampleArray();

		final int rowCount = arr.length;
		final int columnCount = arr[0].length;

		final int[][] s = new int[rowCount][columnCount];

		// Copy first row
		for (int i = 0; i < columnCount; i++) {
			s[0][i] = arr[0][i];
		}

		// Copy first column
		for (int i = 0; i < rowCount; i++) {
			s[i][0] = arr[i][0];
		}

		// Construct other entries
		for (int i = 1; i < rowCount; i++) {
			for (int j = 1; j < columnCount; j++) {
				if (arr[i][j] == 1) {
					final int minValue = Math.min(arr[i][j - 1], Math.min(arr[i - 1][j], arr[i - 1][j - 1]));
					s[i][j] = minValue + 1;
				} else {
					s[i][j] = 0;
				}
			}
		}

		// Find the maximum value in the sub array
		int maxVal = s[0][0];
		int maxValXCoordinate = 0;
		int maxValYCoordinate = 0;
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				if (maxVal < s[i][j]) {
					maxVal = s[i][j];
					maxValXCoordinate = i;
					maxValYCoordinate = j;
				}
			}
		}

		// Get the max sub-matrix
		for (int i = maxValXCoordinate; i > maxValXCoordinate - maxVal; i--) {
			for (int j = maxValYCoordinate; j > maxValYCoordinate - maxVal; j--) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	static int[][] createSampleArray() {
		final int[][] arr = new int[4][4];
		arr[0][0] = 0;
		arr[0][1] = 1;
		arr[0][2] = 1;
		arr[0][3] = 1;

		arr[1][0] = 0;
		arr[1][1] = 1;
		arr[1][2] = 1;
		arr[1][3] = 1;

		arr[2][0] = 0;
		arr[2][1] = 0;
		arr[2][2] = 0;
		arr[2][3] = 0;

		return arr;
	}
}
