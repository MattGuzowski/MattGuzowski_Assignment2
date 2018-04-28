/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis365week2.baristamatic;

/**
 *
 * @author Matt Guzowski
 */
    public class Drink {

    private String name;

    public Drink(String nameIn) {
        name = nameIn;
    }

    public String getDescription() {
        return name;
    }

    public int cost() {
        return 0;
    }

}
