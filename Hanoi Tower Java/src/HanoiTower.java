public class HanoiTower {

	public static void main(String[] args) {
		Pieces tower = new Pieces();
		
		System.out.println("The Towers Are Being Moved!\n===========================");
		tower.Hanoi(2, "A", "B", "C");
		System.out.println("");
		System.out.println("It took: [" + tower.moves + "] moves!");
		tower.moves_cleaner();
		System.out.println("===========================\nThe Towers Have Been Moved!\n");
		
		System.out.println("The Towers Are Being Moved!\n===========================");
		tower.Hanoi(3, "A", "B", "C");
		System.out.println("");
		System.out.println("It took: [" + tower.moves + "] moves!");
		tower.moves_cleaner();
		System.out.println("===========================\nThe Towers Have Been Moved!\n");
		
		System.out.println("The Towers Are Being Moved!\n===========================");
		tower.Hanoi(4, "A", "B", "C");
		System.out.println("");
		System.out.println("It took: [" + tower.moves + "] moves!");
		tower.moves_cleaner();
		System.out.println("===========================\nThe Towers Have Been Moved!\n");
		
		
	}

}
