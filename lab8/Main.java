import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

class Main {
	public static void main(String []argv) {
		//ex1();
		ex2();
	}

	public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }

		return array;
    }

	public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

	public static int[] mergeSort(int []array) {
		if (array.length < 2) {
			return array;
		}
	
		int mid = array.length / 2;
		int[] leftHalf = new int[mid];
		int[] rightHalf = new int[array.length - mid];
	
		for (int i = 0; i < mid; i++) {
			leftHalf[i] = array[i];
		}
		for (int i = mid; i < array.length; i++) {
			rightHalf[i - mid] = array[i];
		}
	
		leftHalf = mergeSort(leftHalf);
		rightHalf = mergeSort(rightHalf);
	
		return merge(leftHalf, rightHalf);
	}
	
	public static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int leftIndex = 0, rightIndex = 0, resultIndex = 0;
	
		while (leftIndex < left.length && rightIndex < right.length) {
			if (left[leftIndex] <= right[rightIndex]) {
				result[resultIndex++] = left[leftIndex++];
			} else {
				result[resultIndex++] = right[rightIndex++];
			}
		}
	
		while (leftIndex < left.length) {
			result[resultIndex++] = left[leftIndex++];
		}
	
		while (rightIndex < right.length) {
			result[resultIndex++] = right[rightIndex++];
		}
	
		return result;
	}
	

	public static int fibonacciSearch(int[] arr, int x) {

		arr = bubbleSort(arr);
        int n = arr.length;
        int fibMMinus2 = 0;
        int fibMMinus1 = 1;
        int fibM = fibMMinus1 + fibMMinus2;

        while (fibM <= n) {
            fibMMinus2 = fibMMinus1;
            fibMMinus1 = fibM;
            fibM = fibMMinus1 + fibMMinus2;
        }

        int offset = -1;

        while (fibM > 1) {
            int i = Math.min(offset + fibMMinus2, n - 1);

            if (arr[i] < x) {
                fibM = fibMMinus1;
                fibMMinus1 = fibMMinus2;
                fibMMinus2 = fibM - fibMMinus1;
                offset = i;
            } else if (arr[i] > x) {
                fibM = fibMMinus2;
                fibMMinus1 = fibMMinus1 - fibMMinus2;
                fibMMinus2 = fibM - fibMMinus1;
            } else {
                return i;
            }
        }

        if (fibMMinus1 == 1 && arr[offset + 1] == x) {
            return offset + 1;
        }

        return -1;
    }

	public static int[] hoareSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        HoareSort(array, 0, array.length - 1);
        return array;
    }

    private static void HoareSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            HoareSort(array, low, pivotIndex);
            HoareSort(array, pivotIndex + 1, high);
        }
    }

	private static int partition(int[] array, int low, int high) {
		int pivot = array[low];
		int left = low;
		int right = high;
	
		while (left <= right) {
			while (left <= high && array[left] < pivot) {
				left++;
			}
			while (right >= low && array[right] > pivot) {
				right--;
			}
	
			if (left <= right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		}
		return left - 1;
	}
	

	public static boolean linearSearch(int []array, int value) {
		for (int i : array) {
			if (i == value)
				return true;
		}
		return false;
	}

	public static void copy_array(int[] dest, int[] src) {
		for (int i = 0; i < src.length; i++) {
			dest[i] = src[i];
		}
 	}

	public static int[] bubbleSort(int[] array) {

		int tmp = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
				if (array[j] < array[i]) {
					tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}

		return array;
	}

	 public static int linearBarrierSearch(int[] array, int key) {

        int lastIndex = array.length - 1;
        int lastValue = array[lastIndex];
        array[lastIndex] = key;
        
        int i = 0;
        while (array[i] != key) {
            i++;
        }
        
        array[lastIndex] = lastValue;
        if (i < lastIndex || key == lastValue) {
            return i;
        } else {
            return -1;
        }
    }

	public static boolean binarySearch(int[] array, int value) {

		array = bubbleSort(array);

		printArray(array);
		System.out.println(value);

		int start = 0;
		int end = array.length-1;

		while (end - start >= 1) {
			int middleIndex = (start + end) / 2;
			int middleValue = array[middleIndex];

			if (middleValue == value) {
				return true;
			}

			if (middleValue > value) {
				end = middleIndex - 1;
			} else {
				start = middleIndex + 1;
			}
		}
		return false;
	}

	public static int countInArray(int[] array, int value) {
		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				counter++;
			}
		}
		return counter;
	}

	public static void printArray(int []array) {
		array = bubbleSort(array);
		for (int i : array) {
			System.out.printf("%d ", i);
		}
		System.out.println();
	}
	
	public static void heapSort(int[] arr) {
        int n = arr.length;
        
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            heapify(arr, i, 0);
        }
    }

	static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

	public static int[] shellSort(int[] arr) {
        int n = arr.length;
        
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }

		return arr;
    }

	public static void ex2() {

		ArrayList<Integer> numbers = new ArrayList<>();

		Random random = new Random();
		int size = 10;
		int[] A = new int[size];
		int[] B = new int[size];
		for (int i = 0; i < size; i++) {
			A[i] = random.nextInt(15);
			B[i] = random.nextInt(15);
		}

		for (int i = 0; i < size; i++) {
			if (countInArray(B, A[i]) > 1) {
				numbers.add(A[i]);
			}
		}

		printArray(A);
		printArray(B);
		Collections.sort(numbers);
		System.out.println(numbers);
	}


	public static void ex1() {
		Random random = new Random();
		int size = 15;
		int[] number = new int[size];

		for (int i = 0; i < size; i++) {
			number[i] = random.nextInt(50);
		}

		int randIndex = number[random.nextInt(size)];
		printArray(number);
		System.out.println("Tried to find " + randIndex);

		System.out.println("Linear search");
		System.out.println(linearSearch(number, randIndex));

		System.out.println("Linear search with barier");
		System.out.println(linearBarrierSearch(number, randIndex));

		System.out.println("Binary search");
		System.out.println(binarySearch(Arrays.copyOf( number, number.length), randIndex));

		System.out.println("Fibonaci search");
		System.out.println(fibonacciSearch(Arrays.copyOf( number, number.length), randIndex));

		printArray(number);
		
		int[] after_insertion = insertionSort(Arrays.copyOf(number, number.length));
		System.out.println("Insertion sort:");
		printArray(after_insertion);

		int[] after_bubble = bubbleSort(Arrays.copyOf( number, number.length));
		System.out.println("Bubble sort:");
		printArray(after_bubble);

		int[] shellSort = shellSort(Arrays.copyOf( number, number.length));
		System.out.println("Shell sort:");
		printArray(shellSort);

		int[] mergeSort = mergeSort(Arrays.copyOf( number, number.length));
		System.out.println("Merge sort:");
		printArray(mergeSort);

		int[] HoareSort = hoareSort(Arrays.copyOf( number, number.length));
		System.out.println("Hoare sort:");
		printArray(HoareSort);

		heapSort(number);
		System.out.println("Heap sort sort:");
		printArray(number);

	}
}