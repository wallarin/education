package com.test.java.obj.access;

public class Ex35 {
	
	public static void main(String[] args) {
		
		//Ex35.java
		
		CPU cpu = new CPU();
		cpu.setModel("Intel i5");
		cpu.setSpeed("1.8");
		
		MainBoard mainBoard = new MainBoard();
		mainBoard.setModel("M5000");
		
		Storage storage = new Storage();
		storage.setModel("SM");
		storage.setType("SSD");
		storage.setSize(500);
		
		Computer computer = new Computer();
		computer.setCpu(cpu);
		computer.setMainboard(mainBoard);
		computer.setStorage(storage);
		
		
		Memory memory = new Memory();
		computer.setMemory(memory); //첫번째 메모리
		
		Memory memory2 = new Memory();
		computer.setMemory(memory2); //두번째 메모리
		
		Memory memory3 = new Memory();
		computer.setMemory(memory3);
		
		Memory memory4 = new Memory();
		computer.setMemory(memory4);
		
		//메모리 제거 방법
		computer.removeMemory();
		computer.removeMemory();
		computer.removeMemory();
		computer.removeMemory();
		
		
		/*
		//생각보다 별로 좋지 않은 방법 > 불편함 > 안정성이 떨어짐(불안정)
		Memory[] mlist = new Memory[2];
		
		Memory m1 = new Memory();
		mlist[0] = m1;
		
		//위의 나눠진 방식을 하나로도 가능
		mlist[1] = new Memory();
		
		computer.setMemorylist(mlist);
		*/
		
		User hong = new User();
		
		hong.setNick(0, "강아지");
		hong.setNick(1, "천재");
		hong.setNick(2, "뚱보");
		
		System.out.println(hong.getNick(1));
		
		for (int i = 0; i < 3; i++) {
			System.out.println(hong.getNick(i));
		}
		
		
		
		
	}//main

}//Ex35


//컴퓨터
//- CPU
//- MainBoard
//- Memory
//- Storage

class Computer {
	
	private CPU cpu;
	private MainBoard mainboard;
	
	private int i = 0; //메모리 관리 를 위한 변수
	private Memory[] memorylist = new Memory[4]; //***** //미리 방을 만들어놓는다.
	
	private Storage storage;
	
	public CPU getCpu() {
		return cpu;
	}
	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	public MainBoard getMainboard() {
		return mainboard;
	}
	public void setMainboard(MainBoard mainboard) {
		this.mainboard = mainboard;
	}
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	
	
	
//	잘 안쓰는 방법
//	public Memory[] getMemorylist() {
//		return memorylist;
//	}
//	public void setMemorylist(Memory[] memorylist) {
//		this.memorylist = memorylist;
//	}
	
	public void setMemory(Memory memory) {
		
		if (i == 4) {
			System.out.println("더 이상 남아있는 메모리 슬롯이 없습니다.");
			return; //빈 리턴문 > 메소드 중지
		}
		
		this.memorylist[i] = memory;
		i++;
		
	}
	
	//꽂았던 메모리 제거
	public void removeMemory() {
		
		if (i == 0) {
			System.out.println("더 이상 제거 가능한 메모리가 없습니다.");
			return;
		}
		
		i--;
		this.memorylist[i] = null; //NULL 상수, NULL 리터럴 > 주소값이 사라짐
		
	}
	
	
	
}

class CPU {
	private String model;
	private String speed;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	
}

class MainBoard {
	private String model;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
}

class Memory {
	private String model;
	private int size;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}

class Storage {
	private String model;
	private String type;
	private int size;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}


class User {
	
	private String name;
	private int age;
	
	private String[] nick = new String[10];
	
	
	public void setNick(int index, String value) {
		this.nick[index] = value;
	}
	
	public String getNick(int index) {
		return this.nick[index];
	}
	
}
	























