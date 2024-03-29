package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
//        Customer customer = new Customer() {
//            @Override
//            public String getCompanyName() {
//                return "avaRush Ltd.";
//            }
//
//            @Override
//            public String getCountryName() {
//                return "Ukraine";
//            }
//        };
//        Contact contact = new Contact() {
//            @Override
//            public String getName() {
//                return "Ivanov, Ivan";
//            }
//
//            @Override
//            public String getPhoneNumber() {
//                return "+38(050)123-45-67";
//            }
//        };
//        DataAdapter data = new DataAdapter(customer, contact);
//        System.out.println(data.getCompany());
//        System.out.println(data.getContactFirstName());
//        System.out.println(data.getContactLastName());
//        System.out.println(data.getCountryCode());
//        System.out.println(data.getDialString());
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {

            for (Map.Entry<String, String> entry :
                    countries.entrySet()) {
                if (entry.getValue().equals(customer.getCountryName()))
                    return entry.getKey();
            }
            return null;

        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String s = contact.getName();
            return s.substring(s.indexOf(" ") + 1);
        }

        @Override
        public String getContactLastName() {
            String s = contact.getName();
            return s.substring(0, s.indexOf(","));
        }

        @Override
        public String getDialString() {
            return "callto://" + contact.getPhoneNumber()
                    .replaceAll("-", "")
                    .replaceAll("\\(", "")
                    .replaceAll("\\)", "");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}