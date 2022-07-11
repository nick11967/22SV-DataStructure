import java.util.*;

public class Polynomial {
    private TreeMap<Integer, Integer> poly;

    // Create an empty polynomial
    public Polynomial() {
        this.poly = new TreeMap<Integer, Integer>(Collections.reverseOrder());
    }

    // Create a single-term polynomial
    public Polynomial(int coef, int exp) {
        poly = new TreeMap<Integer, Integer>(Collections.reverseOrder());
        poly.put(exp,coef);
    }
    // Addition
    public Polynomial add(Polynomial opnd) {
        for(Map.Entry<Integer, Integer> e : opnd.poly.entrySet()) {
            Integer key = e.getKey();
            Integer value = e.getValue();

            if(poly.containsKey(key)) {
                value += poly.get(key);
            } if(value==0) {
                poly.remove(key);
                continue;
            } else {
                poly.put(key,value);
            }
        }
        return this;
    }

    // Subtraction
    public Polynomial sub(Polynomial opnd) {
        for (Map.Entry<Integer, Integer> entry : opnd.poly.entrySet()) {
            Integer key = entry.getKey();
            Integer value = -entry.getValue();

            if(poly.containsKey(key)) {
                value += poly.get(key);
            } if(value==0) {
                poly.remove(key);
                continue;
            } else {
                poly.put(key,value);
            }
        }
        return this;
    }

    // Print the terms of 'this' polynomial in decreasing order of exponents.
    // No pair of terms can share the same exponent in the printout.
    public void print() {
        for(Map.Entry<Integer, Integer> e : poly.entrySet()) {
            Integer coef = e.getValue();
            Integer exp = e.getKey();
            if(coef!=0) {
                System.out.print(coef + " " + exp + " ");
            }
        }
    }
}
