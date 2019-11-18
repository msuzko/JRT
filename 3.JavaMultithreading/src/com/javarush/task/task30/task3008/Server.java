package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(ConsoleHelper.readInt());
            System.out.println("Сервер запущен");
            try {
                while (true) {
                    Socket socket = serverSocket.accept();
                    Handler handler = new Handler(socket);
                    handler.start();
                }
            } catch (IOException e) {
                serverSocket.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection :
                connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                System.out.println("Не удалось отправить сообщение");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String name = getName(connection);
            connectionMap.put(name, connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));
            return name;
        }

        private String getName(Connection connection) throws IOException, ClassNotFoundException {
            Message message;
            do {
                connection.send(new Message(MessageType.NAME_REQUEST));
                message = connection.receive();
            } while (message.getType() != MessageType.USER_NAME);
            String name = message.getData();
            if (name.isEmpty())
                name = getName(connection);
            else if (connectionMap.containsKey(name))
                name = getName(connection);
            return name;
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry :
                    connectionMap.entrySet()) {
                if (entry.getKey().equals(userName))
                    continue;
                connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() != MessageType.TEXT) {
                    ConsoleHelper.writeMessage("Сообщение не является текстом");
                    continue;
                }
                sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
            }
        }

        @Override
        public void run() {
            super.run();
            ConsoleHelper.writeMessage("Установлено соединение с " + socket.getRemoteSocketAddress());
            String name = null;
            try (Connection connection = new Connection(socket)) {
                name = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name));
                notifyUsers(connection, name);
                serverMainLoop(connection, name);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным сервером");
            } finally {
                if (name != null) {
                    connectionMap.remove(name);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED,name));
                }
                ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
            }
        }
    }
}
