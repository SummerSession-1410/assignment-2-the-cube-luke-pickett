package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Cube {

	static String[][][] cube = {
			{
					{"0r", "1r", "2r"},
					{"3r", "4r", "5r"},
					{"6r", "7r", "8r"}
			},
			{
					{"0b", "1b", "2b"},
					{"3b", "4b", "5b"},
					{"6b", "7b", "8b"}
			},
			{
					{"0y", "1y", "2y"},
					{"3y", "4y", "5y"},
					{"6y", "7y", "8y"}
			},
			{
					{"0g", "1g", "2g"},
					{"3g", "4g", "5g"},
					{"6g", "7g", "8g"}
			},
			{
					{"0w", "1w", "2w"},
					{"3w", "4w", "5w"},
					{"6w", "7w", "8w"}
			},
			{
					{"0o", "1o", "2o"},
					{"3o", "4o", "5o"},
					{"6o", "7o", "8o"}
			}
	};


	static void readFace(String[][] face)
	{
		System.out.println();
		for (String[] row : face)
		{
			for (String value : row)
			{
				System.out.print(value);
			}
			System.out.println();
		}
	}

	static void rotateFace(String[][] face, boolean isClockwise)
	{
		String[][] tempFace = new String[3][3];
		for (int i=0; i<3; i++) {
			for (int j = 0; j < 3; j++) {
				tempFace[i][j] = face[i][j];
			}
		}

		// Rotates the face clockwise or counterclockwise in which faces 012345678 are rotated to 630741852
		if (!isClockwise) {
			for (int i=0; i<3; i++) {
				for (int j = 0; j < 3; j++) {
					face[i][j] = tempFace[j][i];
				}
			}
			String[] tempRow = new String[3];
			for (int k=0; k<3; k++) {
				tempRow[k] = face[0][k];
			}

			face[0] = face[2];
			face[2] = tempRow;
		}
		else {
			String[] tempRow = new String[3];
			for (int k=0; k<3; k++) {
				tempRow[k] = face[0][k];
			}

			face[0] = face[2];
			face[2] = tempRow;

			for (int i=0; i<3; i++) {
				for (int j = 0; j < 3; j++) {
					face[i][j] = tempFace[j][i];
				}
			}
			for (String[] row : face)
			{
				Collections.reverse(Arrays.asList(row));
			}
		}
	}
	public static void main(final String[] args) {
		readFace(cube[0]);
		rotateFace(cube[0], true);
		readFace(cube[0]);
		rotateFace(cube[0], false);
		readFace(cube[0]);
	}

}

