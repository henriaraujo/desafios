package com.idwall.challenges.strings;

import java.util.ArrayList;
import java.util.List;

public class IdwallFormatter extends StringFormatter {

	public IdwallFormatter(String text, Integer limit, Boolean justify) {
		super(text, limit, justify);
	}

	@Override
	public String Format() {
		List<String> words = BuildWord(super.getText());
		String unjustifiedText = BuildUnjustifiedText(words, super.getLimit());
		String justifiedText = BuildJustifiedText(unjustifiedText);

		if (super.getJustify()) {
			return justifiedText;
		} else {
			return unjustifiedText;
		}

	}

	private String BuildJustifiedText(String text) {
		String[] lines = text.split("\n");
		String textToForm = "";

		for (int i = 0; i < lines.length; i++) {
			String textToJustify = JustifyLine(lines[i]);
			textToForm += textToJustify + "\n";
		}

		return textToForm;
	}

	private List<String> BuildWord(String text) {
		String possibleWordtoBuild = "";
		List<String> strings = new ArrayList<String>();
		Integer stringReadPosition = 0;

		while (stringReadPosition < text.length()) {
			if (text.charAt(stringReadPosition) == ' ') {
				strings.add(possibleWordtoBuild);
				possibleWordtoBuild = "";
			} else if (text.charAt(stringReadPosition) == '\n') {
				possibleWordtoBuild += text.charAt(stringReadPosition);
				strings.add(possibleWordtoBuild);
				possibleWordtoBuild = "";
			} else {
				possibleWordtoBuild += text.charAt(stringReadPosition);
				if (text.length() - 1 == stringReadPosition) {
					strings.add(possibleWordtoBuild);
				}
			}
			stringReadPosition++;
		}
		return strings;
	}

	private String BuildUnjustifiedText(List<String> strings, Integer tamanhoMaximoLinha) {
		String unjustifiedString = strings.get(0) + " ";
		Integer currentLineSize = strings.get(0).length() + 1;
		Integer currentWordPosition = 1;

		while (currentWordPosition < strings.size()) {
			if (currentLineSize + strings.get(currentWordPosition).length() <= tamanhoMaximoLinha) {
				if (strings.get(currentWordPosition).charAt(strings.get(currentWordPosition).length() - 1) == '\n') {
					unjustifiedString += strings.get(currentWordPosition);
					currentLineSize = 0;
				} else {
					if (currentWordPosition == strings.size() - 1) {
						unjustifiedString += strings.get(currentWordPosition);
					} else {
						unjustifiedString += strings.get(currentWordPosition) + " ";
					}

					currentLineSize += strings.get(currentWordPosition).length() + 1;
				}
				currentWordPosition++;
			} else {
				unjustifiedString = unjustifiedString.substring(0, unjustifiedString.length() - 1);
				unjustifiedString += "\n";
				currentLineSize = 0;
			}
		}
		return unjustifiedString;
	}

	private String JustifyLine(String text) {

		Integer placesToOccupy = super.getLimit() - text.length();
		StringBuilder stringBuilder = new StringBuilder(text);

		if (placesToOccupy == 0 || placesToOccupy == super.getLimit()) {
			return text;
		}

		else {
			int count = 0;
			Integer retryCounter = 0;
			while (placesToOccupy > 0) {
				if (stringBuilder.charAt(count) == ' ') {
					placesToOccupy--;
					stringBuilder.insert(count, ' ');
					count = count + 1 + retryCounter;
				}
				count++;

				if (count >= stringBuilder.toString().length()) {
					count = 0;
					retryCounter++;
				}
			}
		}
		return stringBuilder.toString();
	}

}
