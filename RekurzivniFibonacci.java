
//rekurzivni fibonacci algoritam
package fibo1;

import java.io.*;
import java.math.BigDecimal;

public class RekurzivniFibonacci {
	
	private static long brojPozivaFunkcijeFibo;

	public static BigDecimal fibo(long n)
	{   
		brojPozivaFunkcijeFibo++;
		
		if(n==0)
			return BigDecimal.ZERO;
		if(n==1)
			return BigDecimal.ONE;
		
	    return fibo(n-1).add(fibo(n-2));
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader linija = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("\nUnesi prirodan broj n: ");
		int n = Integer.parseInt(linija.readLine());
		
		long start = System.currentTimeMillis();
		BigDecimal vrijednostFibonaccijevogNiza = fibo(n);
		long kraj = System.currentTimeMillis();
		
		System.out.print("\nRekurzivni Fibonacci:\n");
		System.out.println("\n"+n+"-ta vrijednost Fibonaccijevog niza je: " +vrijednostFibonaccijevogNiza);
	    long trajanje = kraj - start;
	    System.out.println("Trajanje: " + trajanje + " milisekundi\nbroj poziva funkcije  fibo(): " + brojPozivaFunkcijeFibo);
	}
}
