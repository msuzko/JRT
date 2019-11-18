package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
//        args = new String[]{"-u", "19847983","something new","34.5623","13"};
        //        args = new String[]{"-c", "Ноутбук такой-то", "9999.99", "100"};
       // args = new String[]{"-d","198478"};
        if (args.length > 0) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
//            String fileName = "/users/mec/test/task1827.txt";
            reader.close();

            reader = new BufferedReader(new FileReader(fileName));
            List<String> list = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null)
                list.add(line);
            reader.close();

            for (int i=0;i<list.size();i++) {
                String str = list.get(i);
                if (str.startsWith(setSpaces(args[1], 8))) {
                    if (args[0].equals("-d")) {
                        list.remove(str);
                    } else if (args[0].equals("-u")) {
                        list.set(i,setSpaces(args[1], 8) +
                                setSpaces(args[2], 30) +
                                setSpaces(args[3],8)+
                                setSpaces(args[4],4));
                    }
                    //break;
                }
            }
            OutputStream out = new FileOutputStream(fileName);
            //PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            for (String str :
                    list) {
                //writer.println(str);
                out.write(str.getBytes());
                out.write("\n".getBytes());

            }
            //writer.close();
            out.close();
        }
    }


    private static String setSpaces(String previousName, int count) {
        String trueName;
        if (previousName.length() > count) {
            trueName = previousName.substring(0, count);
        } else {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < (count - previousName.length()); i++) {
                s.append(" ");
            }
            trueName = previousName + s;
        }
        return trueName;
    }
}
