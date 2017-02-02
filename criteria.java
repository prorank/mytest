import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Vector;
public class criteria 
{
public static void main(String[] args)
{
	AHP ahp=new AHP();
	int n;
	int NUMBER_COMPARISON;
	Scanner keyboard=new Scanner(System.in);
	System.out.println("Enter the number of criteria");
	System.out.println("n= ");
	n=keyboard.nextInt();
	NUMBER_COMPARISON=(n*n-n)/2;
	double[][] a=new double[n][n];
	String[] criteria=new String[n];
	double[] p=new double[NUMBER_COMPARISON];
	System.out.println("Enter the criteria:");
		for(int i=0;i<n;i++)
		{
		System.out.print("Criterion "+(i+1)+":");
		criteria[i]=keyboard.next();
		}

	System.out.println("Enter the comparison");
	 int m=0;
	 for(int i=0;i<n;i++)
            {
	 for(int j=i+1;j<n;j++)
	    {
		System.out.println("Compare "+criteria[i]+" with "+criteria[j]+":");
		p[m]=keyboard.nextDouble();		
		m++;
	    }
	    }
	a=ahp.initialize_matrix(p);
	ahp.show_matrix(a);
}}
	    
	     
 class AHP
	{
		public double[][] initialize_matrix(double[] p)
		{
		double a[][]=new double[p.length][p.length];
		int k=0;
	for(int i=0;i<p.length;i++)
		{
	for(int j=0;j<p.length;j++)
		{
	if(i==j)
		a[i][j]=1;
	else if(i<j)
		{
		a[i][j]=p[k];
		k++;
		}
	else if(i>j)
		a[i][j]=1/a[j][i];
		}
	}
return a;
}
public void show_matrix(double[][] b)
{
System.out.println("\nThe matrix a is:");
for(int i=0;i<b.length;i++)

for(int j=0;j<b[i].length;j++)
System.out.println(b[i][j]+" ");
System.out.println();
}}
