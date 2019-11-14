package com.capgemini.tdd.demo.services;

import javax.validation.ValidationException;
import java.util.HashMap;


public class NumberService {

    private HashMap<Integer, String> digits = new HashMap();
    private HashMap<Integer, String> teens = new HashMap();
    private HashMap<Integer, String> tens = new HashMap();

    public NumberService(){

        digits.put(0,"Zero");
        digits.put(1,"One");
        digits.put(2,"Two");
        digits.put(3,"Three");
        digits.put(4,"Four");
        digits.put(5,"Five");
        digits.put(6,"Six");
        digits.put(7,"Severn");
        digits.put(8,"Eight");
        digits.put(9,"Nine");
        digits.put(10,"Ten");
        digits.put(11,"Eleven");
        digits.put(12,"Twelve");
        digits.put(13,"Thirteen");
        digits.put(14,"Fourteen");
        digits.put(15,"Fifteen");
        digits.put(16,"Sixteen");
        digits.put(17,"Seventeen");
        digits.put(18,"Eighteen");
        digits.put(19,"Nineteen");

        tens.put(20,"Twenty");
        tens.put(30,"Thirty");
        tens.put(40,"Forty");
        tens.put(50,"Fifty");
        tens.put(60,"Sixty");
        tens.put(70,"Seventy");
        tens.put(80,"Eighty");
        tens.put(90,"Ninety");
    }



    public String convert(int num){
        String output = "";

        int thousands = 0;
        int hundreds = 0;
        int tens = 0;

        if(num > 10000){
            throw new ValidationException("Out of range");
        }
        else{
            if(num == 0){
                return getStrDigits(num);
            }

            if(num >= 1000){
                thousands = num/1000;
                output += getStrThousands(thousands);
                num = num - (thousands*1000);

                if(num >= 100){
                    output += ", ";
                }
                else if (num > 0) {
                    output += " and ";
                }

            }

            if(num >= 100){
                hundreds = num/100;
                output += getStrHundreds(hundreds);
                num = num - (hundreds*100);

                if(num > 0){
                    output += " and ";
                }
            }

            if(num > 0){
                tens = num/10;
                if (num > 19) {
                    output += getStrTens(tens * 10);
                    num = num - (tens * 10);
                }
                else{
                    output += getStrDigits(num);
                    num = 0;
                }
            }


            if(num > 0) {
                output += getStrDigits(num);
            }

        }

        return output.trim();
    }

    String getStrThousands(int num){
        return getStrDigits(num) + " Thousand";
    }

    String getStrHundreds(int num){
        return getStrDigits(num) + " Hundred";
    }

    String getStrTens(int num){
        if(num > 1) {
            return tens.get(num) + " ";
        }
        else{
            return "";
        }
    }

    String getStrDigits(int num){
        String val = digits.get(num);
        if(val == null){
            return "";
        }
        else{
            return val;
        }
    }

}
