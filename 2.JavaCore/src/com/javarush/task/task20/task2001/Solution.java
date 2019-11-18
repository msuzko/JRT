package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("/users/mec/test/6.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            if (ivanov.equals(somePerson)){
                System.out.println("true");
            }

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            outputStream.write((name+"\n").getBytes());
            String isAssetPresent = !assets.isEmpty()?"yes\n":"no\n";
            outputStream.write(isAssetPresent.getBytes());
            for (Asset asset :
                    assets) {
                outputStream.write((asset.getName()+"\n").getBytes());
                outputStream.write((String.valueOf(asset.getPrice())+"\n").getBytes());
            }
        }

        public void load(InputStream inputStream) throws Exception {
            byte [] b = new byte[inputStream.available()];
            inputStream.read(b);
            String str = new String(b);
            String[] s = str.split("\n");
            name = s[0];
            String isAssetPresent = s[1];
            if (isAssetPresent.equals("yes")){
                for (int i=2;i<s.length;i+=2){
                    Asset asset = new Asset(s[i],Double.parseDouble(s[i+1]));
                    assets.add(asset);
                }
            }
        }
    }
}
