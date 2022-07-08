import java.util.*;

public class Polynomial {

	Comparator<Integer> reversedComp = (i, j) -> j.compareTo(i);
	Map<Integer, Integer> tm = new TreeMap<Integer, Integer>(reversedComp);
	// Create an empty polynomial
	public Polynomial() {}

	// Create a single-term polynomial
	public Polynomial(int coef, int exp) {
		tm.put(exp, coef);
	}

	// Add opnd to 'this' polynomial; 'this' is returned
	public Polynomial add(Polynomial opnd) {
		Iterator<Integer> exps = opnd.tm.keySet().iterator();
		while(exps.hasNext()){
			int exp = exps.next();
			int coef = opnd.tm.get(exp);
			if(this.tm.containsKey(exp)){
				coef = this.tm.get(exp) + coef;
				this.tm.replace(exp, coef);
			}
			else this.tm.put(exp, coef);
		}
		return this;
	}

	// Subtract opnd from 'this' polynomial; 'this' is returned
	public Polynomial sub(Polynomial opnd) {
		Iterator<Integer> exps = opnd.tm.keySet().iterator();
		while(exps.hasNext()){
			int exp = exps.next();
			int coef = - opnd.tm.get(exp);
			if(this.tm.containsKey(exp)){
				coef = this.tm.get(exp) + coef;
				this.tm.replace(exp, coef);
			}
			else this.tm.put(exp, coef);
		}
		return this;
	}

	// Print the terms of 'this' polynomial in decreasing order of exponents.
	// No pair of terms can share the same exponent in the printout.
	public void print() {
		Iterator<Integer> exps = tm.keySet().iterator();
		while(exps.hasNext()){
			int exp = exps.next();
			int coef = tm.get(exp);
			System.out.print(coef + " " + exp + " ");
		}
	}
}
