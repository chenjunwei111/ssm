package com.spdb.pojo.base;

import java.io.Serializable;
import java.util.List;

public class TreePojo implements Serializable {
	private String title;
	private String value;
	private boolean checked;
	private List<TreePojo> data;
	
	public String getTitle() {
	    return title;
	}
	public void setTitle(String title) {
	    this.title = title;
	}
	public String getValue() {
	    return value;
	}
	public void setValue(String value) {
	    this.value = value;
	}
	public List<TreePojo> getData() {
	    return data;
	}
	public void setData(List<TreePojo> data) {
	    this.data = data;
	}
	public boolean isChecked() {
	    return checked;
	}
	public void setChecked(boolean checked) {
	    this.checked = checked;
	}
	
}
