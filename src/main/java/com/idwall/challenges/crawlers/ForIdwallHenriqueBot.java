package com.idwall.challenges.crawlers;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ForIdwallHenriqueBot extends TelegramLongPollingBot {
	
	public void onUpdateReceived(Update update) {

		SendMessage message = new SendMessage();
		Message command = update.getMessage();
		String commandMessage = "" + command.getText();
		message.setChatId(command.getChatId());
		String subreddits;

		if (commandMessage.substring(0, 14).equals("/nadaparafazer")) {

			subreddits = commandMessage.substring(15, commandMessage.length());
			Crawler crawler = new Crawler(subreddits);
			message.setText(crawler.AllTrends());

		} else {
			message.setText("Desculpe, " + update.getMessage().getFrom().getFirstName()
					+ ". Não consegui entender o que você quis dizer");
		}

		try {
			execute(message);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	public String getBotUsername() {
		return "ForIdwallHenrique_bot";
	}

	@Override
	public String getBotToken() {
		return "805744521:AAEBZ25XhsTUCr59vwOvpXiQo4mF1FY0qas";
	}


}
