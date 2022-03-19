package com.example.demo;

public class A {
	int n=10;
	int count =0;
	void printeven(){
		synchronized(this) {
			while(count<n) {
				while(count%2==1) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(count);
				count++;
				notify();
			}
		}
	}
		void printodd(){
			synchronized(this) {
				while(count<n) {
					while(count%2==0) {
						try {
							wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(count);
					count++;
					notify();
				}
		
	}}}

