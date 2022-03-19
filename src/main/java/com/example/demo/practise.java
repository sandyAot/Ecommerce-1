package com.example.demo;

// Java program to illustrate Concept of Aggregation

// Importing required classes
//Make a set of maximum elements from two
//arrays A[] and B[]
import java.io.*;
import java.util.*;
class practise
{
	
	static void maximizeTheFirstArray(int[] A, int[] B,int n)
	{
	
		// Create copies of A[] and B[] and sort
		// the copies in descending order.
		ArrayList<Integer> temp1 = new ArrayList<Integer>();
		ArrayList<Integer> temp2 = new ArrayList<Integer>();
		for(int i : A)
		{
			temp1.add(i);
		}
		for(int i:B)
		{
			temp2.add(i);
		}
		Collections.sort(temp1, Collections.reverseOrder());
		Collections.sort(temp2, Collections.reverseOrder());
		
		// Put maximum n distinct elements of
		// both sorted arrays in a map.
		Map<Integer,Integer> m = new HashMap<>();
		int i = 0, j = 0;
		while (m.size() < n)
		{
			if (temp1.get(i) >= temp2.get(j))
			{
				if(m.containsKey(temp1.get(i)))
				{
					m.put(temp1.get(i), m.get(temp1.get(i)) + 1);
				}
				else
				{
					m.put(temp1.get(i), 1);
				}
				i++;
			}
			else
			{
				if(m.containsKey(temp2.get(j)))
				{
					m.put(temp2.get(j), m.get(temp2.get(j)) + 1);
				}
				else
				{
					m.put(temp2.get(j), 1);
				}
				j++;
			}
		}
		
		// Copy elements of A[] to that
		// are present in hash m.
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (i = 0; i < n; i++)
			if (m.containsKey(A[i]))
			res.add(A[i]);
	
		// Copy elements of B[] to that
		// are present in hash m. This time
		// we also check if the element did
		// not appear twice
		System.out.println(m);
		for (i = 0; i < n; i++)
			if (m.containsKey(B[i]) && m.get(B[i]) == 1)
			res.add(B[i]);
	
		// print result
		for (i = 0; i < n; i++)
			System.out.print(res.get(i)+" ");
	}
	
	// Driver program
	public static void main (String[] args)
	{
		Predicate p=(int x)->x%2==0;
		System.out.println(p.test(30));
		int A[] = {  2, 3, 6,9,7 };
		int B[] = { 1,0,8,7,4};
		int n = A.length;
		String s="abb bbcc dddd eee";
		if(s.contains("eee")) {
			String j=s.replace("eee", "fff");
			System.out.println(j);
		}
		//System.out.println(m);
		maximizeTheFirstArray(A, B, n);
	}
}

//This code is contributed by rag2127


