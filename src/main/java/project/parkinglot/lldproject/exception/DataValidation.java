package project.parkinglot.lldproject.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DataValidation {


    public boolean matchNumber(String reg){
        String regexPattern = "^[A-Z]{2}-\\d{2}-[A-Z]{2}-\\d{4}$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(reg);

        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean matchColour(String color){
        String regexPattern = "^[a-zA-Z]{1,15}$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(color);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean matchAnyNum(int num){
        String inputNumberString = String.valueOf(num);
        String regexPattern = "^[1-9]\\d*$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(inputNumberString);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
