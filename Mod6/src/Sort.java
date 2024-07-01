class Student {
	int rollnum;
	String name;
	String address;
	
	public Student(int rnum, String n, String add) {
		rollnum = rnum;
		name = n;
		address = add;
	}
}

public class Sort {
	public static void main(String[] args) {
		Student[] students = new Student[10];
		students[0] = new Student(23, "Bob", "1234 Borger Street");
		students[1] = new Student(63, "Sol", "4869 Gear Street");
		students[2] = new Student(78, "Satoshi", "1010 Sapphire Ridge");
		students[3] = new Student(562, "Noctis", "1515 Fantasy Drive");
		students[4] = new Student(2, "Mark", "1765 Invincible Road");
		students[5] = new Student(38, "Nolan", "1765 Invincible Road");
		students[6] = new Student(94, "Logan", "1337 Pepega Street");
		students[7] = new Student(174, "Dan Heng", "1212 Astral Avenue");
		students[8] = new Student(44, "Jhin", "4444 Ionia Drive");
		students[9] = new Student(71, "Hotaru", "42524 Stellar Street");
		
		System.out.println("Unsorted Array:");
		DisplayArray(students);
		
		MergeSort(students);
		
		System.out.println("Sorted Array:");
		DisplayArray(students);
	}
	
	private static void MergeSort(Student[] input) {
		int len = input.length;
		
		if (len < 2) {
			return;
		}
		
		int mid = len / 2;
		Student[] firstHalf = new Student[mid];
		Student[] secondHalf = new Student[len - mid];
		
		for (int i = 0; i < mid; i++) {
			firstHalf[i] = input[i];
		}
		
		for (int i = mid; i < len; i++) {
			secondHalf[i - mid] = input[i];
		}
		
		MergeSort(firstHalf);
		MergeSort(secondHalf);
		
		Merge(input, firstHalf, secondHalf);
	}
	
	private static void Merge (Student[] input, Student[] firstHalf, Student[] secondHalf) {
		int firstlen = firstHalf.length;
		int secondlen = secondHalf.length;
		
		int fnum = 0;
		int snum = 0;
		int mnum = 0;
		
		while (fnum < firstlen && snum < secondlen) {
			if (firstHalf[fnum].rollnum <= secondHalf[snum].rollnum) {
				input[mnum] = firstHalf[fnum];
				fnum++;
			} else {
				input[mnum] = secondHalf[snum];
				snum++;
			}
			mnum++;
		}
		
		while (fnum < firstlen) {
			input[mnum] = firstHalf[fnum];
			fnum++;
			mnum++;
		}
		
		while (snum < secondlen) {
			input[mnum] = secondHalf[snum];
			snum++;
			mnum++;
		}
	}
	
	private static void DisplayArray (Student[] array) {
		for (int i = 0; i < array.length; i++) {
			Student stu = array[i];
			System.out.println("Name: " + stu.name + ", Roll Number: " + stu.rollnum);
		}
	}
	
}