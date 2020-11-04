package com.gisarmory.common.entity;
/**
 * 
 * @author shaobin
 *
 */
public class FileBean {

	public FileBean(String filename, String filepath) {
		super();
		this.filename = filename;
		this.filepath = filepath;
	}
	public FileBean() {
		// TODO Auto-generated constructor stub
	}
	private String filename;
	private String filepath;
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
}
