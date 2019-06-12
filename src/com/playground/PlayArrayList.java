package com.playground;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PlayArrayList {

	static class Student {
		double score;
		String firstName;
		String lastName;

		Student(double score, String fN, String lN) {
			this.score = score;
			this.firstName = fN;
			this.lastName = lN;
		}
		
		public void toSting() {
			System.out.println(score +" "+ firstName +" "+ lastName);
		}
	}

	public static void main(String[] args) {
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list2.add(4);
		list2.add(3);
		list2.add(5);
		list2.add(9);
		list2.add(1);
		
		Collections.sort(list2);
		System.out.println(list2);
		
		Student s1 = new Student(10, "Amit", "Sharma");
		Student s2 = new Student(10, "Rohit", "Aharma");
		Student s3 = new Student(11, "Mohit", "Gupta");
		Student s4 = new Student(9, "Mohit", "Jain");

		List<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		
		Comparator<Student> comp = Comparator.comparing((Student s) -> s.score).thenComparing((Student s) -> s.lastName);
		Collections.sort(students, comp);
		
		for(Student student : students)
			student.toSting();
		
		Deque<Student> students2 = new LinkedList<>();
		students2.add(s1);
		students2.add(s2);
		students2.add(s3);
		students2.add(s4);
		System.out.println(students2);
		
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.offer(4);
		queue.offer(-1);
		queue.offer(9);
		queue.offer(3);
		queue.offer(5);
		
		while (!queue.isEmpty()) {
			System.out.print(queue.poll() + " ");
		}
	}

}
