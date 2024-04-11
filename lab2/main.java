
import java.util.Random;

class main {

	public static int min(int a, int b) {
		if (a < b) {
			return a;
		} else {
			return b;
		}
	}

	public static int max(int a, int b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}

	public static void ex1(int[] array, int n) {
		System.out.println("Exercise 1");
		System.out.println("-------------------------");
		int even = 0;
		int odd = 0;
		int min_index = 0;
		int max_index = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (array[i] % 2 == 0) {
				even++;
			} else {
				odd++;
			}
			if (array[i] > array[max_index]) {
				max_index = i;
			}
			if (array[i] < array[min_index]) {
				min_index = i;
			}
		}
		min_index = min(max_index, min_index);
		max_index = max(max_index, min_index);
		for (int i = min_index+1; i < max_index; i++) {
			sum += array[i];
			System.out.println(sum);
		}

		System.out.printf("Odd numbers: %d%nEven numbers: %d%nSum of element between %d and %d is %d%n",
		odd, even, array[min_index], array[max_index], sum);
		System.out.println("-------------------------");
	} 

	public static void ex2(int[] array, int n) {
		System.out.println("Exercise 2");
		System.out.println("-------------------------");
		int j = 0;
		int[] max = {0, 0};
		for (int i = 0; i < n-1; i++) {
			for (j = i; j < n-1; j++) {
				if (array[j] < array[j+1]) {
					break;
				}
			}
			if (j - i + 1> max[1]) {
				max[0] = i;
				max[1] = j - i+1;
			}
		}
		System.out.printf("The longest decrease subsequence starts at array[%d] and have %d elements%n",
		max[0], max[1]);
		System.out.println("-------------------------");
	}

	static public int countRowsWithoutNegative(int[][] matrix) {
		int count = 0;

        for (int[] row : matrix) {
            boolean hasNegative = false;

            for (int element : row) {
                if (element < 0) {
                    hasNegative = true;
                    break;
                }
            }
            if (!hasNegative) {
                count++;
            }
        }
        return count;
	}


	static public int findOcurrances(int[][] matrix, int elem) {
		int count = 0;
		for (int[] row : matrix) {
			for (int curElement : row) {
				if (curElement == elem) {
					count++;
					if (count > 1) {
						return count;
					}
				}
			}
		}
		return count;
	}
	
	static public void ex3(int[][] matrix) {
		System.out.println("Exercise 3");
		System.out.println("-------------------------");
		if (matrix.length == 0) {
			return ;
		}
		int min = Integer.MAX_VALUE;
		for (int[] row : matrix) {
			for (int elem : row) {
				if (elem < min && findOcurrances(matrix, elem) > 1) {
					min = elem;
				}
			}
		}
		System.out.printf("Number of rows which doesn't have any negative number = %d%nMin number = %d%n",
		countRowsWithoutNegative(matrix), min);
		System.out.println("-------------------------");
	}

	static public int[][] ex4(int[][] matrix, int n) {
		System.out.println("Exercise 4");
		System.out.println("-------------------------");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j > i) {
					matrix[i][j] = 0;
				} else if (i > j) {
					matrix[i][j] = 1;
				}
			}
		}
		printMatrix(matrix);
		System.out.println("-------------------------");
		return matrix;
	}

	static void printMatrix(int[][] matrix) {
		System.out.println("Matrix: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println(); // Move to the next line after each row
        }
    }

	static void printArray(int[] array) {
		System.out.println("Array: ");
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%d ", array[i]);
		}
	}
	
	public static void main(String[] argv) {
		Random random = new Random();

		int arrayLength = random.nextInt(10) + 10;
		
		int[] array = new int[arrayLength];

		for (int i = 0; i < arrayLength; i++) {
			array[i] = random.nextInt(40) - 10;
		}

		printArray(array);
		System.out.println("");

		int[][] matrix = new int[4][4];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				matrix[i][j] = random.nextInt(20) - 10;
			}
		}

		printMatrix(matrix);

		ex1(array, arrayLength);
		ex2(array, arrayLength);
		ex3(matrix);
		ex4(matrix, 4);
	}
}