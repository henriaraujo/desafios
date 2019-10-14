package com.idwall.challenges.crawlers;

public class SubRedditThread {

	private String subRedditName, title, link;
	private Integer score;
	Boolean isTrend;

	public SubRedditThread(String subRedditName) {
		this.subRedditName = subRedditName;
	}

	public void setSubRedditName(String subRedditName) {
		this.subRedditName = subRedditName;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getSubRedditName() {
		return subRedditName;
	}

	public String getTitle() {
		return title;
	}

	public String getLink() {
		return link;
	}

	public Integer getScore() {
		return score;
	}

	public Boolean getIsTrend() {
		return isTrend;
	}

	public void setIsTrend(Boolean isTrend) {
		this.isTrend = isTrend;
	}

	@Override
	public String toString() {
		return "SubReddit Name = " + subRedditName + "\n" + "Title = " + title + "\n" + "Link = " + link + "\n"
				+ "Score = " + score + "\n\n";
	}
}
