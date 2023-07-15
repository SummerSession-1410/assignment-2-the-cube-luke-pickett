package com.example.project;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Cube {

	static String[][] cube = {{
					"r", "r", "r",
					"r", "r", "r",
					"r", "r", "r"
			},
			{
					"b", "b", "b",
					"b", "b", "b",
					"b", "b", "b"
			},
			{
					"o", "o", "o",
					"o", "o", "o",
					"o", "o", "o"
			},
			{
					"g", "g", "g",
					"g", "g", "g",
					"g", "g", "g"
			},
			{
					"y", "y", "y",
					"y", "y", "y",
					"y", "y", "y"
			},
			{
					"w", "w", "w",
					"w", "w", "w",
					"w", "w", "w"
			}
	};

	static class EdgedFace {
		public int current_face;
		int[] edge1 = new int[4];
		int[] edge2 = new int[4];
		int[] edge3 = new int[4];
		int[] edge4 = new int[4];

		public EdgedFace(int face) {
			current_face = face;

			switch(face)
			{
				case 0 -> {
					edge1[0] = 1;
					edge1[1] = 2;
					edge1[2] = 5;
					edge1[3] = 8;

					edge2[0] = 4;
					edge2[1] = 2;
					edge2[2] = 5;
					edge2[3] = 8;

					edge3[0] = 3;
					edge3[1] = 0;
					edge3[2] = 3;
					edge3[3] = 6;

					edge4[0] = 5;
					edge4[1] = 2;
					edge4[2] = 5;
					edge4[3] = 8;
				}
				case 1 -> {
					edge1[0] = 2;
					edge1[1] = 2;
					edge1[2] = 5;
					edge1[3] = 8;

					edge2[0] = 4;
					edge2[1] = 0;
					edge2[2] = 3;
					edge2[3] = 6;

					edge3[0] = 0;
					edge3[1] = 0;
					edge3[2] = 3;
					edge3[3] = 6;

					edge4[0] = 5;
					edge4[1] = 6;
					edge4[2] = 7;
					edge4[3] = 8;
				}
				case 2 -> {
					edge1[0] = 3;
					edge1[1] = 2;
					edge1[2] = 5;
					edge1[3] = 8;

					edge2[0] = 4;
					edge2[1] = 2;
					edge2[2] = 5;
					edge2[3] = 8;

					edge3[0] = 1;
					edge3[1] = 0;
					edge3[2] = 3;
					edge3[3] = 6;

					edge4[0] = 5;
					edge4[1] = 2;
					edge4[2] = 5;
					edge4[3] = 8;
				}
				case 3 -> {
					edge1[0] = 0;
					edge1[1] = 2;
					edge1[2] = 5;
					edge1[3] = 8;

					edge2[0] = 2;
					edge2[1] = 0;
					edge2[2] = 3;
					edge2[3] = 6;

					edge3[0] = 3;
					edge3[1] = 0;
					edge3[2] = 3;
					edge3[3] = 6;

					edge4[0] = 5;
					edge4[1] = 0;
					edge4[2] = 3;
					edge4[3] = 6;
				}
				case 4 -> {
					edge1[0] = 2;
					edge1[1] = 0;
					edge1[2] = 1;
					edge1[3] = 2;

					edge2[0] = 3;
					edge2[1] = 0;
					edge2[2] = 1;
					edge2[3] = 2;

					edge3[0] = 0;
					edge3[1] = 0;
					edge3[2] = 1;
					edge3[3] = 2;

					edge4[0] = 1;
					edge4[1] = 0;
					edge4[2] = 3;
					edge4[3] = 6;
				}
				case 5 -> {
					edge1[0] = 1;
					edge1[1] = 6;
					edge1[2] = 7;
					edge1[3] = 8;

					edge2[0] = 0;
					edge2[1] = 6;
					edge2[2] = 7;
					edge2[3] = 8;

					edge3[0] = 3;
					edge3[1] = 6;
					edge3[2] = 7;
					edge3[3] = 8;

					edge4[0] = 2;
					edge4[1] = 6;
					edge4[2] = 7;
					edge4[3] = 8;
				}
			}
		}
	}

	public void turnFace(int index, String direction) {
		EdgedFace eFace = new EdgedFace(index);

		String[][] copy = new String[6][9];

		for (int i=0; i<6; i++) {
			for (int j = 0; j < 9; j++) {
				copy[i][j] = cube[i][j];
			}
		}

		switch (direction) {
			// clockwise
			case "c" -> {
				cube[eFace.current_face][0] = copy[eFace.current_face][6];
				cube[eFace.current_face][1] = copy[eFace.current_face][3];
				cube[eFace.current_face][2] = copy[eFace.current_face][0];
				cube[eFace.current_face][3] = copy[eFace.current_face][7];
				cube[eFace.current_face][5] = copy[eFace.current_face][1];
				cube[eFace.current_face][6] = copy[eFace.current_face][8];
				cube[eFace.current_face][7] = copy[eFace.current_face][5];
				cube[eFace.current_face][8] = copy[eFace.current_face][2];

				// Edge 1
				cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
				cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
				cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

				// Edge 2
				cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
				cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
				cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];

				// Edge 3
				cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
				cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
				cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

				// Edge 4
				cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
				cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
				cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];
			}
			// counter-clockwise
			case "cc" -> {
				cube[eFace.current_face][0] = copy[eFace.current_face][2];
				cube[eFace.current_face][1] = copy[eFace.current_face][5];
				cube[eFace.current_face][2] = copy[eFace.current_face][8];
				cube[eFace.current_face][3] = copy[eFace.current_face][1];
				cube[eFace.current_face][5] = copy[eFace.current_face][7];
				cube[eFace.current_face][6] = copy[eFace.current_face][0];
				cube[eFace.current_face][7] = copy[eFace.current_face][3];
				cube[eFace.current_face][8] = copy[eFace.current_face][6];

				// Edge 1
				cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
				cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
				cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

				// Edge 2
				cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
				cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
				cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];

				// Edge 3
				cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
				cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
				cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

				// Edge 4
				cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
				cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
				cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];
			}
		}
	}

	public void showCube()
	{
		int i = 0;
		for (int x = 0; x<6; x++)
		{
			for (int y=0; y<3; y++)
			{
				for (int z=0; z<3; z++)
				{
					System.out.print(cube[x][i++]);
				}
				System.out.println();
			}
			i = 0;
			System.out.println();
		}
	}
	public static void main(final String[] args)
	throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Cube RubiksCube = new Cube();

		ArrayList<String> userCommands = new ArrayList<String>();

		boolean argsCheck = args.length > 0;
		int argsRunIndex = 0;

		boolean proceed = true;

		while(proceed)
		{
			String input;

			if(!argsCheck)
			{
				System.out.println("Enter a command: ");
				input = reader.readLine();
				if (!input.equals("s"))
				{
					userCommands.add(input);
				}
			} else {
				if (argsRunIndex == args.length)
				{
					argsCheck = false;
					input = "s";
				} else {
					input = args[argsRunIndex];
					argsRunIndex++;
				}
			}

			switch(input){
				case "u":
					RubiksCube.turnFace(4, "c");
					RubiksCube.showCube();
					break;
				case "d":
					break;
				case "r":
					RubiksCube.turnFace(0, "c");
					RubiksCube.showCube();
					break;
				case "l":
					break;
				case "f":
					break;
				case "b":
					break;
				case "u'":
					RubiksCube.turnFace(4, "cc");
					RubiksCube.showCube();
					break;
				case "d'":
					break;
				case "r'":
					RubiksCube.turnFace(0, "cc");
					RubiksCube.showCube();
					break;
				case "l'":
					break;
				case "f'":
					break;
				case "b'":
					break;
				case "s":
					System.out.println(userCommands.toString());
					System.exit(0);
					break;
				case "q":
					System.exit(0);
					break;
			}
		}

		RubiksCube.turnFace(0, "c");
		RubiksCube.showCube();
	}

}

