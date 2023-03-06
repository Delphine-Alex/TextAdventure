package com.project.textadventure;

import java.util.Scanner;

public class Game {
	
	int playerHP;
	int monsterHP;
	String playerWeapon;
	String playerName;
	int number;
	int silverRing;
	
	Scanner scanner;
	Scanner enterScanner;
	
	public static void main (String[] args) {
		
		
		Game game = new Game();
		game.playerSetUp();
		game.townGate();
		
	}
	
	public void playerSetUp() {
			
		
		playerHP = 15;
		
		monsterHP = 20;
			
		playerWeapon = "Knife";
		
		System.out.println("Your HP: " + playerHP);
		System.out.println("Your weapon: " + playerWeapon);
			
		scanner = new Scanner(System.in);
		enterScanner = new Scanner(System.in);
			
		System.out.println("Please enter your name:");
			
		playerName = scanner.nextLine();
		
		System.out.println("");
		System.out.println("Hello " + playerName + ", let's start your adventure!");
	}
	
	public void townGate() {
		
		System.out.println("\n-------------------------------------------\n");
		System.out.println("Your are at the gate of the town.");
		System.out.println("A guard is standing in front of you.");
		System.out.println("\nWhat do you want to do?\n");
		System.out.println("1: Talk to the guard");
		System.out.println("2: Attack the guard");
		System.out.println("3: Leave");
		System.out.println("\n-------------------------------------------\n");
		
		number = scanner.nextInt();	
		
		if (number == 1) {
			if(silverRing == 1) {
				end();
			} else {
				System.out.println("\n-------------------------------------------\n");
				System.out.println("Guard: Hello there, stranger! So your name is " + playerName + "? Sorry but we cannot let stranger enter our town.\n\n");
				System.out.println("(Press enter to continue)");
				System.out.println("\n-------------------------------------------\n");
				enterScanner.nextLine();
				townGate();
			}
		} else if (number == 2) {
			playerHP -= 2;
			System.out.println("\n-------------------------------------------\n");
			System.out.println("Guard: Hey don't be stupid.\n\nThe guard hit you so hard and you gave up.\n(You received 2 damage)\n");
			System.out.println("Your HP: " + playerHP);
			System.out.println("\n\n(Press enter to continue)");
			System.out.println("\n-------------------------------------------\n");
			enterScanner.nextLine();
			townGate();
		} else if (number == 3) {
			crossRoad();
		} else {
			townGate();
		}
	}
	
	public void crossRoad () {
		
		System.out.println("\n-------------------------------------------\n");
		System.out.println("Your are at a crossroad. If you go south, you will go back to the town.");
		System.out.println("\nWhat do you want to do now?\n");
		System.out.println("1: Go north");
		System.out.println("2: Go east");
		System.out.println("3: Go south");
		System.out.println("4: Go west");
		System.out.println("\n-------------------------------------------\n");
	
		number = scanner.nextInt();
		
		if (number == 1) {
			north();
		} else if (number == 2) {
			east();
		} else if (number == 3) {
			townGate();
		} else if (number == 4) {
			west();
		} else {
			crossRoad();
		}
	
	}
	
	public void north() {
		
		System.out.println("\n-------------------------------------------\n");
		System.out.println("There is a river. You drink the water and rest at the riverside.");
		System.out.println("Your HP are recovered.");
		playerHP += 1;
		System.out.println("\nYour HP: " + playerHP);
		System.out.println("\n\n1: Go back to the crossroad");
		System.out.println("\n-------------------------------------------\n");
		
		number = scanner.nextInt();
		
		if (number == 1) {
			crossRoad();
		} else {
			north();
		}
	}
	
	public void east() {
		
		System.out.println("\n-------------------------------------------\n");
		System.out.println("You walk into a forest and found a Long Sword!");
		playerWeapon = "Long Sword";
		System.out.println("Your weapon: " + playerWeapon);
		System.out.println("\n\n1: Go back to the crossroad");
		System.out.println("\n-------------------------------------------\n");
		
		number = scanner.nextInt();
		
		if (number == 1) {
			crossRoad();
		} else {
			east();
		}
			
	}
	
	public void west() {
		
		System.out.println("\n-------------------------------------------\n");
		System.out.println("You encounter a dragon!");
		System.out.println("\nWhat do you want to do?\n");
		System.out.println("1: Fight");
		System.out.println("2: Run");
		System.out.println("\n-------------------------------------------\n");
		
		number = scanner.nextInt();
		
		if (number == 1) {
			fight();
		} else if (number == 2) {
			crossRoad();
		} else {
			west();
		}
		
	}
	
	public void fight() {
		
		System.out.println("\n-------------------------------------------\n");
		
		System.out.println("Dragon HP: " + monsterHP);
		System.out.println("Your HP: " + playerHP);
		
		System.out.println("\nYour weapon: " + playerWeapon);
		
		System.out.println("\nWhat do you want to do now?\n");
		System.out.println("1: Attack");
		System.out.println("2: Run");
		System.out.println("\n-------------------------------------------\n");
		
		number = scanner.nextInt();
		
		if (number == 1) {
			attack();
		} else if (number == 2) {
			crossRoad();
		} else {
			fight();
		}
		
	}
	
	public void attack() {
		
		int playerDamage = 0;
		
		if (playerWeapon.equals("Knife")) {
			playerDamage = new java.util.Random().nextInt(6);
		} else {
			playerDamage = new java.util.Random().nextInt(9);
		}
		
		int monsterDamage = 0;
		monsterDamage = new java.util.Random().nextInt(5);
		
		
		System.out.println("\n-------------------------------------------\n");
		System.out.println("You attacked the dragon and gave " + playerDamage + " damage!");
		
		monsterHP -= playerDamage; 
		System.out.println("Dragon HP: " + monsterHP);
		
		if (monsterHP < 1) {
			win();
		} else if (monsterHP > 0) {
			System.out.println("\nThe dragon attacked you and gave " + monsterDamage + " damage!");
			
			playerHP -= monsterDamage;
			System.out.println("Your HP: " + playerHP);
			
			if (playerHP < 1) {
				dead();
			} else if (playerHP > 0) {
				fight();
			}
		}
	}
	
	public void dead() {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You are dead!!!");
		System.out.println("\n\nGAME OVER");
		System.out.println("\n------------------------------------------------------------------\n");

	}
	
	public void win() {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You killed the dragon! The monster dropped a ring.");
		System.out.println("You obtaind a silver ring!\n");
		System.out.println("1: Go back to the crossroad");
		System.out.println("\n------------------------------------------------------------------\n");

		silverRing = 1;

		number = scanner.nextInt();
		
		if (number == 1) {
			crossRoad();
		} else {
			win();
		}

	}
	
	public void end() {
		
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("Guard: Oh you killed that dragon!?? Great!");
		System.out.println("Guard: It seems you are a trustworthy guy. Welcome to our town!");
		System.out.println("\n\nTHE END");
		System.out.println("\n------------------------------------------------------------------\n");
	}
		
		

}
