import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheGame {

	public static void main(String[] args) {
		//This is the main utilization for the Tic-Tac-Toe game
		//This one just requires proper arrangement of methods that are created in the Board class
		Boolean winner_status_game;
		String winner_player_game;
		Scanner scanner = new Scanner(System.in);
		
		//Create board 
		Board board = new Board();
		//Initiate board
		board.board_generator();
		winner_status_game = board.check_winner_status();		
		
		//We will play the game until there is a winner\
		//Naturally in the beginning there is no one who won straight away
		
		Integer players_check = 0;
		Integer difficulty_check = 0;
		
		while (players_check == 0) {
			board.clearScreen();
			board.start_screen_players();
			board.select_players(scanner.nextInt());
			players_check = board.check_amount();
		}
		
		if (players_check == 1) {
			while (difficulty_check == 0) {
				board.clearScreen();
				board.start_screen_difficulty();
				board.select_difficulty(scanner.nextInt());
				difficulty_check = board.check_difficulty();
			}
		}


		//To start the game:
		if (difficulty_check == 1 && players_check == 1) {
			while (winner_status_game == false) {
				//Show the board first and the player 1 starts
				board.clearScreen();
				board.board_disply();
				board.make_move(0);
				board.clearScreen();
				board.board_disply();
				//Check if anyone wins at this point
				board.check_game();
				winner_status_game = board.check_winner_status();
				if (winner_status_game == true) {
					break;
				}
				
				board.clearScreen();
				board.make_move(1);
				//Check if anyone wins at this point
				board.check_game();
				winner_status_game = board.check_winner_status();
				if (winner_status_game == true) {
					break;
				}
			}
		} else if (difficulty_check == 2 && players_check == 1) {
			while (winner_status_game == false) {
				board.clearScreen();
				board.make_move(1);
				//Check if anyone wins at this point
				board.check_game();
				winner_status_game = board.check_winner_status();
				if (winner_status_game == true) {
					break;
				}
				
				board.clearScreen();
				board.board_disply();
				board.make_move(0);
				board.clearScreen();
				board.board_disply();
				//Check if anyone wins at this point
				board.check_game();
				winner_status_game = board.check_winner_status();
				if (winner_status_game == true) {
					break;
				}
			}
		} else if (players_check == 2) {
			while (winner_status_game == false) {
				board.clearScreen();
				board.board_disply();
				board.make_move(0);
				board.clearScreen();
				board.board_disply();
				//Check if anyone wins at this point
				board.check_game();
				winner_status_game = board.check_winner_status();
				if (winner_status_game == true) {
					break;
					}
				
				board.clearScreen();
				board.board_disply();
				board.make_move(1);
				board.clearScreen();
				board.board_disply();
				//Check if anyone wins at this point
				board.check_game();
				winner_status_game = board.check_winner_status();
				if (winner_status_game == true) {
					break;
					}
				}
		//Last added game mode
		} else if (difficulty_check == 3 && players_check == 1) {
			while (winner_status_game == false) {
				board.clearScreen();
				board.make_move(1);
				//Check if anyone wins at this point
				board.check_game();
				winner_status_game = board.check_winner_status();
				if (winner_status_game == true) {
					break;
				}
				
				board.clearScreen();
				board.board_disply();
				board.make_move(0);
				board.clearScreen();
				board.board_disply();
				//Check if anyone wins at this point
				board.check_game();
				winner_status_game = board.check_winner_status();
				if (winner_status_game == true) {
					break;
				}
			}
		}
		
		board.clearScreen();
		board.board_disply();
		winner_player_game = board.check_winner();
		System.out.println("\nThe winner is: " + winner_player_game);
	}
}
