package com.example.assignment1;

public class Utilities {

    //eircode
    public static boolean validEircode(String eircode){
        if(eircode.length() == 7){
            if(eircode.substring(0,1).matches("[a-zA-Z]+")){
                if(eircode.substring(1,3).matches("[0-9]+")){
                    if(eircode.substring(3,7).matches("[a-zA-Z0-9]+")){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //Eircode validation end

    //Valid Identifier
    public static boolean validIdentifier(String identifier){
        if(identifier.length() == 2){
            if(identifier.substring(0,1).matches("[a-zA-Z]+")){
                if(identifier.substring(1,2).matches("[0-9]+")){
                    return true;
                }
            }
        }
        return false;
    }

    //Valid PPS
    public static boolean validPPS(String pps){
        if(pps.length() == 8){
            if(pps.substring(0,7).matches("[0-9]+")){
                if(pps.substring(7,8).matches("[a-zA-Z]+")){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validEmail(String email){
        return (email.contains("@") && email.contains(".com"));
    }

}
