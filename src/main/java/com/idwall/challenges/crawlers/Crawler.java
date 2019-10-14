package com.idwall.challenges.crawlers;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	private Document document;
	private String userInputText;
	List<SubRedditThread> subRedditsList;

	public Crawler(String userInputText) {
		subRedditsList = new ArrayList<SubRedditThread>();
		String[] subRedditElement = userInputText.split(";");

		for (int i = 0; i < subRedditElement.length; i++) {
			MakeSubreddits(subRedditElement[i]);
		}
	}

	private Elements getSubRedditsElements(String subreddit) {
		try {
			document = Jsoup.connect("https://old.reddit.com" + "/r/" + subreddit).get();
			return document.getElementsByAttributeValueContaining("class", "thing id-t3_");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private void MakeSubreddits(String subReddit) {

		String score, title, link;
		String numberBuilder = "";
		for (Element element : getSubRedditsElements(subReddit)) {
			SubRedditThread subRedditThread = new SubRedditThread(subReddit);
			score = element.getElementsByClass("score likes").text();
			Integer scoreIntNumber;
       
			
		if(!score.equals("•")) {	
			if (score.charAt(score.length() - 1) == 'k') {

				for (int i = 0; i < score.length(); i++) {
					if (score.charAt(i) != 'k' && score.charAt(i) != '.') {
						numberBuilder += score.charAt(i);
					}
				}

				numberBuilder += "00";

				scoreIntNumber = Integer.parseInt(numberBuilder);
				title = element.getElementsByAttributeValue("data-event-action", "title").text();
				subRedditThread.setScore(scoreIntNumber);
				subRedditThread.setTitle(title);
			}

			else if (!score.equals("•")){
				scoreIntNumber = Integer.parseInt(score);
				title = element.getElementsByAttributeValue("data-event-action", "title").text();
				subRedditThread.setScore(scoreIntNumber);
				subRedditThread.setTitle(title);
			}

			if (subRedditThread.getScore() >= 5000) {
				subRedditThread.setIsTrend(true);
			} else {
				subRedditThread.setIsTrend(false);
			}

			Elements children = element.getElementsByClass("first");
			for (Element linkToForm : children) {
				link = (linkToForm.getElementsByTag("a").attr("href"));
				subRedditThread.setLink(link);
			}

			if (subRedditThread.getLink() != null && subRedditThread.getScore() != null
					&& subRedditThread.getTitle() != null) {
				subRedditsList.add(subRedditThread);
			}
		  }
		}

	}

	public String AllTrends() {
		String textToForm = "";
		for (int i = 0; i < subRedditsList.size(); i++) {
			if (subRedditsList.get(i).getIsTrend()) {
				textToForm += subRedditsList.get(i).toString();
			}
		}
		return textToForm;
	}

	public String getUserInputText() {
		return userInputText;
	}

	public Document getDocument() {
		return document;
	}

	public List<SubRedditThread> getSubRedditsList() {
		return subRedditsList;
	}

}
