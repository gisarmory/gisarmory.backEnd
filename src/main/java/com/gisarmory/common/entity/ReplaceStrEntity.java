package com.gisarmory.common.entity;

public class ReplaceStrEntity {
	public ReplaceStrEntity(String oldString, String newString) {
		super();
		this.oldString = oldString;
		this.newString = newString;
	}
	public ReplaceStrEntity() {
		// TODO Auto-generated constructor stub
	}
	private String oldString;
	private String newString;
	public String getNewString() {
		return newString;
	}
	public void setNewString(String newString) {
		this.newString = newString;
	}
	public String getOldString() {
		return oldString;
	}
	public void setOldString(String oldString) {
		this.oldString = oldString;
	}
}
