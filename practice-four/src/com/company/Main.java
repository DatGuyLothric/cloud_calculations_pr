package com.company;

import com.company.ate.Ate;
import com.company.caller.Caller;

public class Main {
    public static void main(String[] args) {
        Ate ate = new Ate();
        Caller denis = new Caller("Denis", ate);
        Caller roman = new Caller("Roman", ate);
        Caller ilya = new Caller("Ilya", ate);
        Caller sasha = new Caller("Sasha", ate);
        Caller lera = new Caller("Lera", ate);
        Caller kira = new Caller("Kira", ate);
        Caller ivan = new Caller("Ivan", ate);

        denis.call("1122");
        roman.call("2345");
        ilya.call("1122");
        sasha.call("1122");
        lera.call("2345");
        kira.call("2345");
        ivan.call("1122");
    }
}
