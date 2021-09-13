package org.min.MiniP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunProgram {

	List<SetProgram> monthSales = new ArrayList<>() ;
	int[] month = {1,2,3,4,5,6,7,8,9,10,11,12};
	Scanner sc;
	
	public RunProgram() {
		sc = new Scanner(System.in);
	}

	
	
	public void menu() {
		System.out.println("1. 월별 매출 확인");
		System.out.println("2. 판매량 입력");
		System.out.println("3. 판매량 수정");
		System.out.println("4. 매출비교");
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
			for(int i=0; i<month.length; i++) {
				mintSalesVolume += monthSales.get(i).getMintSalesVolume();
				shootingSalesVolume += monthSales.get(i).getShootingSalesVolume();
				totalSales += monthSales.get(i).getSales();
				totalIncome += monthSales.get(i).getIncome();
			}
			System.out.println("연간 민트 판매량: "+ mintSalesVolume+"개"+"\n연간 슈팅스타 판매량: "+shootingSalesVolume+"개"+
					"\n연간 총 매출: "+totalSales+"원"+"\n연간 총 순이익: "+ totalIncome+"원");
		} 
		else if(select1 == 2) {
			System.out.print("확인할 월을 입력하세요 >>");
			int select2 = sc.nextInt();
			for(int i=0; i<month.length; i++) {
				if(select2 == i) {
					mintSalesVolume += monthSales.get(i).getMintSalesVolume();
					shootingSalesVolume += monthSales.get(i).getShootingSalesVolume();
					totalSales += monthSales.get(i).getSales();
					totalIncome += monthSales.get(i).getIncome();
				}
			}
			System.out.println("["+select2+"]월"+ "\n민트 판매량: "+ mintSalesVolume+"개"+"\n슈팅스타 판매량: "+shootingSalesVolume+"개"+
					"\n매출액: "+totalSales+"원"+"\n순이익: "+ totalIncome+"원");
		} 
	}
	
	
	public void inputSales() {
		System.out.print("입력할 월을 입력하세요 >>");
		int inputSelect = sc.nextInt();
		System.out.print("민트아이스크림 판매량을 입력하세요 >>");
		int mintSalesVolume = sc.nextInt();
		System.out.print("슈팅스타 판매량을 입력하세요 >>");
		int shootingSalesVolume = sc.nextInt();
		
		for(int i = 0; i<month.length; i++) {
			if(inputSelect == month[i]) {
				monthSales.add(i,new SetProgram(mintSalesVolume, shootingSalesVolume));
			}
		}
	}

	public void modifySales() {
		System.out.print("수정할 월을 입력하세요>>");
		int modifySelect = sc.nextInt();
		System.out.print("수정할 민트아이스크림 판매량을 입력하세요 >>");
		int modifyMintSalesVolume = sc.nextInt();
		System.out.print("수정할 슈팅스타 판매량을 입력하세요 >>");
		int modifyShootingSalesVolume = sc.nextInt();

		for(int i = 0; i<month.length; i++) {
			if(modifySelect == month[i]) {
				monthSales.set(i,new SetProgram(modifyMintSalesVolume, modifyShootingSalesVolume));
			} 
		}
	}
	
	public void compareSales() {
		System.out.print("비교하고 싶은 월 두 개를 입력하세요 >>");
		int selectMonth1 = sc.nextInt();
		double selectMonth1Sales = 0;
		sc.nextLine();
		int selectMonth2 = sc.nextInt();
		double selectMonth2Sales = 0;
		
		for(int i =0; i<month.length; i++) {
			selectMonth1Sales = monthSales.get(selectMonth1).getSales();
			selectMonth2Sales = monthSales.get(selectMonth2).getSales();
		}
		
		if(selectMonth1Sales > selectMonth2Sales) {
			System.out.println(selectMonth1+"월은 "+selectMonth2+"월보다 매출액이 ["+(selectMonth1Sales-selectMonth2Sales)+"]원 더 많습니다.");
		} else if(selectMonth1Sales < selectMonth2Sales) {
			System.out.println(selectMonth2+"월은 "+selectMonth1+"월보다 매출액이 ["+(selectMonth2Sales-selectMonth1Sales)+"]원 더 많습니다.");
		} else if(selectMonth1Sales == selectMonth2Sales) {
			System.out.println("두 월은 매출액이 ["+selectMonth1Sales+"]원으로 같습니다");
		}
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
			case 3 : modifySales(); break;
			case 4 : compareSales(); break;
			case 0 : exit(); break;
			default : System.out.println("다시 선택하세요");
			}
		}
	}
	
	public void exit() {
		System.out.println("프로그램을 종료합니다");
		sc.close();
		System.exit(0);
	}
}
