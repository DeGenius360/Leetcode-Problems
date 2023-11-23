import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class ValidSudoku{
	public static void main(String[] args) {
        char[][] sudokuGrid = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        if (isValidSudoku(sudokuGrid)) {
            System.out.println("The Sudoku grid is valid.");
        } else {
            System.out.println("The Sudoku grid is not valid.");
        }
    }

	private static boolean isValidSudoku(char[][] grid){
		List<Set<Character>> rows = new ArrayList<>();
		List<Set<Character>> columns = new ArrayList<>();
		List<Set<Character>> boxes = new ArrayList<>();

		for (int i = 0; i < 9; i++){
			rows.add(new HashSet<>());
			columns.add(new HashSet<>());
			boxes.add(new HashSet<>());
		}

		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++){
				char value = grid[i][j];

				if (value != '.' && (
					!rows.get(i).add(value) ||
					!columns.get(j).add(value) ||
					!boxes.get((i / 3) * 3 + j / 3).add(value))){
					return false;
				}
				
			}
		}
		return true;
	}
    /* 
	private static boolean isValid(String value, Set<String> set){
		if (value.equals(".")){
			return true;
		}
		if (set.contains(value) || !isValidInteger(value)){
            return false;
        }
        set.add(value);
        return true;
	}
    
	private static boolean isValidInteger(String value) {
	    try {
	        int intValue = Integer.parseInt(value);
	        return intValue >= 1 && intValue <= 9;
	    } catch (NumberFormatException e) {
	        return false; // If parsing fails (not an integer), consider it invalid
	    }
	} */
    
}