package com.blogspot.nerverid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

abstract class ServiceCommand extends BotCommand {
	
	private Logger logger = LoggerFactory.getLogger(ServiceCommand.class);
	
	ServiceCommand(String identifier, String description){
		super(identifier, description);
	}
	
	void sendAnswer(AbsSender absSender, Long chatId, String commandName, String userName, String text) {
		SendMessage message = new SendMessage();
		message.enableMarkdown(true);
		message.setChatId(chatId.toString());
		message.setText(text);
		try {
			absSender.execute(message);
		} catch (TelegramApiException e) {
			logger.error(String.format("Ошибка %s. Комманда %s. Пользователь %s", e.getMessage(), commandName, userName));
			e.printStackTrace();
		}
	}

	@Override
	public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
		// TODO Auto-generated method stub
		
	}
}
