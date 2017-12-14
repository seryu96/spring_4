package com.iu.aop;

import org.springframework.stereotype.Component;

@Component
public class Transport {

	public void subway() {
		System.out.println("...Zzz");
		System.out.println("Phone");
		System.out.println("==============");
	}
	
	public void bus() {
		System.out.println("Music");
		System.out.println("...Zzz");
		System.out.println("++++++++++++++");
	}
	
	public void walk(int age) {
		System.out.println("Music");
		System.out.println("--------------");
	}
}
