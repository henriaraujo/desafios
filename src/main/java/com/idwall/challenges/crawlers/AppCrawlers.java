package com.idwall.challenges.crawlers;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class AppCrawlers {

	public static void main(String[] args) {

		if (args.length == 0) {
			String trend = "cats;dogs";
			Crawler crawler = new Crawler(trend);
			System.out.println(crawler.AllTrends());

			ApiContextInitializer.init();
			TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
			try {
				telegramBotsApi.registerBot(new ForIdwallHenriqueBot());
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		} else {
			if (args[0].equals("bot") && args.length == 1) {
				ApiContextInitializer.init();
				TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
				try {
					telegramBotsApi.registerBot(new ForIdwallHenriqueBot());
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			} else if (args[0].equals("normal") && args.length == 2) {
				Crawler crawler = new Crawler(args[1]);
				System.out.println(crawler.AllTrends());
			} else {
				System.out.println("Foi digitado algo errado ");
			}
		}
	}

}
