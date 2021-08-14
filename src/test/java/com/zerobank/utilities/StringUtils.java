package com.zerobank.utilities;

public class StringUtils {
    public  String capitalizeWord(String str){
        String words[]=str.split("\\s");
        String capitalizeWord="";
        for(String w:words){
            String specialCharRegex = ("\"/^[a-zA-Z0-9!@#\\\\$%\\\\^\\\\&*\\\\)\\\\(+=._-]+$/g\"");
            if(!specialCharRegex.contains(w)) {
                String first = w.substring(0, 1);
                String afterfirst = w.substring(1);
                capitalizeWord += first.toUpperCase() + afterfirst + " ";
            }
            else {
                capitalizeWord += w + " ";
            }
        }
        return capitalizeWord.trim();
    }

}
