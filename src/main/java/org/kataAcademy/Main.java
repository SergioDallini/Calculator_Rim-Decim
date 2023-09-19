package org.kataAcademy;

import java.util.*;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) {
        System.out.println("Введи пример:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }
    public static String calc(String input){
        int a, b, tempRes;
        String operSign, tempA, tempB;
        String result = "";
        String [] arr = input.trim().split(" ");
        if (arr.length > 3) throw new IllegalStateException("Неверное количество операндов!");

        Pattern patternRim = Pattern.compile("[VXI]+");
//        Pattern patternDec = Pattern.compile("[0-9]+");
        Pattern patternDec = Pattern.compile("\\d+");
        tempA = arr[0].toUpperCase().trim();
        tempB = arr[2].toUpperCase().trim();
        operSign = arr[1].trim();

        if (tempA.matches(String.valueOf(patternRim)) && tempB.matches(String.valueOf(patternRim))){
            a = rimsToDecim(tempA);
            b = rimsToDecim(tempB);
            if((a < 1 || a > 10) || (b < 1 || b > 10)) throw  new IllegalStateException("Неверные данные!");
            tempRes = oper(a, b, operSign);
            if (tempRes < 1) throw new IllegalStateException("Неверные данные!");
            result = decimToRims(tempRes) + " (" + tempRes + ")";
        } else if (tempA.matches(String.valueOf(patternDec)) && tempB.matches(String.valueOf(patternDec))) {
            a = Integer.parseInt(tempA);
            b = Integer.parseInt(tempB);
            if((a < 1 || a > 10) || (b < 1 || b > 10)) throw  new IllegalStateException("Неверные данные!");
            result = String.valueOf(oper(a, b, operSign));
        } else throw new IllegalStateException("Неверные данные!");
        return result;
    }
    private static int oper(int a, int b, String sign){
        int res;
        switch (sign){
            case "+": res = a + b; break;
            case "-": res = a - b; break;
            case "*": res = a * b; break;
            case "/": res = a / b; break;
            default:
                throw new IllegalStateException("Неверные данные! - " + sign);
        }
        return res;
    }

    private  static int rimsToDecim(String rim){
        int dec;
        switch (rim){
            case "I" : dec = 1; break;
            case "II" : dec = 2; break;
            case "III" : dec = 3; break;
            case "IV" : dec = 4; break;
            case "V" : dec = 5; break;
            case "VI" : dec = 6; break;
            case "VII" : dec = 7; break;
            case "VIII" : dec = 8; break;
            case "IX" : dec = 9; break;
            case "X" : dec = 10; break;
            default: throw  new IllegalStateException("Неверные данные!");
        }
        return dec;
    }

    private  static String decimToRims(int dec){
        String rim = "";
        int numLen = String.valueOf(dec).length();
        char[] arrChar = String.valueOf(dec).toCharArray();
        if(dec < 1) throw  new IllegalStateException("Неверные данные!");
        if (dec == 10 || dec == 100 || numLen == 1) rim = process(dec);
        if (numLen == 2){
            rim = process(Integer.parseInt(String.valueOf(arrChar[0]))*10) +
                    process(Integer.parseInt(String.valueOf(arrChar[1])));
        }
        return rim;
    }

    private  static String process(int x) {
        String rim;
        switch (x) {
            case 0:
                rim = "";
                break;
            case 1:
                rim = "I";
                break;
            case 2:
                rim = "II";
                break;
            case 3:
                rim = "III";
                break;
            case 4:
                rim = "IV";
                break;
            case 5:
                rim = "V";
                break;
            case 6:
                rim = "VI";
                break;
            case 7:
                rim = "VII";
                break;
            case 8:
                rim = "VIII";
                break;
            case 9:
                rim = "IX";
                break;
            case 10:
                rim = "X";
                break;
            case 20:
                rim = "XX";
                break;
            case 30:
                rim = "XXX";
                break;
            case 40:
                rim = "XL";
                break;
            case 50:
                rim = "L";
                break;
            case 60:
                rim = "LX";
                break;
            case 70:
                rim = "LXX";
                break;
            case 80:
                rim = "LXXX";
                break;
            case 90:
                rim = "XC";
                break;
            case 100:
                rim = "C";
                break;
            default:
                throw new IllegalStateException("Неверные данные!");
        }
        return rim;
    }

    }