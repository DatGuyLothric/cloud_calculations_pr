package com.company.caller;

import com.company.ate.Ate;

public class Caller {
    public String name;
    public Ate ate;

    public Caller(String name, Ate ate) {
        this.name = name;
        this.ate = ate;
    }

    public void call(String number) {
        System.out.println(this.name + " is trying to call to " + number);
        this.ate.call(number, this);
    }

    public void abort(String number) {
        this.ate.abort(number, this);
    }
}
