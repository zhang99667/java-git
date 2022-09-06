package com.extension;

public class Extends01 {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = "银角大王";
        pupil.age = 10;
        pupil.testing();
        pupil.showInfo();

        Graduate graduate = new Graduate();
        graduate.name = "金角大王";
        graduate.age = 15;
        graduate.testing();
        graduate.showInfo();
    }
}
