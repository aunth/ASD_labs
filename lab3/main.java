import java.util.InputMismatchException;
import java.util.Scanner;

class APPLICANT {
    String NAME;
    String GENDER;
    String SPEC;
    int[] EXAM;

    APPLICANT(String name, String gender, String spec, int[] exam) {
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
        //         System.out.print("Enter the number of applicants: ");
        //         N = scanner.nextInt();
        //         if (N <= 0) {
        //             throw new InputMismatchException();
        //         }
		// 		break;
        //     } catch (InputMismatchException e) {
        //         System.out.println("Number should be positive");
        //     }

        // }

        // APPLICANT[] APPLICANTS = setApplicants(N);


        // sortApplicantByAverage(APPLICANTS);

        // printApplicant(APPLICANTS);

        test();
    }

    public static void printApplicant(APPLICANT[] applicants) {
        System.out.println("Applicant Information:");
        for (int i = 0; i < applicants.length; i++) {
            System.out.println("Applicant " + (i + 1) + ":");
            System.out.println("Surname, initials: " + applicants[i].getName());
            System.out.println("Gender: " + applicants[i].getGender());
            System.out.println("Specialty name: " + applicants[i].getSpecialty());
            System.out.println("Average mark: " + calculateAverage(applicants[i].getExam()));
            System.out.println(); // Add a newline for better readability
        }
    }

	public static void getStudentsByMark(APPLICANT[] APPLICANTS) {

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
        for (APPLICANT applicant : APPLICANTS) {
            if (calculateAverage(applicant.EXAM) < passMark) {
                anyBelowPassMark = true;
                System.out.println(applicant.NAME + " - " + applicant.SPEC);
            }
        }
        if (!anyBelowPassMark) {
            System.out.println("No applicants have a score below the passing mark.");
        }
	}

    public static APPLICANT[] setApplicants(int N) {

        Scanner scanner = new Scanner(System.in);
        APPLICANT[] APPLICANTS = new APPLICANT[N];

        for (int i = 0; i < N; i++) {
            System.out.println("Data for applicant " + (i + 1) + ":");
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
            APPLICANTS[i] = new APPLICANT(name, gender, spec, exam);
        }
        return APPLICANTS;
    }

    public static void sortApplicantByAverage(APPLICANT[] applicants) {
        for (int i = 0; i < applicants.length - 1; i++) {
            for (int j = 0; j < applicants.length - i - 1; j++) {
                if (calculateAverage(applicants[j].EXAM) > calculateAverage(applicants[j + 1].EXAM)) {
                    APPLICANT temp = applicants[j];
                    applicants[j] = applicants[j + 1];
                    applicants[j + 1] = temp;
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
        APPLICANT[] applicants = {
            new APPLICANT("John B.B", "Male", "Computer Science", new int[]{100, 100, 80}),
            new APPLICANT("Alice C.D", "Female", "Electrical Engineering", new int[]{90, 85, 95}),
            new APPLICANT("Bob E.F", "Male", "Mechanical Engineering", new int[]{80, 75, 85}),
            new APPLICANT("Eve G.H", "Female", "Civil Engineering", new int[]{85, 90, 80}),
            new APPLICANT("Charlie I.J", "Male", "Chemical Engineering", new int[]{95, 85, 90}),
            new APPLICANT("Diana K.L", "Female", "Aerospace Engineering", new int[]{85, 90, 85}),
            new APPLICANT("Frank M.N", "Male", "Biomedical Engineering", new int[]{90, 80, 85}),
            new APPLICANT("Grace O.P", "Female", "Environmental Engineering", new int[]{85, 95, 80}),
            new APPLICANT("Henry Q.R", "Male", "Industrial Engineering", new int[]{80, 85, 90}),
            new APPLICANT("Isabella S.T", "Female", "Materials Science", new int[]{95, 90, 85})
        };

        sortApplicantByAverage(applicants);
        printApplicant(applicants);

        getStudentsByMark(applicants);
    }


}
