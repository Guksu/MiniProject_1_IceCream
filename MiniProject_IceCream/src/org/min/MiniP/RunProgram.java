package org.min.MiniP;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunProgram{
	
	DecimalFormat formatter = new  DecimalFormat("###,###.##");
	List<SetProgram> monthSales = new ArrayList<>() ;
	Scanner sc;
	
	public RunProgram() {
		sc = new Scanner(System.in);
		for(int i =0; i<12; i++) {
			monthSales.add(i,new SetProgram(0,0));
		}
	}
	
	public void menu() {
		System.out.println("1. 월별 매출 확인");
		System.out.println("2. 판매량 입력 혹은 수정");
		System.out.println("3. 매출비교");
		System.out.println("4. 가격 혹은 원가 변경");
		System.out.println("0. 프로그램 종료");
	}
	
	public void showSales() {
		System.out.println("1. 연간 매출 확인");
		System.out.println("2. 월별 매출 확인");
		
		int select1 = sc.nextInt();
		int mintSalesVolume  = 0;
		int shootingSalesVolume = 0;
		double totalSales = 0;
		double totalIncome =0;
		
		if(select1 == 1) {
			for(int i=0; i<monthSales.size(); i++) {
				mintSalesVolume += monthSales.get(i).getMintSalesVolume();
				shootingSalesVolume += monthSales.get(i).getShootingSalesVolume();
				totalSales += monthSales.get(i).getSales();
				totalIncome += monthSales.get(i).getIncome();
				System.out.println((i+1)+"월 민트 판매량: "+monthSales.get(i).getMintSalesVolume()+"개"+" , 슈팅스타 판매량: "+monthSales.get(i).getShootingSalesVolume()+"개");
			}
			System.out.println("--------------------------");
			System.out.println("연간 민트 판매량: "+ mintSalesVolume+"개"+"\n연간 슈팅스타 판매량: "+shootingSalesVolume+"개"+
					"\n연간 총 매출: "+formatter.format(totalSales)+"원"+"\n연간 총 순이익: "+ formatter.format(totalIncome)+"원");
		} 
		else if(select1 == 2) {
			System.out.print("확인할 월을 입력하세요 >>");
			int select2 = (sc.nextInt());
			if( select2<=0 ||  select2>12) {
				System.out.println("다시 입력하세요");
				showSales();
			}else {
				mintSalesVolume = monthSales.get(select2-1).getMintSalesVolume();
				shootingSalesVolume = monthSales.get(select2-1).getShootingSalesVolume();
				totalSales = monthSales.get(select2-1).getSales();
				totalIncome = monthSales.get(select2-1).getIncome();

				System.out.println("["+select2+"]월"+ "\n민트 판매량: "+ mintSalesVolume+"개"+"\n슈팅스타 판매량: "+shootingSalesVolume+"개"+
						"\n매출액: "+formatter.format(totalSales)+"원"+"\n순이익: "+ formatter.format(totalIncome)+"원");
			}
		} 
		else {
			System.out.println("다시 입력하세요");
			showSales();
		}
	}
	
	public void inputSales() {
		System.out.print("입력할 월을 입력하세요 >>");
		int inputSelect = sc.nextInt();
		if(inputSelect<=0 || inputSelect>12) {
			System.out.println("다시 입력하세요");
			inputSales();
		}else {
			System.out.print("민트아이스크림 판매량을 입력하세요 >>");
			int mintSalesVolume = sc.nextInt();
			System.out.print("슈팅스타 판매량을 입력하세요 >>");
			int shootingSalesVolume = sc.nextInt();

			monthSales.set(inputSelect-1,new SetProgram(mintSalesVolume, shootingSalesVolume));
		}
	}

	public void compareSales() {
		System.out.print("비교하고 싶은 월 두 개를 입력하세요 >>");
		int selectMonth1 = sc.nextInt();
		sc.nextLine();
		int selectMonth2 = sc.nextInt();
		double selectMonth1Sales = 0;
		double selectMonth2Sales = 0;
		if(selectMonth1<=0 || selectMonth1>12 || selectMonth2<=0 || selectMonth1>12 ||selectMonth1 == selectMonth2) {
			System.out.println("다시 입력하세요");
			compareSales();
		}else {
			for(int i =0; i<monthSales.size(); i++) {
				selectMonth1Sales = monthSales.get(selectMonth1-1).getSales();
				selectMonth2Sales = monthSales.get(selectMonth2-1).getSales();
			}

			if(selectMonth1Sales > selectMonth2Sales) {
				System.out.println(selectMonth1+"월은 "+selectMonth2+"월보다 매출액이 ["+formatter.format(selectMonth1Sales-selectMonth2Sales)+"]원 더 많습니다.");
			} else if(selectMonth1Sales < selectMonth2Sales) {
				System.out.println(selectMonth2+"월은 "+selectMonth1+"월보다 매출액이 ["+formatter.format(selectMonth2Sales-selectMonth1Sales)+"]원 더 많습니다.");
			} else if(selectMonth1Sales == selectMonth2Sales) {
				System.out.println("두 월은 매출액이 ["+formatter.format(selectMonth1Sales)+"]원으로 같습니다");
			}
		}
	}
	
	public void changeExpense() {
		System.out.println("1. 가격변경");
		System.out.println("2. 원가변경");
		int select1 = sc.nextInt();
		if(select1 ==1 ) {
			System.out.println("현재 민트 판매가는 : "+monthSales.get(0).getMintPrice()+"원 , 슈팅스타 판매가는 : "+monthSales.get(0).getShootingStarPrice()+"원 입니다.");
			System.out.println("변경하실 판매가를 선택하세요");
			System.out.println("[1. 민트 판매가 변경\t 2. 슈팅스타 판매가 변경\t3.모두 변경]");
			int select2 = sc.nextInt();
			if(select2 == 1 ) {
				System.out.println("변경할 가격을 입력하세요");
				int changeMintPrice = sc.nextInt();
				for(int i=0; i<monthSales.size(); i++) {
					monthSales.get(i).setMintPrice(changeMintPrice);
				}
			} else if(select2 ==2) {
				System.out.println("변경할 가격을 입력하세요");
				int changeShootingPrice = sc.nextInt();
				for(int i=0; i<monthSales.size(); i++) {
					monthSales.get(i).setShootingStarPrice(changeShootingPrice);
				}
			} else if(select2 == 3) {
				System.out.println("변경할 민트와 슈팅스타의 가격을 순서대로 입력하세요");
				int changeMintPrice = sc.nextInt();
				int changeShootingPrice = sc.nextInt();
				for(int i=0; i<monthSales.size(); i++) {
					monthSales.get(i).setMintPrice(changeMintPrice);
					monthSales.get(i).setShootingStarPrice(changeShootingPrice);
				}
			}
		} 
		else if(select1 ==2) {
			System.out.println("현재 민트 원가는 : "+monthSales.get(0).getMintExpense()+"원 , 슈팅스타 원가는 : "+monthSales.get(0).getShootingStarExpense()+"원 입니다.");
			System.out.println("변경하실 원가를 선택하세요");
			System.out.println("[1. 민트 원가 변경\t 2. 슈팅스타 원가 변경\t3.모두 변경]");
			int select2 = sc.nextInt();
			if(select2 == 1 ) {
				System.out.println("변경할 원가를 입력하세요");
				int changeMintExpense = sc.nextInt();
				for(int i=0; i<monthSales.size(); i++) {
					monthSales.get(i).setMintExpense(changeMintExpense);
				}
			} else if(select2 ==2) {
				System.out.println("변경할 원가를 입력하세요");
				int changeShootingExpense = sc.nextInt();
				for(int i=0; i<monthSales.size(); i++) {
					monthSales.get(i).setShootingStarExpense(changeShootingExpense);
				}
			} else if(select2 == 3) {
				System.out.println("변경할 민트와 슈팅스타의 원가를 순서대로 입력하세요");
				int changeMintExpense = sc.nextInt();
				int changeShootingExpense = sc.nextInt();
				for(int i=0; i<monthSales.size(); i++) {
					monthSales.get(i).setMintExpense(changeMintExpense);
					monthSales.get(i).setShootingStarExpense(changeShootingExpense);
				}
			}
		}else {
			System.out.println("다시 입력하세요");
			changeExpense();
		}
	}
	
	public void exit() {
		System.out.println("프로그램을 종료합니다");
		sc.close();
		System.exit(0);
	}
	
	public void run() {
		while(true) {
			menu();
			System.out.print("작업을 선택하세요 >>");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1 : showSales(); break;
			case 2 : inputSales(); break;
			case 3 : compareSales(); break;
			case 4 : changeExpense(); break;
			case 0 : exit(); break;
			default : System.out.println("다시 선택하세요");
			}
		}
	}
	
}
