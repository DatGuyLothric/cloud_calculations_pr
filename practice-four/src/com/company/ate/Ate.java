package com.company.ate;

import com.company.caller.Caller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Ate {
    public HashMap<String, Caller> currentStack = new HashMap<String, Caller>();
    public HashMap<String, ArrayList<Caller>> waitingStack = new HashMap<String, ArrayList<Caller>>();

    public Ate() {}

    public void call(String number, Caller caller) {
        if (this.currentStack.containsKey(number)) {
            ArrayList<Caller> callers;
            if (this.waitingStack.containsKey(number)) {
                callers = this.waitingStack.get(number);
                this.waitingStack.remove(number);
            } else {
                callers = new ArrayList<Caller>();
            }
            callers.add(caller);
            this.waitingStack.put(number, callers);
            System.out.println(caller.name + " put to sleep");
        } else {
            this.currentStack.put(number, caller);
            System.out.println(caller.name + " started call to " + number);
            Runnable r = () -> {
                try {
                    ReentrantLock l = new ReentrantLock();
                    l.lock();
                    Thread.sleep(5000);
                    caller.abort(number);
                    l.unlock();
                } catch (InterruptedException e) {}
            };
            Thread t = new Thread(r);
            t.start();
        }
    }

    public void abort(String number, Caller caller) {
        if (this.currentStack.containsKey(number)) {
            if (this.currentStack.get(number) == caller) {
                this.currentStack.remove(number);
                System.out.println(caller.name + " aborted call to " + number);
                if (this.waitingStack.containsKey(number)) {
                    Caller c = this.waitingStack.get(number).get(0);
                    this.waitingStack.get(number).remove(0);
                    if (this.waitingStack.get(number).size() == 0) {
                        this.waitingStack.remove(number);
                    }
                    this.call(number, c);
                }
            }
        }
    }
}
