/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis365week2.baristamatic;

import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author Matt Guzowski
 */
public class Ingredients {

    public String ingredientName;
    public int ingredientPrice; // in integer cents
    public HashMap ingredientHash = new HashMap;
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.ingredientName);
        hash = 37 * hash + this.ingredientPrice;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ingredients other = (Ingredients) obj;
        if (this.ingredientPrice != other.ingredientPrice) {
            return false;
        }
        if (!Objects.equals(this.ingredientName, other.ingredientName)) {
            return false;
        }
        return true;
    }
}
