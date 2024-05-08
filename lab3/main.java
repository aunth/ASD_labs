import java.util.InputMismatchException;
import java.util.Scanner;

class ABITURIENT {
    String NAME;
    String GENDER;
    String SPEC;
    int[] EXAM;

    ABITURIENT(String name, String gender, String spec, int[] exam) {
        this.NAME = name;
        this.GENDER = gender;
        this.SPEC = spec;
        this.EXAM = exam;
    }

    public String getName() {
        return this.NAME;
        
    }

    public String getGender() {
        return this.GENDER;
    }

    public String getSpecialty() {
        return this.SPEC;
    }

    public int[] getExam() {
        return this.EXAM;
    }

}

public class main {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
		// int N;
        // while (true) {
        //     try {
        //         System.out.print("Enter the number of ABITURIENTs: ");
        //         N = scanner.nextInt();
        //         if (N <= 0) {
        //             throw new InputMismatchException();
        //         }
		// 		break;
        //     } catch (InputMismatchException e) {
        //         System.out.println("Number should be positive");
        //     }

        // }

        // ABITURIENT[] ABITURIENTS = setABITURIENTs(N);


        // sortABITURIENTByAverage(ABITURIENTS);

        // printABITURIENT(ABITURIENTS);

        test();
    }

    public static void printABITURIENT(ABITURIENT[] ABITURIENTs) {
        System.out.println("ABITURIENT Information:");
        for (int i = 0; i < ABITURIENTs.length; i++) {
            System.out.println("ABITURIENT " + (i + 1) + ":");
            System.out.println("Surname, initials: " + ABITURIENTs[i].getName());
            System.out.println("Gender: " + ABITURIENTs[i].getGender());
            System.out.println("Specialty name: " + ABITURIENTs[i].getSpecialty());
            System.out.println("Average mark: " + calculateAverage(ABITURIENTs[i].getExam()));
            System.out.println(); // Add a newline for better readability
        }
    }

	public static void getStudentsByMark(ABITURIENT[] ABITURIENTS) {

		Scanner scanner = new Scanner(System.in);
        int passMark = 0;
		System.out.print("Enter the passing score: ");
        try {
            passMark = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("You should type me a number");
            return ;
        }
        boolean anyBelowPassMark = false;
        for (ABITURIENT ABITURIENT : ABITURIENTS) {
            if (calculateAverage(ABITURIENT.EXAM) < passMark) {
                anyBelowPassMark = true;
                System.out.println(ABITURIENT.NAME + " - " + ABITURIENT.SPEC);
            }
        }
        if (!anyBelowPassMark) {
            System.out.println("No ABITURIENTs have a score below the passing mark.");
        }
	}

    public static ABITURIENT[] setABITURIENTs(int N) {

        Scanner scanner = new Scanner(System.in);
        ABITURIENT[] ABITURIENTS = new ABITURIENT[N];

        for (int i = 0; i < N; i++) {
            System.out.println("Data for ABITURIENT " + (i + 1) + ":");
            System.out.println("Surname, initials: ");
            String name = scanner.nextLine();
            System.out.println("Gender: ");
            String gender = scanner.next();
            System.out.println("Specialty name: ");
            String spec = scanner.next();
            int[] exam = new int[3];
            for (int j = 0; j < 3; j++) {
                System.out.println("Entrance exam result for subject " + (j + 1) + ": ");
                exam[j] = scanner.nextInt();
            }
            ABITURIENTS[i] = new ABITURIENT(name, gender, spec, exam);
        }
        return ABITURIENTS;
    }

    public static void sortABITURIENTByAverage(ABITURIENT[] ABITURIENTs) {
        for (int i = 0; i < ABITURIENTs.length - 1; i++) {
            for (int j = 0; j < ABITURIENTs.length - i - 1; j++) {
                if (calculateAverage(ABITURIENTs[j].EXAM) > calculateAverage(ABITURIENTs[j + 1].EXAM)) {
                    ABITURIENT temp = ABITURIENTs[j];
                    ABITURIENTs[j] = ABITURIENTs[j + 1];
                    ABITURIENTs[j + 1] = temp;
                }
            }
        }
    }

    public static double calculateAverage(int[] exam) {
        int sum = 0;
        for (int score : exam) {
            sum += score;
        }
        return (double) sum / exam.length;
    }

    public static void test() {
        ABITURIENT[] ABITURIENTs = {
            new ABITURIENT("John B.B", "Male", "Computer Science", new int[]{100, 100, 80}),
            new ABITURIENT("Alice C.D", "Female", "Electrical Engineering", new int[]{90, 85, 95}),
            new ABITURIENT("Bob E.F", "Male", "Mechanical Engineering", new int[]{80, 75, 85}),
            new ABITURIENT("Eve G.H", "Female", "Civil Engineering", new int[]{85, 90, 80}),
            new ABITURIENT("Charlie I.J", "Male", "Chemical Engineering", new int[]{95, 85, 90}),
            new ABITURIENT("Diana K.L", "Female", "Aerospace Engineering", new int[]{85, 90, 85}),
            new ABITURIENT("Frank M.N", "Male", "Biomedical Engineering", new int[]{90, 80, 85}),
            new ABITURIENT("Grace O.P", "Female", "Environmental Engineering", new int[]{85, 95, 80}),
            new ABITURIENT("Henry Q.R", "Male", "Industrial Engineering", new int[]{80, 85, 90}),
            new ABITURIENT("Isabella S.T", "Female", "Materials Science", new int[]{95, 90, 85})
        };

        sortABITURIENTByAverage(ABITURIENTs);
        printABITURIENT(ABITURIENTs);

        getStudentsByMark(ABITURIENTs);
    }


}
