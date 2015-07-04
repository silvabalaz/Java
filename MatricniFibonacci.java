//matrično
package fibo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class MatricniFibonacci {

	private static long brojPozivaFunkcijeFibo;
	
	static BigDecimal fibo( long n)
	{
		brojPozivaFunkcijeFibo++;
		
		BigDecimal A[][] ={{BigDecimal.ZERO, BigDecimal.ONE},{BigDecimal.ONE, BigDecimal.ONE}};
		
		if(n==0)
			return BigDecimal.ZERO;
		
		return potenciranje(A,n)[1][0];
	}
	
	static BigDecimal[][] potenciranje(BigDecimal A[][], long n)
	{
		BigDecimal[][] rezultat = {{BigDecimal.ONE, BigDecimal.ZERO},{BigDecimal.ZERO, BigDecimal.ONE}};
			
		while(n!=0)
	{
		if(n%2!=0)
		rezultat = mnozenje(rezultat, A);
		
		n/=2;
		A = mnozenje(A, A);
	}
		       
		return rezultat;
		     
	}
		
		
		
	
	
	static BigDecimal[][] mnozenje(BigDecimal M1[][], BigDecimal M2[][])
	{
		BigDecimal[][] rezultat = new BigDecimal[2][2];
		
		rezultat[0][0] = M1[0][0].multiply(M2[0][0]).add(M1[0][1].multiply(M2[1][0]));
		rezultat[0][1] = M1[0][0].multiply(M2[0][1]).add(M1[0][1].multiply(M2[1][1]));
		rezultat[1][0] = M1[1][0].multiply(M2[0][0]).add(M1[1][1].multiply(M2[1][0]));
		rezultat[1][1] = M1[1][0].multiply(M2[0][1]).add(M1[1][1].multiply(M2[1][1]));
		
		return rezultat;
	}
	
	 public static void main(String[] args)throws IOException
	 {
		BufferedReader linija = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("\nUnesi prirodan broj n: ");
		int n = Integer.parseInt(linija.readLine());
		
		long start = System.currentTimeMillis();
		BigDecimal vrijednostFibonaccijevogNiza = fibo(n);
		long kraj = System.currentTimeMillis();
		
		System.out.print("\nMatrični Fibonacci:\n");
		System.out.println("\n"+n+"-ta vrijednost Fibonaccijevog niza je: " +vrijednostFibonaccijevogNiza);
	    long trajanje = kraj - start;
	    System.out.println("Trajanje: " + trajanje + " milisekundi\nbroj poziva funkcije  fibo(): " + brojPozivaFunkcijeFibo);
	  }
}
