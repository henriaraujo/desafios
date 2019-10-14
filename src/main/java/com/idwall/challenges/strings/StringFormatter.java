package com.idwall.challenges.strings;

public abstract class StringFormatter {

	private String text;
	private Integer limit;
	private Boolean justify;

	public StringFormatter(String text, Integer limit, Boolean justify) {
		this.text = text;
		this.limit = limit;
		this.justify = justify;
	}

	public abstract String Format();

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Boolean getJustify() {
		return justify;
	}

	public void setJustify(Boolean justify) {
		this.justify = justify;
	}

}
