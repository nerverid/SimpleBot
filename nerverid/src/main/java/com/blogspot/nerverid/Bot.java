package com.blogspot.nerverid;

import lombok.Getter;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.Message;


import java.util.HashMap;
import java.util.Map;

public class Bot extends TelegramLongPollingCommandBot{

	private final String BOT_NAME;
	private final String BOT_TOKEN;
	
	//Default Settings
	@Getter
	private static final Settings defauldSettings = new Settings(1, 15, 1);
	
	
	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processNonCommandUpdate(Update update) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return null;
	}

}
