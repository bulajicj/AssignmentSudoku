public class Main {

    public static void main(String[] args) {
        long start=System.currentTimeMillis();

        int N = 25;

        // use forward checking & backtracking
        new Backtracking(Node.getNodes("25x25/25x25sudoku", N), N, "25x25/25x25sudokuSolution.txt");

        long end=System.currentTimeMillis();
        System.out.println("\r\ntotal running time:"+(end-start)+"ms");
    }
}