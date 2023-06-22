package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Cube {
	static String[][] face = {
			{"0", "1", "2"},
			{"3", "4", "5"},
			{"6", "7", "8"}
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
			System.out.println("Clockwise");
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
		readFace(face);
		rotateFace(face, true);
		readFace(face);
	}

}

