package com.zealot.dcasting.dto;

import org.springframework.core.io.Resource;

public class DownloadFileRet {
	private Resource data;
	private String fileName;
	
	public Resource getData() {
		return data;
	}
	public void setData(Resource data) {
		this.data = data;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
