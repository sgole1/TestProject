/**
 * 
 */
package com.test.entity;

import java.util.Comparator;

/**
 * @author Niren
 *
 */
public class Student {
	public Student(String name, int age, String sClass) {
		super();
		this.name = name;
		this.age = age;
		this.sClass = sClass;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sClass=" + sClass
				+ "]";
	}

	private String name;
	private int age;
	private String sClass;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getsClass() {
		return sClass;
	}

	public void setsClass(String sClass) {
		this.sClass = sClass;
	}

	public static Comparator<Student> StudentComparator = new Comparator<Student>() {

		public int compare(Student s1, Student s2) {
			String studentName1 = s1.getName().toUpperCase();
			String studentName2 = s2.getName().toUpperCase();
			if (studentName1.equals(studentName2)) {
				return s1.getAge() - s2.getAge();
			} else {
				return studentName1.compareTo(studentName2);
			}
		}
	};

}
