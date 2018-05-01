/*
 * code modified from https://github.com/stuff-and-exercises/barista-matic
 * modified to practice unit tests
 */
package cis365week2.baristamatic;

public class Drink {

    private String name;

    public Drink(String nameIn) {
        name = nameIn;
    }

    public String getDescription() {
        return name;
    }

    public int cost() { //is this needed?
        return 0;
    }

}
