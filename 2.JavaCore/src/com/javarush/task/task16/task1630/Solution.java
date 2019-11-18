package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        String fileName;
        String content = "";

        @Override
        public void run() {
            char chWhiteSpace = "\n".charAt(0);
            super.run();
            try {
                FileInputStream fis = new FileInputStream(fileName);
                while (fis.available() > 0) {
                    char ch = (char) fis.read();
                    if (ch != chWhiteSpace)
                        content = content + ch;
                    else
                        content += " ";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void setFileName(String fullFileName) {
            fileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return content;
        }
    }
}
