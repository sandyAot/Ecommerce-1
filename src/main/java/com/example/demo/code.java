package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Java Solution
public class code {
	

	// Driver program to test above functions
	public static void main(String[] args)
	{

		String str = "aabb";
		//System.out.println("Length is: " + longestPalSubstr(str));
		int[] a= {7,6,4,3,1};
		int []b= {7,-10,2,1,1,5};
		int []c= {0,1,2,0,1,2,1,0,2};
		int []d= {-1,2,-2,3,-3,4,-4};
		int []e= {1,2};
		int []f= {1,2,3,4};
		int g[] = new int[] { 1, 4,3,4,2};
		int []h={ 1, 4, 45, 6, 10, 8 };
		int []i1= { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		 int arr[] = {12, 4, 7, 9, 2, 23,25, 41, 30, 40, 28,42, 30, 44, 48, 43,50};
		 int arr1[]= { 1, -2, -3, 0, 7, -8, -2};
		 //max_consicutive_subsequence(arr1);
		// chocolate_problem(arr,7);
		//trapping_water(i1);
        //triplet_to_a_particular_sum(h,24);
		//min_number_of_operation_to_make_an_array_palindrome(f);
		//sub_set_or_not(e,f);
		//best_time_to_buy_and_sell_stocks(a);
		//best_time_to_buy_and_sell_stocks2(b);
		//find_all_pairs_on_integer_array_whose_sum_is_equal_to_given_number(b,6);
		//reverse_array(b);
		//max_and_min_in_array(b);
		//kth_max_value_in_array(b,4);
		//sort_0_1_2(c);
		//move_negative_elements_to_one_side_of_array(d);
		//unio_and_intersection_of_2_sorted_array(e,f);
		//rotate_array(e,2);
		//max_contigious_sum(b);
		//minimum_jump_to_reach_end(g);
		//dublicate_n_1array(g);
		 maxium_product_of_subarray(arr1);
	}

	private static void maxium_product_of_subarray(int[] arr1) {
		// TODO Auto-generated method stub
		
		int n=arr1.length;
		int max_so_far=1;
		int min_so_far=1;
		int max=0;
		for(int i=0;i<n;i++) {
			if(arr1[i]==0) {
				min_so_far=1;
				max_so_far=1;
			}
			else if(arr1[i]>0) {
				max_so_far=max_so_far*arr1[i];
				min_so_far=Math.min(arr1[i]*min_so_far, 1);
			}
			else {
				int temp=max_so_far;
				max_so_far=Math.max(min_so_far*arr1[i],1);
				min_so_far=temp*arr1[i];
			}
			if(max<max_so_far) {
				max=max_so_far;
			}
		}
		System.out.println(max);
		
		
		
		
		
	}

	private static void max_consicutive_subsequence(int[] arr1) {
		// TODO Auto-generated method stub
		Set<Integer>s=new HashSet<>();
		int ans=0;
		int max=0;
		for(int i:arr1) {
			s.add(i);
		}
		for(int j=0;j<arr1.length;j++) {
			int m=arr1[j];
			if(!s.contains(m-1)) {
				while(s.contains(m)) {
					m++;
				}
				max=m-arr1[j];
				if(ans<max) {
					ans=max;
				}
				
			}
		}
		System.out.println(ans);
		
	}

	private static void chocolate_problem(int[] arr, int k) {
		// TODO Auto-generated method stub
		if(arr.length==0) {
			System.out.println("nahi hoga");
		}
		if(arr.length<k) {
			System.out.println("phir bhi nahi hoga");
		}
		int min_diff=9999999;
		for(int i=0;k+i-1<arr.length;i++) {
			if(arr[k+i-1]-arr[i]<min_diff) {
				min_diff=arr[k+i-1]-arr[i];
			}
			
		}
		System.out.println(min_diff);
		
	}

	private static void trapping_water(int[] i1) {
		// TODO Auto-generated method stub
		int n=i1.length;
		int water=0;
		int []left=new int [n];
		left[0]=i1[0];
		int []right =new int [n];
		for(int i=1;i<n;i++) {
			left[i]=Math.max(left[i-1], i1[i]);
		}
			right[n-1]=i1[n-1];
		for(int j=n-2;j>0;j--) {
			right[j]=Math.max(right[j+1], i1[j]);
		}
		for(int k=0;k<n;k++) {
			water+=Math.min(left[k], right[k])-i1[k];
		}
		
		
		
		System.out.println(water);
		
	}

	private static void triplet_to_a_particular_sum(int[] h, int k) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<h.length-2;i++) {
			int cur_sum=k-h[i];
			Set<Integer>s=new HashSet<>();
			for(int j=i+1;j<h.length;j++) {
				if(s.contains(cur_sum-h[j])) {
					//System.out.println(h[i]);System.out.println(h[j]);System.out.println(cur_sum-h[j]);
					//break;
					System.out.printf("Triplet is %d,%d, %d", h[i],h[j], cur_sum - h[j]);
				}
				
				s.add(h[j]);
			
			}
			
		}
		
	}

	private static void sub_set_or_not(int[] e, int[] f) {
		// TODO Auto-generated method stub
		int flag=0;
		Set<Integer>s=new HashSet<>();
		for(int i=0;i<f.length;i++) {
			if(!s.contains(f[i])) {
				s.add(f[i]);
			}
			
		}
		for(int j=0;j<e.length;j++) {
			if(!s.contains(e[j])) {
				System.out.println("not subset");
				flag=1;
				break;
			}
		}
		if(flag==0) {
			System.out.println("subset");
		}
		
	}

	private static void min_number_of_operation_to_make_an_array_palindrome(int[] f) {
		// TODO Auto-generated method stub
		int ans=0;
		for(int i=0,j=f.length-1;i<=j;) {
			if(f[i]==f[j]) {
				i++;
				j--;
			}
			else if(f[i]<f[j]) {
				i++;
				f[i]=f[i]+f[i-1];
				ans++;
			}
			else {
				j--;
				f[j]=f[j]+f[j+1];
				ans++;
			}
		}
		for(int k:f) {
			System.out.print(k);
		}
		System.out.println();
		System.out.println(ans);
		
	}

	private static void dublicate_n_1array(int[] g) {
		// TODO Auto-generated method stub
		
		int slow=g[0];
		int fast =g[0];
		do {
			slow=g[slow];
			fast=g[g[fast]];
		}while(fast!=slow);
		fast=g[0];
		while(fast!=slow) {
			fast=g[fast];
			slow=g[slow];
		}
		System.out.println(fast);
		
	}
	private static void minimum_jump_to_reach_end(int[] g) {
		// TODO Auto-generated method stub
		if(g.length<=1) {
			System.out.println(1);
		}
		if(g[0]==0) {
			System.out.println(-1);
		}
		int max_reach=g[0];
		int step=g[0];
		int jump=1;
		for(int i=1;i<g.length;i++) {
			max_reach=Math.max(max_reach, g[i]+i);
			step--;
			if(i==g.length-1) {
				System.out.println(jump);
			}
			if(step==0) {
				jump++;
				if(i>=max_reach) {
					System.out.println(-1);
				}
				
				step=max_reach-i;
			}
		}
		//System.out.println(jump);
	}

	private static void max_contigious_sum(int[] b) {
		// TODO Auto-generated method stub
		int sum=0;
		int max=-9999;
		for(int i:b) {
			sum+=i;
			if(max<sum) {
				max=sum;
			}
			if(sum<0) {
				sum=0;
			}
		}
		System.out.println();
		System.out.println(max);
		
	}

	private static void rotate_array(int[] b, int i) {
		// TODO Auto-generated method stub 3
		for(int j=0;j<b.length;j++) {//1 2 3 4 5  5,1234
		if(j<i) {
			System.out.print(b[b.length+j-i]);
		}
		else {
			System.out.print(b[j-i]);
		}
		
		}
		
	}

	private static void unio_and_intersection_of_2_sorted_array(int[] e, int[] f) {
		// TODO Auto-generated method stub
		int i=0,j=0,k=0;
		int n=e.length;//1 2 3 4 6
		int m=f.length;//3,457
		int []s=new int[n+m];
		List<Integer>sm=new ArrayList<>();
		//intersection ka funda create an hashset aur 1st array mai traverse karke sara data daldo fir
		//dusara array mai dekho same aya toh insert in list
		while(i<n && j<m ) {
			if(e[i]<f[j]) {
				s[k]=e[i];
				sm.add(e[i]);
				i++;
				k++;
			}
			else if(e[i]>f[j]) {
				s[k]=f[j];
				sm.add(f[j]);
				j++;
				k++;
			}
			else {
				s[k]=e[i];
				sm.add(s[k]);
				k++;
				i++;
				j++;
			}
		}
		while(i<n) {
			s[k]=e[i];
			sm.add(e[i]);
			k++;
			i++;
		}
		while(j<m) {
			s[k]=f[j];
			sm.add(f[j]);
			j++;
			k++;
		}
		System.out.println();
		for(int l:s) {
			System.out.print(l);
		}
		System.out.println(sm);
		
		
	}

	private static void move_negative_elements_to_one_side_of_array(int[] d) {
		// TODO Auto-generated method stub
		int i=0;
		int j=d.length-1;
		while(i<j) {
			if(d[i]<0) {
				i++;
			}
			 if(d[i]>0) {
				int temp=d[i];
				d[i]=d[j];
				d[j]=temp;
				j--;
			}
			 if(d[j]<0) {
				int temp=d[j];
				d[j]=d[i];
				d[i]=temp;
				i++;
			}
			if(d[j]>0) {
				j--;
			}
		}
		System.out.println();
		for(int k:d) {
		System.out.print(k);
		}
	}

	private static void sort_0_1_2(int[] c) {
		// TODO Auto-generated method stub
		int count0=0;
		int count1=0;
		int count2=0;
		for(int i:c) {
			if(i==0) {
				count0++;
			}
			if(i==1) {
				count1++;
			}
			if(i==2) {
				count2++;
			}
		}
		int j=0;
		int []s=new int [c.length];
		while(count0 !=0) {
			s[j]=0;
			j++;
			count0--;
		}
		while(count1 !=0) {
			s[j]=1;
			j++;
			count1--;
		}
		while(count2!=0) {
			s[j]=2;
			j++;
			count2--;
		}
		System.out.println();
		for(int k:s) {
			System.out.print(k);
		}
		
	}

	private static void kth_max_value_in_array(int[] b, int k) {
		// TODO Auto-generated method stub
		Arrays.sort(b);
		System.out.println(b[b.length-k]);//0--1;1--1;2--1;3--2;4--5;6--7
		System.out.println(b[k-1]);
	}

	private static void kth_max_value_in_array(int[] b) {
		// TODO Auto-generated method stub
		
	}

	private static void max_and_min_in_array(int[] b) {
		// TODO Auto-generated method stub
		int max=-999999;
		int min=9999999;
		for(int i:b) {
			if(i>max) {
				max=i;
			}
			if(i<min) {
				min=i;
			}
		}
		System.out.println("max= "+max+" min= "+min);
	}

	private static void reverse_array(int[] b) {
		int i=0;
		int j=b.length-1;
		int temp=0;
		while(i<j) {
			temp=b[i];
			b[i]=b[j];
			b[j]=temp;
			i++;
			j--;
		}
		for(int k:b) {
			System.out.print(k+" ");
		}
		
	}

	private static void find_all_pairs_on_integer_array_whose_sum_is_equal_to_given_number(int[] b, int k) {
		// TODO Auto-generated method stub
		int count =0;
		Map<Integer,Integer>hm=new HashMap();
		for(int i:b) {
			if(!hm.containsKey(i)) {
				hm.put(i,1);
			}
			else {
				hm.put(i, hm.get(i)+1);
			}
		}
		for(int j:b) {
			if(hm.containsKey(k-j)) {
				count+=hm.get(k-j);
			}
			if(k-j==j) {
				count--;
			}
		}
		System.out.println(count/2);
		
	}

	private static void best_time_to_buy_and_sell_stocks3(int[] b) {
		// TODO Auto-generated method stub
		
		
	}

	private static void best_time_to_buy_and_sell_stocks2(int[] a) {
		// TODO Auto-generated method stub
		int profit=0;
		int b=a[0];
		for(int i=0;i<a.length;i++) {
			if(b<a[i]) {
				profit+=a[i]-b;
				b=a[i];
			}
			if(b>a[i]) {
				b=a[i];
			}
		}
		System.out.println(profit);
	}

	private static void best_time_to_buy_and_sell_stocks(int[] a) {
		// TODO Auto-generated method stub
		int max=0;
		int cur_max=0;
		int min=a[0];
		for(int i=0;i<a.length-1;i++) {
			if(min>a[i+1]) {
				min=a[i+1];
			}
			else {
				cur_max=a[i+1]-min;
				max=Math.max(max, cur_max);
			}
			
		}
		System.out.println(max);
	}

	private static int  longestPalSubstr(String str) {
		// TODO Auto-generated method stub
		int n=str.length();
		//char []s=str.toCharArray();
		int [][]dp=new int [n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(str.charAt(i-1)==str.charAt(j-1) && i!=j) {
					dp[i][j]=1+dp[i-1][j-1];
				}
				else {
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return dp[n][n];
	}

	
}

//// This code is contributed by Sumit Ghosh
