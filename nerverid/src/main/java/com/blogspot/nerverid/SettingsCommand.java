package com.blogspot.nerverid;

import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.slf4j.Logger;
import com.blogspot.nerverid.Utils;

public class SettingsCommand extends ServiceCommand{

	private Logger logger = LoggerFactory.getLogger(SettingsCommand.class);
	
	SettingsCommand(String identifier, String description) {		
		super(identifier, description);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute(AbsSender absSender, User user, Chat chat, String [] strings) {
		String userName = Utils.getUserName(user);
		
		logger.debug(String.format("Пользователь %s. Начато выполнение команды %s", userName, this.getCommandIdentifier()));
		
		Long chatId = chat.getId();
		Settings settings = Bot.getUserSettings(chatId);
		sendAnswer(absSender, chatId, this.getCommandIdentifier(), userName,
				String.format("*Текущие настройки*\n" +
								"- минимальное число, используещееся в заданиях - *%s*\n" +
								"- максимальное число, используещееся в заданиях - *%s*\n" +
								"- число страниц итогового файла - *%s*\n\n"+
								"Если Вы хотите изменить эти параметры, введите через пробел или запятую 3 числа - " +
                                "минимальное число, максимальное число и количество страниц в файле (не более 10)\n\n" +
                                "\uD83D\uDC49 Например, 3,15,6 или 4 17 3",
								settings.getMin(), settings.getMax(), settings.getListCount()));
		
		logger.debug(String.format("Пользователь %s. Завершено выполнение команды %s", userName,
                this.getCommandIdentifier()));
	}

}
