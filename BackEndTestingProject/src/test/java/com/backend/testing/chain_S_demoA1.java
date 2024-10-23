package com.backend.testing;

public class chain_S_demoA1 {

	public static chain_S_demoA1 a() {
		System.out.println("execute mtd a");
		return new chain_S_demoA1();
	}
	public static chain_S_demoA1 b() {
		System.out.println("execute mtd b");
		return new chain_S_demoA1();
	}
	public static chain_NS_demoB c() {
		System.out.println("execute mtd c");
		return new chain_NS_demoB();
	}
}
