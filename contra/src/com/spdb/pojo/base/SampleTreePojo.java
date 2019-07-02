package com.spdb.pojo.base;

import java.io.Serializable;
import java.util.List;

public class SampleTreePojo implements Serializable {
	private String name;
	private String id;
	private String obj;
	private boolean spread;
	
	public String getObj() {
	    return obj;
	}
	public void setObj(String obj) {
	    this.obj = obj;
	}
	
	private List<SampleTreePojo> children;
	
	public String getName() {
	    return name;
	}
	public void setName(String name) {
	    this.name = name;
	}
	public String getId() {
	    return id;
	}
	public void setId(String id) {
	    this.id = id;
	}
	public List<SampleTreePojo> getChildren() {
	    return children;
	}
	public void setChildren(List<SampleTreePojo> children) {
	    this.children = children;
	}
	public boolean isSpread() {
	    return spread;
	}
	public void setSpread(boolean spread) {
	    this.spread = spread;
	}
	
	
	
}
