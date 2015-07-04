//iterativni fibonacci algoritam

package fibo1;

import java.io.*;
import java.math.BigDecimal;

public class IterativniFibonacci {
	
	private static long brojPozivaFunkcijeFibo;
	
	public static BigDecimal fibo(int n)
	{   
		brojPozivaFunkcijeFibo++;
		
		if(n==0)
			return BigDecimal.ZERO;
		
		BigDecimal[] fiboNiz = new BigDecimal[n+1];
		
		fiboNiz[0]=BigDecimal.ZERO; 
		fiboNiz[1]=BigDecimal.ONE;
		
		for( int i=2; i<=n ; i++ )
		      fiboNiz[i]=fiboNiz[i-1].add(fiboNiz[i-2]);
		
		return fiboNiz[n];
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader linija = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("\nUnesi prirodan broj n: ");
		int n = Integer.parseInt(linija.readLine());
		
		long start = System.currentTimeMillis();
		BigDecimal vrijednostFibonaccijevogNiza = fibo(n);
		long kraj = System.currentTimeMillis();
		
		System.out.print("\nIterativni Fibonacci:\n");
		System.out.println("\n"+n+"-ta vrijednost Fibonaccijevog niza je: " +vrijednostFibonaccijevogNiza);
	    long trajanje = kraj - start;
	    System.out.println("Trajanje: " + trajanje + " milisekundi\nbroj poziva funkcije  fibo(): " + brojPozivaFunkcijeFibo);
	}
}