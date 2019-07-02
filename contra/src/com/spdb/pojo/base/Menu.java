package com.spdb.pojo.base;

import java.util.List;

public class Menu {

	private String functionCode;
	private String title;
	private String functionParentCode;
	private String icon;
	private String href;
	private String description;
	private int isValid;
	private int sequence;

	private List<Menu> children;

	public Menu() {
		super();
	}

	public Menu(String functionCode, String title, String functionParentCode,
			String icon, String href, String description, int isValid,
			int sequence, List<Menu> children) {
		super();
		this.functionCode = functionCode;
		this.title = title;
		this.functionParentCode = functionParentCode;
		this.icon = icon;
		this.href = href;
		this.description = description;
		this.isValid = isValid;
		this.sequence = sequence;
		this.children = children;
	}

	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFunctionParentCode() {
		return functionParentCode;
	}

	public void setFunctionParentCode(String functionParentCode) {
		this.functionParentCode = functionParentCode;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsValid() {
		return isValid;
	}

	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Menu [functionCode=" + functionCode + ", title=" + title
				+ ", functionParentCode=" + functionParentCode + ", icon="
				+ icon + ", href=" + href + ", description=" + description
				+ ", isValid=" + isValid + ", sequence=" + sequence
				+ ", children=" + children + "]";
	}

}
