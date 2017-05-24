package com.test.entity;

public class DataNode {
	public DataNode(DataNode preNode, DataNode nextNode, String data) {
		super();
		this.preNode = preNode;
		this.nextNode = nextNode;
		this.data = data;
	}
	@Override
	public String toString() {
		return "DataNode [data=" + data + "]";
	}
	private DataNode preNode;
	private DataNode nextNode;
	private String data;
	public DataNode getPreNode() {
		return preNode;
	}
	public void setPreNode(DataNode preNode) {
		this.preNode = preNode;
	}
	public DataNode getNextNode() {
		return nextNode;
	}
	public void setNextNode(DataNode nextNode) {
		this.nextNode = nextNode;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

}
