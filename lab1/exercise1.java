
import java.util.Scanner;

public class exercise1 {
    public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
        
		System.out.print("Enter a speed of the first car(v1): ");
        float v1 = scanner.nextFloat();
        
		System.out.print("Enter a speed of the second car(v2): ");
		float v2 = scanner.nextFloat();
		
		System.out.print("Enter a distance between two cars(S): ");
		float S = scanner.nextFloat();

		System.out.print("Enter a time(T): ");
		float T = scanner.nextFloat();

		System.out.println("Distance between two cars after T hours is: " + (S + T * (v1 + v2)));
        scanner.close();
    }
}
