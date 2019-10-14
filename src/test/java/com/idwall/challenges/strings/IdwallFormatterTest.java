package com.idwall.challenges.strings;

import junit.framework.TestCase;

public class IdwallFormatterTest extends TestCase {

	String testString = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n"
			+ "\n"
			+ "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";

	public void testIdwallUnjustifiedTest() {
		IdwallFormatter formatter = new IdwallFormatter(testString, 40, false);
		String result = formatter.Format();

		String expectedResult = "In the beginning God created the heavens\n" + "and the earth. Now the earth was\n"
				+ "formless and empty, darkness was over\n" + "the surface of the deep, and the Spirit\n"
				+ "of God was hovering over the waters.\n" + "\n" + "And God said, \"Let there be light,\" and\n"
				+ "there was light. God saw that the light\n" + "was good, and he separated the light\n"
				+ "from the darkness. God called the light\n" + "\"day,\" and the darkness he called\n"
				+ "\"night.\" And there was evening, and\n" + "there was morning - the first day.";

		assertEquals(expectedResult, result);
	}

	public void testBuildJustifiedText() {
		IdwallFormatter formatter = new IdwallFormatter(testString, 40, true);
		String result = formatter.Format();

		String expectedResult = "In the beginning God created the heavens\n"
				+ "and   the   earth.  Now  the  earth  was\n" + "formless  and  empty,  darkness was over\n"
				+ "the  surface of the deep, and the Spirit\n" + "of  God  was  hovering  over the waters.\n" + "\n"
				+ "And  God said, \"Let there be light,\" and\n" + "there  was light. God saw that the light\n"
				+ "was  good,  and  he  separated the light\n" + "from  the darkness. God called the light\n"
				+ "\"day,\"   and   the  darkness  he  called\n" + "\"night.\"  And  there  was  evening,  and\n"
				+ "there  was  morning  -  the  first  day.\n";

		assertEquals(expectedResult, result);
	}
}
