

import java.util.Scanner;

public class exercise3 {
	public static void error_message() {
		System.out.print("You typed incorrect cordinate of the point. Should be like a4");
	}

	public static int[] get_cordinate(String s) {
		int x = s.charAt(0) - 'a' + 1;
		if (x > 8 || x < 1) {
			error_message();
			return null;
		}
		int y = s.charAt(1);
		if (y < '1' || y > '9') {
			error_message();
			return null;
		}
		return new int[]{x, Character.getNumericValue(y)};
	}

	public static void main(String[] argv) {

		Scanner scaner = new Scanner(System.in);

		System.out.print("Enter cordinate of first point(ex: a4): ");
		String p1 = scaner.nextLine();

		System.out.print("Enter cordinate of second point(ex: h6): ");
		String p2 = scaner.nextLine();

		if (p1.length() != 2 || p2.length() != 2) {
			error_message();
		} else {
			int[] cor1 = get_cordinate(p1);
			int[] cor2 = get_cordinate(p2);

			if (cor1 != null && cor2 != null) {
                int x1 = cor1[0];
                int y1 = cor1[1];
                int x2 = cor2[0];
                int y2 = cor2[1];

                int xDifference = Math.abs(x2 - x1);
                int yDifference = Math.abs(y2 - y1);

				if ((xDifference == 1 && yDifference == 2) || (xDifference == 2 && yDifference == 1)) {
					System.out.print("Knight can move from one to another");
				} else {
					System.out.print("Knight cannot move from one to another");
				}
            } else {
                error_message();
                return;
            }
		}
	}
}
