package com.hs1;

public class Subscriptions {
    private String name;
    private boolean subscribed;

    public Subscriptions(boolean subscribed, String name) {
        this.subscribed = subscribed;
        this.name = name;
    }

    public void printSubscriptionNameAndStatus() {
        System.out.println(this.name + " is " + (subscribed ? "subscribed" : "not subscribed"));
    }
}
