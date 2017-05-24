package com.test.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.test.entity.DataNode;
import com.test.entity.Student;
import com.test.entity.datastructure.DoublyLinkedList;
import com.test.thread.CallableThread;
import com.test.thread.Consumer;
import com.test.thread.Producer;

public class DemoApp {

	public static void main(String[] args) {
		sortStudentInstances();
		doublyLinkedListDemo();
		executeCallableThreadInFixedPool();
		validateProducerConsumer();
	}
	 private static void sortStudentInstances(){
		 List<Student> students = new ArrayList<Student>();
		 Student s1 = new Student("Ravi", 26, "6");
		 
		 Student s2 = new Student("Ravi", 28, "6");
		 Student s3 = new Student("Sandeep", 27, "6");
		 students.add(s1);students.add(s2);students.add(s3);
		 Collections.sort(students, Student.StudentComparator);
		students.forEach(student -> System.out.println(student.toString()));
	 }
	 
	 private static void doublyLinkedListDemo(){
		 DoublyLinkedList dLinkedList = new DoublyLinkedList();
		 dLinkedList.insertDataNode(0, "Sumit");
		 dLinkedList.insertDataNode(1, "Rajiv");
		 dLinkedList.insertDataNode(2, "Sanjiv");
		 dLinkedList.insertDataNode(3, "Niren");
		 dLinkedList.insertDataNode(2, "Suryansh");
		 DataNode front = dLinkedList.getHead();
		 int length = dLinkedList.getLength();
		 System.out.println("DlinkedList after insertion :");
		 dLinkedList.printNodeForIndex(length, front);
		 dLinkedList.deleteDataNode(2);
		 length = dLinkedList.getLength();
		 System.out.println("DlinkedList after deletion :");
		 dLinkedList.printNodeForIndex(length, front);
	 }
	 private static void executeCallableThreadInFixedPool(){
		 CallableThread.executeCallableThreadInFixedPool();
		
	 }
	 
	 private static void validateProducerConsumer(){
		 BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
		 
	        Thread producer = new Thread(new Producer(queue));
	 
	        Thread consumer = new Thread(new Consumer(queue));
	 
	        producer.start();
	        consumer.start();
	 }
}
