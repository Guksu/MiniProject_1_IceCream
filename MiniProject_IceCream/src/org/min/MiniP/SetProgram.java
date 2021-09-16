package org.min.MiniP;

public class SetProgram {
	// 초기 판매가 & 원가
	// 민트 판매가 : @3000원      슈팅스타 판매가 : @2500원
	// 민트 원가 : @1000원        슈팅스타 원가 : @700원
	
	private int mint , shootingStar , mintPrice, shootingStarPrice, mintExpense, shootingStarExpense;
	private double expense, sales, income;
	
	public SetProgram() {};
	public SetProgram(int mint, int shootingStar) {
		this.mint = mint;
		this.shootingStar = shootingStar;
		setMintPrice(3000);
		setMintExpense(1000);
		setShootingStarPrice(2500);
		setShootingStarExpense(700);
	}

	public int getMintSalesVolume() {
		return mint;
	}
	
	public int getShootingSalesVolume() {
		return shootingStar;
	}
	
	public double getExpense() {
		return expense = (double)(mint*mintExpense)+(shootingStar*shootingStarExpense) ;
	}

	public double getSales() {
		return sales = (double)(mint*mintPrice)+(shootingStar*shootingStarPrice);
	}

	public double getIncome() {
		return income = (double)(mint*(mintPrice-mintExpense))+(shootingStar*(shootingStarPrice-shootingStarExpense));
	}

	public int getMintPrice() {
		return mintPrice;
	}

	public int getShootingStarPrice() {
		return shootingStarPrice;
	}

	public int getMintExpense() {
		return mintExpense;
	}

	public int getShootingStarExpense() {
		return shootingStarExpense;
	}

	public void setMintPrice(int mintPrice) {
		this.mintPrice = mintPrice;
	}

	public void setShootingStarPrice(int shootingStarPrice) {
		this.shootingStarPrice = shootingStarPrice;
	}

	public void setMintExpense(int mintExpense) {
		this.mintExpense = mintExpense;
	}

	public void setShootingStarExpense(int shootingStarExpense) {
		this.shootingStarExpense = shootingStarExpense;
	}

	
}
