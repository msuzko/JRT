package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {
//        IncomeData incomeData = new IncomeData() {
//            @Override
//            public String getCountryCode() {
//                return "RU";
//            }
//
//            @Override
//            public String getCompany() {
//                return "Mec Co";
//            }
//
//            @Override
//            public String getContactFirstName() {
//                return "Mikhail";
//            }
//
//            @Override
//            public String getContactLastName() {
//                return "Suzko";
//            }
//
//            @Override
//            public int getCountryPhoneCode() {
//                return 7;
//            }
//
//            @Override
//            public int getPhoneNumber() {
//                return 651761141;
//            }
//        };
//        IncomeDataAdapter incomeDataAdapter = new IncomeDataAdapter(incomeData);
//        System.out.println(incomeDataAdapter.getCompanyName());
//        System.out.println(incomeDataAdapter.getCountryName());
//        System.out.println(incomeDataAdapter.getName());
//        System.out.println(incomeDataAdapter.getPhoneNumber());


    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;

        public IncomeDataAdapter(IncomeData incomeData) {
            this.data = incomeData;
        }


        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName()+", "+ data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String phone = setZero(data.getPhoneNumber());
            phone = "("+ phone.substring(0,3)+")"
                    +phone.substring(3,6)+"-"
                    +phone.substring(6,8)+"-"
                    +phone.substring(8);

            return "+"+ data.getCountryPhoneCode()+phone;
        }

        private String setZero(int phoneNumber) {
            String s = String.valueOf(phoneNumber);
            while (s.length()<10){
                s = "0"+s;
            }
            return s;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}