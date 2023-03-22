package com.neo.utils;

public class Validatation {

    public void checkNameNull(String name) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("Name is empty");
        }
    }
    public static boolean checkEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(regex);
    }
    public static boolean checkName(String name) {
        String regex = "^[A-Za-z0-9+_.-]+$";
        return name.matches(regex);
    }
    public static boolean checkAge(Integer age) {
        String regex = "^[0-9]+$";
        return age.toString().matches(regex);
    }
    public static boolean checkAddress(String address) {
        String regex = "^[A-Za-z0-9+_.-]+$";
        return address.matches(regex);
    }

}
