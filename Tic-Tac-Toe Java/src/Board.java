import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Board {
	//This class contains information about the board that is being played on
	//We need 9 cells to play this game. It will be of a standard format, but one list should be enough to manage it
	private String[] board;
	private Scanner scanner = new Scanner(System.in); //This will read user's inputs if they are given
	private Random randomGenerator = new Random(); // We will need this to generate random values for our players
	private Boolean winner_status = false; //In the beginning of the game we naturally assume no one has one the game, so we can continue playing it
	private String winner_player;
	private Integer amount_of_players = 0;
	private Integer difficulty_setting = 0;
	
	public void clearScreen() {  
		//This will be used to clear the screen when needed
		//Referenced from: https://www.youtube.com/watch?v=Knl20uhL1B0
	    try {
	    	new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	    } catch(Exception E)
	    {
	    	System.out.println(E);
	    }
	} 
	
	public void start_screen_players() {
		//Create a retro style start screen for the players
		//To remind them of the 80s and their childhoods, fightingh computers and skynet
		System.out.println("------------------------------------------------");
		System.out.println("|         1 vs AI         |       1 vs 1       |");
		System.out.println("|        [press 1]        |      [press 2]     |");
		System.out.println("------------------------------------------------");
	}
	
	public void start_screen_difficulty() {
		//We will give the choice of difficulty as well to play for the player
		//Easy will be when the player starts the game
		//Medium will be when the AI starts the game
		//TODO: AI, that acts based on certain rules (yes, tic-tac-toe does have rules and some strategy that can create dead locks not allowing to win every
		System.out.println("-------------------------------------------");
		System.out.println("|     Easy     |    Medium    |   Hard    |");
		System.out.println("|  [press 1]   |   [press 2]  | [press 3] |");
		System.out.println("-------------------------------------------");
	}
	
	//This game will also have an option of being two players...oh yeah...getting fancy
	public void select_players(Integer amount_of_players_input) {
		//Set the conditions for how many players will be playing the game
		if (amount_of_players_input == 1 || amount_of_players_input == 2) {
			amount_of_players = amount_of_players_input;
		}		
	}
	
	public void select_difficulty(Integer difficulty_setting_input) {
		//Condition is set for how difficult the game will be
		if (difficulty_setting_input == 1 || difficulty_setting_input == 2 || difficulty_setting_input == 3) {
			difficulty_setting = difficulty_setting_input;
		}		
	}
	
	public Integer check_amount() {
		// Check amount of players that will be playing the game
		return amount_of_players;
	}
	
	public Integer check_difficulty() {
		// Check difficulty of the game played
		return difficulty_setting;
	}

	//Let us create a method to populate that board with so far empty cells (those here will be underscores
	public void board_generator() {
		//This will populate information in the board with 9 values for convenience
		String[] table = new String[9];
		String[] holder = {"|-|"};
		for (int i = 0; i < table.length; i++) {
			table[i] = holder[0];
		}
		this.board = table;
	}
	
	//Now it would be great to have a method that displays the board depending on what conditions it has 
	//One key feature is that we created a 1D array. We want the players to see it in 2D - height and width should be present
	//Further the function that is utilized displays the values that are currently present in the board that is being played with
	public void board_disply() {
		//This function will display the board, so hence it is voided
		//We need 3 Lines to be printed
		for (int i = 0; i < 3; i++) {
			System.out.print(" " + board[i] + " ");
		}
		System.out.println();
		for (int i = 3; i < 6; i++) {
			System.out.print(" " + board[i] + " ");
		}
		System.out.println();
		for (int i = 6; i < 9; i++) {
			System.out.print(" " + board[i] + " ");
		}
	}
	
	//From this point controls are created to adjust and modify any values in the board that was created
	//These methods will be re-utilized by the player and by the super stupid AI
	public void make_move(Integer player) {
		//The integer will declare who is playing, the player = 0, or the computer = 1
		//This is done not to create 2 methods for different player, rather just substitute it with a simple by-pass
		
		//Some adjustments are made if there are two players playing the game, but not drastic
		//Main methods will be kept almost the same way
		
		int row;
		int col;
		Boolean approved = false; 
		
		while (approved == false) {
			//This sets conditions for the human player
			//Obviously humans need to be able to enter information they want. They are picky.
			//The final code will not allow for the users to modify any values beyond 0 and 1, hence no extra check is done if anything else is passed...there is nothing to pass
			if (player == 0) {
				System.out.println();
				System.out.print("Place a marker in\nRow: ");
				row = scanner.nextInt();
				System.out.print("Column: ");
				col = scanner.nextInt();
				
				//First check if we are not operating outside of the boundreis of what is allowed
				if (row < 1 || row > 3 || col < 1 || col > 3) {
					continue;
				}
				
				//Second check will be to verify if we are dealing with an empty space that can be populated
				//Otherwise the player will be asked to re-enter the values he wants to populate
				if (board[col + ((row - 1) * 3) - 1] == "|-|") {
					board[col + ((row - 1) * 3) - 1] = "|X|";
					approved = true;
				} else {
					continue;
				}
			}
			//Now build conditions for the Super Smart AI to play.
			//This one will be random...no joke, it really will stand no chance.
			if (player == 1 && amount_of_players == 1 && (difficulty_setting == 1 || difficulty_setting == 2)) {
				//Pretty much the game is the same, only the rows and columns are populated randomly, so we need random values to "happen"
				row = randomGenerator.nextInt(3) + 1;
				col = randomGenerator.nextInt(3) + 1;
				
				//We will be extra cautious and make sure that the robot does not do any mistakes as well
				//First security check
				if (row < 1 || row > 3 || col < 1 || col > 3) {
					continue;
				}
				//Second Security Check and application of the robot's value
				if (board[col + ((row - 1) * 3) - 1] == "|-|") {
					board[col + ((row - 1) * 3) - 1] = "|O|";
					approved = true;
				} else {
					continue;
				}
			} else if (player == 1 && amount_of_players == 2) {
				System.out.println();
				System.out.print("Place a marker in\nRow: ");
				row = scanner.nextInt();
				System.out.print("Column: ");
				col = scanner.nextInt();
				
				//First check if we are not operating outside of the boundreis of what is allowed
				if (row < 1 || row > 3 || col < 1 || col > 3) {
					continue;
				}
				
				//Second check will be to verify if we are dealing with an empty space that can be populated
				//Otherwise the player will be asked to re-enter the values he wants to populate
				if (board[col + ((row - 1) * 3) - 1] == "|-|") {
					board[col + ((row - 1) * 3) - 1] = "|O|";
					approved = true;
				} else {
					continue;
				}
			} else if (player == 1 && amount_of_players == 1 && difficulty_setting == 3) {
				//First automation check:
				row = 2;
				col = 2;
				
				if (board[col + ((row - 1) * 3) - 1] == "|-|") {
					board[col + ((row - 1) * 3) - 1] = "|O|";
					approved = true;
				} else if (board[0] == "|X|" && board[1] == "|-|") {
					board[1] = "|O|";
					approved = true;
				} else if (board[1] == "|X|" && board[2] == "|-|") {
					board[2] = "|O|";
					approved = true;
				} else if (board[2] == "|X|" && board[5] == "|-|") {
					board[5] = "|O|";
					approved = true;
				} else if (board[5] == "|X|" && board[8] == "|-|") {
					board[8] = "|O|";
					approved = true;
				} else if (board[8] == "|X|" && board[7] == "|-|") {
					board[7] = "|O|";
					approved = true;
				} else if (board[7] == "|X|" && board[6] == "|-|") {
					board[6] = "|O|";
					approved = true;
				} else if (board[6] == "|X|" && board[3] == "|-|") {
					board[3] = "|O|";
					approved = true;
				} else if (board[3] == "|X|" && board[0] == "|-|") {
					board[0] = "|O|";
					approved = true;
				} else {
					row = randomGenerator.nextInt(3) + 1;
					col = randomGenerator.nextInt(3) + 1;
					
					if (row < 1 || row > 3 || col < 1 || col > 3) {
						continue;
					}
					
					if (board[col + ((row - 1) * 3) - 1] == "|-|") {
						board[col + ((row - 1) * 3) - 1] = "|O|";
						approved = true;
					}
				}
			}
		}
	}
	
	//A check needs to be done on the board if it populated in a certain way, that would mean someone has won the game
	
	//To keep things clean, we will also void it
	public void check_game() {
		//Now here, from my knowledge, we would have to hardcode all the checks that need to be done for conditions in which some players can win or not
		//First all the possible winning conditions can be set to not bother too much with checks further and reduce the amount of code
		
		//Small adjustment is also integerated if there are two players playing the game against each other
		//And need to make a check for the deadlock if all the fields are full, but no one won
		
		if ((board[0] == "|X|" && board[1] == "|X|" && board[2] == "|X|") ||
			(board[3] == "|X|" && board[4] == "|X|" && board[5] == "|X|") ||
			(board[6] == "|X|" && board[7] == "|X|" && board[8] == "|X|") ||
			
			(board[0] == "|X|" && board[3] == "|X|" && board[6] == "|X|") ||
			(board[1] == "|X|" && board[4] == "|X|" && board[7] == "|X|") ||
			(board[2] == "|X|" && board[5] == "|X|" && board[8] == "|X|") ||
			
			(board[0] == "|X|" && board[4] == "|X|" && board[8] == "|X|") ||
			(board[2] == "|X|" && board[4] == "|X|" && board[6] == "|X|")){
			
			winner_status = true;
			winner_player = "Player 1";
		} else if 
			((board[0] == "|O|" && board[1] == "|O|" && board[2] == "|O|") ||
			 (board[3] == "|O|" && board[4] == "|O|" && board[5] == "|O|") ||
			 (board[6] == "|O|" && board[7] == "|O|" && board[8] == "|O|") ||
					
			 (board[0] == "|O|" && board[3] == "|O|" && board[6] == "|O|") ||
			 (board[1] == "|O|" && board[4] == "|O|" && board[7] == "|O|") ||
			 (board[2] == "|O|" && board[5] == "|O|" && board[8] == "|O|") ||
					
			 (board[0] == "|O|" && board[4] == "|O|" && board[8] == "|O|") ||
			 (board[2] == "|O|" && board[4] == "|O|" && board[6] == "|O|")) {
			
			winner_status = true;
			if (amount_of_players == 1) {
				winner_player = "Overlord AI";
			} else {
				winner_player = "Player 2";
			}
			
		} else if (board[0] != "|-|" &&
				   board[1] != "|-|" &&
				   board[2] != "|-|" &&
				   board[3] != "|-|" &&
				   board[4] != "|-|" &&
				   board[5] != "|-|" &&
				   board[6] != "|-|" &&
				   board[7] != "|-|" &&
				   board[8] != "|-|" &&
				   winner_status == false) {
			winner_status = true;
			winner_player = "Tie";
		}
	}
	
	public Boolean check_winner_status() {
		return winner_status;
	}
	
	//This will return the winning player if one exists
	public String check_winner() {
		return winner_player;
	}	
}