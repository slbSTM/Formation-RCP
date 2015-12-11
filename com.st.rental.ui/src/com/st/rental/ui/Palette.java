package com.st.rental.ui;

import org.eclipse.jface.viewers.IColorProvider;

public class Palette {
	private String name;
	private String id;
	private String description;
	private IColorProvider colorProvider;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public IColorProvider getColorProvider() {
		return colorProvider;
	}
	public void setColorProvider(IColorProvider colorProvider) {
		this.colorProvider = colorProvider;
	}
}
