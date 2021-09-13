package org.min.MiniP;

public class SetProgram {

	// 민트 판매가 : @3000원      슈팅스타 판매가 : @2500원
	// 민트 원가 : @1000원        슈팅스타 원가 : @700원
	
	private int mint , shootingStar;
	private double expense, sales, income;
	
	public SetProgram(int mint, int shootingStar) {
		this.mint = mint;
		this.shootingStar = shootingStar;
	}

	public int getMintSalesVolume() {
		return mint;
	}
	
	public int getShootingSalesVolume() {
		return shootingStar;
	}
	
	public double getExpense() {
		return expense = (mint*1000)+(shootingStar*700);
	}

	public double getSales() {
		return sales = (mint*3000)+(shootingStar*2500);
	}

	public double getIncome() {
		return income = (mint*2000)+(shootingStar*1800);
	}

}
