import java.util.*;

public class Polynomial {
  TreeMap<Integer, Integer> polyMap = new TreeMap<>(Comparator.reverseOrder());
  
  // Create an empty polynomial
  public Polynomial() { }

  // Create a single-term polynomial
  public Polynomial(int coef, int exp) { polyMap.put(exp, coef); }

  // Add opnd to 'this' polynomial; 'this' is returned
  public Polynomial add(Polynomial opnd) {
    for(int key: opnd.polyMap.keySet()){
      if(polyMap.containsKey(key))
        polyMap.put(key, polyMap.get(key)+opnd.polyMap.get(key));
      else
        polyMap.put(key, opnd.polyMap.get(key));
      if(polyMap.get(key)==0) polyMap.remove(key);
    }
    return this;
  }

  // Subtract opnd from 'this' polynomial; 'this' is returned
  public Polynomial sub(Polynomial opnd) {
    for(int key: opnd.polyMap.keySet()){
      if(polyMap.containsKey(key))
        polyMap.put(key, polyMap.get(key)+opnd.polyMap.get(key));
      else
        polyMap.put(key, opnd.polyMap.get(key));
      if(polyMap.get(key)==0) polyMap.remove(key);
    }
    return this;
  }

  // Print the terms of 'this' polynomial in decreasing order of exponents.
  // No pair of terms can share the same exponent in the printout.
  public void print() {
    for(int key: polyMap.keySet()){
      System.out.print(polyMap.get(key)+" "+key+" ");
    }
  }

}