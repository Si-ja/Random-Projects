
public class Pieces {
	
	public Integer moves = 0;
	
	public void Move(String _from, String _to){
		//Method that will describe how to move components of the tower
		System.out.println("Move a piece from " + _from + " to " + _to);
	}
	
	public void Hanoi(int n, String _from, String _aux, String _to) {
		//Method that will recursevelly move the pieces
		/*
		 * PARAMETERS:
		 * n - number of pieces to start from
		 * _from - the starting tower
		 * _aux - the auxilary tower
		 * _to - the destination tower
		 */
		if (n == 0) {
			//If there are no more pieces to move, then just stop
			//This is the escape condition
			;
		} else {
			//If there are pieces to move, then continue moving them with a recursion
			Hanoi(n - 1, _from, _to, _aux);
			Move(_from, _to);
			moves_counter();
			Hanoi(n - 1, _aux, _from, _to);
		}
	}
	
	public void moves_counter(){
		//Count the amount of moves being made for the movement of towers
		moves += 1;
	}
	
	public void moves_cleaner() {
		//Clean the value for the amount of moves that are performed as otherwise the variable gets overclogged
		moves = 0;
	}

}
