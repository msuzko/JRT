package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("/users/mec/test/6.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setFirstName("Михаил");
            user.setLastName("Сузько");
            user.setBirthDate(new GregorianCalendar(1983,5,19).getTime());
            user.setCountry(User.Country.OTHER);
            user.setMale(true);
            javaRush.users.add(user);
            user.setFirstName("Алексей");
            user.setLastName("Гаврин");
            user.setBirthDate(new GregorianCalendar(1980,4,25).getTime());
            user.setCountry(User.Country.RUSSIA);
            user.setMale(true);
            javaRush.users.add(user);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            String isUserEmpty = users.isEmpty() ? "yes\n" : "no\n";
            outputStream.write(isUserEmpty.getBytes());
            for (User user :
                    users) {
                outputStream.write((user.getLastName() + "\n").getBytes());
                outputStream.write((user.getFirstName() + "\n").getBytes());
                outputStream.write((user.getBirthDate().getTime() + "\n").getBytes());
                outputStream.write((user.getCountry().getDisplayedName() + "\n").getBytes());
                outputStream.write((user.isMale() + "\n").getBytes());
            }
        }

        public void load(InputStream inputStream) throws Exception {
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            String str = new String(b);
            String[] s = str.split("\n");
            String isAssetPresent = s[0];
            if (isAssetPresent.equals("no")) {
                for (int i = 1; i < s.length; i += 5) {
                    User user = new User();
                    user.setLastName(s[i]);
                    user.setFirstName(s[i + 1]);
                    user.setBirthDate(new Date(Long.parseLong(s[i + 2])));
                    for (User.Country country :
                            User.Country.values()) {
                        if (country.getDisplayedName().equals(s[i + 3])) {
                            user.setCountry(country);
                            break;
                        }
                    }
                    if (s[i+4].equals("true"))
                        user.setMale(true);            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
                    else
                        user.setMale(false);
                    users.add(user);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
