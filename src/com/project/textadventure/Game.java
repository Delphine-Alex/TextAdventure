package com.project.textadventure;

import java.util.Scanner;

public class Game {
	
	int playerHP;
	String playerWeapon;
	String playerName;
	int number;
	
	Scanner scanner;
	Scanner enterScanner;
	
	public static void main (String[] args) {
		
		
		Game game = new Game();
		game.playerSetUp();
		game.townGate();
		
	}
	
	
	public void playerSetUp() {
			
		
		playerHP = 15;
			
		playerWeapon = "Knife";
		
		System.out.println("Your HP: " + playerHP);
		System.out.println("Your weapon: " + playerWeapon);
			
		scanner = new Scanner(System.in);
			
		System.out.println("Please enter your name:");
			
		playerName = scanner.nextLine();
		
		System.out.println("");
		System.out.println("Hello " + playerName + ", let's start your adventure!");
	}
	
	
	public void townGate() {
		
		System.out.println("\n-------------------------------------------\n");
		System.out.println("Your are at the gate of the town.");
		System.out.println("A guard is standing in front of you.");
		System.out.println("");
		System.out.println("What do you want to do?");
		System.out.println("");
		System.out.println("1: Talk to the guard");
		System.out.println("2: Attack the guard");
		System.out.println("3: Leave");
		System.out.println("\n-------------------------------------------\n");
		
		number = scanner.nextInt();
		
		enterScanner = new Scanner(System.in);
		
		
		if (number == 1) {
			System.out.println("\n-------------------------------------------\n");
			System.out.println("Guard: Hello there, stranger! So your name is " + playerName + "? Sorry but we cannot let stranger enter our town.\n");
			System.out.println("\n(Press enter to continue)");
			enterScanner.nextLine();
			townGate();
		}
		if (number == 2) {
			playerHP -= 2;
			System.out.println("\n-------------------------------------------\n");
			System.out.println("Guard: Hey don't be stupid.\n\nThe guard hit you so hard and you gave up.\n(You received 2 damages)\n");
			System.out.println("Your HP: " + playerHP);
			System.out.println("\n(Press enter to continue)");
			enterScanner.nextLine();
			townGate();
		}
		if (number == 3) {
			
		}
	}
		
		

}
