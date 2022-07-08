import java.util.*;

public class Polynomial {
  TreeMap<Integer, Integer> poly;
  
  // Create an empty polynomial
  public Polynomial() { poly = new TreeMap<>(Comparator.reverseOrder()); }

  // Create a single-term polynomial
  public Polynomial(int coef, int exp) {
    poly = new TreeMap<>(Comparator.reverseOrder());
    poly.put(exp, coef);
  }

  // Add opnd to 'this' polynomial; 'this' is returned
  public Polynomial add(Polynomial opnd) {
    TreeMap<Integer, Integer> otherPoly = opnd.poly;

    for(int key: otherPoly.keySet()){
      if(poly.containsKey(key))
        poly.put(key, poly.get(key)+otherPoly.get(key));
      else
        poly.put(key, otherPoly.get(key));
      if(poly.get(key)==0) poly.remove(key);
    }
    return this;
  }

  // Subtract opnd from 'this' polynomial; 'this' is returned
  public Polynomial sub(Polynomial opnd) {
    TreeMap<Integer, Integer> otherPoly = opnd.poly;

    for(int key: otherPoly.keySet()){
      if(poly.containsKey(key))
        poly.put(key, poly.get(key)-otherPoly.get(key));
      else
        poly.put(key, -otherPoly.get(key));
      if(poly.get(key)==0) poly.remove(key);
    }
    return this;
  }

  // Print the terms of 'this' polynomial in decreasing order of exponents.
  // No pair of terms can share the same exponent in the printout.
  public void print() {
    for(int key: poly.keySet()){
      System.out.print(poly.get(key)+" "+key+" ");
    }
  }

}