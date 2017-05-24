package com.test.entity.datastructure;

import com.test.entity.DataNode;

public class DoublyLinkedList {
	private DataNode head;
	private DataNode tail;
	private int length;

	public DataNode getHead() {
		return head;
	}

	public void setHead(DataNode head) {
		this.head = head;
	}

	public DataNode getTail() {
		return tail;
	}

	public void setTail(DataNode tail) {
		this.tail = tail;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void insertDataNode(int nodeToBeInsertedAfterIndex, String data) {
		if (length == 0) {
			head = tail = new DataNode(null, null, data);
			length++;
		} else if (nodeToBeInsertedAfterIndex > length) {
			throw new IndexOutOfBoundsException();
		} else {
			DataNode temp = new DataNode(null, null, data);
			if (nodeToBeInsertedAfterIndex > 0
					&& nodeToBeInsertedAfterIndex == length) {
				DataNode preNode = tail;
				temp.setPreNode(preNode);
				preNode.setNextNode(temp);
				tail = temp;
			} else if (nodeToBeInsertedAfterIndex == 0) {
				DataNode nextNode = head;
				temp.setNextNode(nextNode);
				nextNode.setPreNode(temp);
				head = temp;
			} else {
				DataNode current = head;
				current = traverseNodeForIndex(nodeToBeInsertedAfterIndex,
						current);
				DataNode nextNode = current.getNextNode();
				temp.setNextNode(nextNode);
				temp.setPreNode(current);
				current.setNextNode(temp);

			}
			length++;
		}

	}

	private DataNode traverseNodeForIndex(int index, DataNode current) {
		for (int i = 0; i < index; i++) {
			current = current.getNextNode();
		}
		return current;
	}

	public void printNodeForIndex(int index, DataNode current) {
		for (int i = 0; i < index; i++) {
			System.out.println(current.getData());
			current = current.getNextNode();
		}

	}

	public String get(int index) {
		if (index < 0 || index >= length) {
			throw new IndexOutOfBoundsException();
		} else {
			DataNode current = head;
			current = traverseNodeForIndex(index, current);
			return current.getData();
		}
	}

	public void deleteDataNode(int index) {
		if (index < 0 || index >= length) {
			throw new IndexOutOfBoundsException();
		} else {
			if (index == 0) {
				head = head.getNextNode();
				head.setPreNode(null);

			} else if (index == length - 1) {
				tail = tail.getPreNode();
				tail.setNextNode(null);

			} else {
				DataNode current = head;
				current = traverseNodeForIndex(index, current);
				DataNode previous = current.getPreNode();
				DataNode next = current.getNextNode();
				previous.setNextNode(current.getNextNode());
				next.setPreNode(previous);

			}
			length--;
		}

	}

}
