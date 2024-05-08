import java.security.AllPermission;
import java.util.*;


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

class Node {
	APPLICANT Value = null;
	Node next = null;

	Node(APPLICANT applicant, Node next) {
		this.Value = applicant;
		this.next = next;
	}
}

class LinkedList {
	Node root = null;

	LinkedList(Node root) {
		this.root = root;
	}

	public void addElement(Node value) {
		Node cur = this.root;

		if (cur == null) {
			this.root = value;
			return ;
		}
		Node next = cur.next;
		while (next != null) {
			Node tmp = next;
			cur = next;
			next = tmp.next;
		}
		cur.next = value;
	}

	public void insertElement(Node value, int index) {
		if (index < 0) {
			System.out.println("Index must be positive");
			return ;
		}
	
		Node cur = null;
		Node next = this.root;
	
		if (index == 0) {
			value.next = next;
			this.root = value;
			return;
		}
	
		int currentIndex = 0;
		while (currentIndex < index && next != null) {
			cur = next;
			next = next.next;
			currentIndex++;
		}
	
		if (currentIndex == index) {
			cur.next = value;
			value.next = next;
		} else {
			System.out.println("Index is out of bounds.");
		}
	}
	
	public void deleteElement(int index) {
		if (index < 0) {
			System.out.println("Index must be positive");
			return ;
		}

		Node cur = this.root;
		int curIndex = 0;

		while (cur != null || curIndex < index - 1) {
			cur = cur.next;
			curIndex++;
		}

		if (cur == null) {
			System.out.println("Index out of range");
		} else {
			cur.next = cur.next.next;
		}
	}

	public void printList() {
		Node current = this.root;
		int index = 0;
	
		System.out.println("List of Applicants:");
		while (current != null) {
			System.out.println("Applicant " + (index + 1) + ":");
			printApplicant(current.Value);
	
			current = current.next;
			index++;
		}
	}
	
	public void findByName(String name) {
		Node current = this.root;

		System.out.println("People with name: " + name);
		while (current != null) {
			if (current.Value.getName().equals(name)) {
				printApplicant(current.Value);
			}
			current = current.next;
		}
	}

	public void findByExam(int[] exam) {
		Node current = this.root;

		System.out.printf("People with exam: %d %d %d", exam[0], exam[1], exam[2]);
		while (current != null) {
			if (Arrays.equals(current.Value.getExam(), exam)) {
				printApplicant(current.Value);
			}
			current = current.next;
		}
	}

	public void findBySpec(String spec) {
		Node current = this.root;

		System.out.println("People with spec: " + spec);
		while (current != null) {
			if (current.Value.getSpecialty().equals(spec)) {
				printApplicant(current.Value);
			}
			current = current.next;
		}
	}

	public void findByGender(String gender) {
		Node current = this.root;

		System.out.println("People with gender: " + gender);
		while (current != null) {
			if (current.Value.getGender().equals(gender)) {
				printApplicant(current.Value);
			}
			current = current.next;
		}
	}

	public static void printApplicant(APPLICANT applicants) {
		System.out.println("Surname, initials: " + applicants.getName());
		System.out.println("Gender: " + applicants.getGender());
		System.out.println("Specialty name: " + applicants.getSpecialty());
		System.out.println("Average mark: " + calculateAverage(applicants.getExam()));
		System.out.println();
	}

	public static double calculateAverage(int[] exam) {
        int sum = 0;
        for (int score : exam) {
            sum += score;
        }
        return (double) sum / exam.length;
    }
}





class main {
	public static void main(String[] name) {
		Node a = new Node(new APPLICANT("John B.B", "Male", "Computer Science", new int[]{100, 100, 80}), null);
        Node b = new Node(new APPLICANT("Alice C.D", "Female", "Electrical Engineering", new int[]{90, 85, 95}), null);
        Node c = new Node(new APPLICANT("Bob E.F", "Male", "Mechanical Engineering", new int[]{80, 75, 85}), null);
        Node d = new Node(new APPLICANT("Eve G.H", "Female", "Civil Engineering", new int[]{85, 90, 80}), null);

		Node root = a;
		LinkedList lst = new LinkedList(root);
		
		lst.addElement(b);
		lst.addElement(c);
		lst.printList();

		lst.deleteElement(2);
		lst.insertElement(c, 1);
		lst.printList();

		lst.findByGender("Male");
	}

	public static void ex2(LinkedList lst1, LinkedList lst2, int n, int m) {

		int counter1 = 0;
		int counter2 = 0;
		
		Node cur1 = lst1.root;
		Node cur2 = lst2.root;
		while (lst1.root != null) {
			counter1++;
			if (counter1 % n == 0) {
				System.out.println(cur1.Value);
				lst1.deleteElement(counter1);
			}
			cur1 = cur1.next;
		}

		while (lst1.root != null) {
			counter2++;
			if (counter2 % m == 0) {
				System.out.println(cur2.Value);
				lst2.deleteElement(counter2);
			}
		}
	}
}