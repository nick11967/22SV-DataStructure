// Main for the Polynomial ADT

import java.io.*;

public class MainPoly {
  public static void main(String args[]) throws IOException
  {
    String strings1 = "./public/test01";
	  
    TextInputStream ifs = new TextInputStream(strings1);

    Polynomial poly1 = new Polynomial();
    Polynomial poly2 = new Polynomial();
    char op='\0';

    Polynomial p=poly1;
    while(ifs.ready()) {
        String token = ifs.readWord();
	char c = token.charAt(token.length()-1);
	if (c < '0' || '9' < c) {
		op = token.charAt(0);
		p = poly2;
		token = ifs.readWord();
	}
	int coef = Integer.parseInt(token);
	int exp = ifs.readInt();
	Polynomial temp = new Polynomial(coef,exp);
	p.add(temp);
    }
	  
    System.out.print('(');
    poly1.print();

    switch(op) {
    case '+': poly1.add(poly2); break;
    case '-': poly1.sub(poly2); break;
    default:
    }

    System.out.print(") "+op+" (");
    poly2.print();
    System.out.print(") = (");
    poly1.print();
    System.out.println(')');
  }
}

