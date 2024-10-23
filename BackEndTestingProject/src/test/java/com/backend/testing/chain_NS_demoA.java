package com.backend.testing;

public class chain_NS_demoA {

	public chain_NS_demoA a() {
		System.out.println("execute mtd a");
		return new chain_NS_demoA();
	}
	public chain_NS_demoA b() {
		System.out.println("execute mtd b");
		return new chain_NS_demoA();
	}
	public chain_NS_demoB c() {
		System.out.println("execute mtd c");
		return new chain_NS_demoB();
	}
}
