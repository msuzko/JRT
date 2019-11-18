package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {

    public static void main(String[] args) {
        new BotClient().run();
    }


    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            super.processIncomingMessage(message);
            if (message.contains(": ")) {
                String[] textAndName = message.split(": ");
                if (!textAndName[0].equalsIgnoreCase(getUserName())) {
                    String stFormat = "";
                    switch (textAndName[1]) {
                        case "дата":
                            stFormat = "d.MM.YYYY";
                            break;
                        case "день":
                            stFormat = "d";
                            break;
                        case "месяц":
                            stFormat = "MMMM";
                            break;
                        case "год":
                            stFormat = "YYYY";
                            break;
                        case "время":
                            stFormat = "H:mm:ss";
                            break;
                        case "час":
                            stFormat = "H";
                            break;
                        case "минуты":
                            stFormat = "m";
                            break;
                        case "секунды":
                            stFormat = "s";
                    }
                    if (!stFormat.isEmpty()) {
                        SimpleDateFormat format = new SimpleDateFormat(stFormat);
                        sendTextMessage("Информация для " + textAndName[0] + ": " + format.format(Calendar.getInstance().getTime()));
                    }

                }
            }
        }
    }
}
