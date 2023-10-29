import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentSkipListSet;

class Node {
    int row;
    int col;
    int box;
    ConcurrentSkipListSet<Integer> domain;
    int N;

    Node(int row, int col, int N){
        this.row = row;
        this.col = col;
        this.N = N;
        box = calculateBox(row,col,N);
        domain = new ConcurrentSkipListSet<>();
        for(int i = 1; i <= N; i++){
            domain.add(i);
        }
    }

    Node(int row, int col,int N, int value) {
        this.row = row;
        this.col = col;
        box = calculateBox(row, col,N);
        domain = new ConcurrentSkipListSet<>();
        domain.add(value);
    }

    static Node[][] getNodes(String filename, int N) {

        Node[][] nodes = new Node[N][N];
        try {
            String dir = System.getProperty("user.dir") + File.separator + "src" + File.separator + "inputs";
            BufferedReader in = new BufferedReader(new FileReader(dir + File.separator + filename));
            String line;
            for (int i = 0; i < N; i++) {
                if ((line = in.readLine()) != null) {
                    String[] numbers = line.trim().split(" ");
                    for (int j = 0; j < N; j++) {
                        int number = Integer.parseInt(numbers[j]);
                        if (number >= 1 && number <= N) {
                            nodes[i][j] = new Node(i, j,N, number);
                        } else {
                            nodes[i][j] = new Node(i, j, N);
                        }
                    }
                } else {
                    for (int j = 0; j < N; j++) {
                        nodes[i][j] = new Node(i, j, N);
                    }
                }
            }
            //printPuzzle(filename, nodes, N);
            return nodes;
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    /*static void printNodes(Node[][] nodes, int N) {
        System.out.print("\r\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(nodes[i][j].printDomain());
            }
            System.out.print("\r\n");
        }
    }*/

    // error, return -1
    // not end, return 1
    // find solution , return 0
    static int currentState(Node[][] nodes, int N) {
        boolean notEnd = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (nodes[i][j].domain.size() == 0) {
                    return -1;
                } else if (nodes[i][j].domain.size() > 1) {
                    notEnd = true;
                }
            }
        }
        if (notEnd) {
            return 1;
        }

        // Iterating through all rows & columns in order to check those
        HashSet<Integer> rowSet;
        HashSet<Integer> colSet;
        for (int i = 0; i < N; i++) {
            rowSet = new HashSet<>();
            colSet = new HashSet<>();
            for (int j = 0; j < N; j++) {
                rowSet.add(nodes[i][j].domain.first());
                colSet.add(nodes[j][i].domain.first());
            }
            if (rowSet.size() != N || colSet.size() != N) {
                return -1;
            }
        }

        // check all boxes
        HashMap<Integer, Integer> boxesMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int box = nodes[i][j].box;
                int sum = 0;
                if (boxesMap.get(box) != null) {
                    sum = boxesMap.get(box);
                }
                sum += nodes[i][j].domain.first();
                boxesMap.put(box, sum);
            }
        }
        for (HashMap.Entry<Integer, Integer> entry : boxesMap.entrySet()) {
            int expectedSum = N * (N + 1) / 2; // Calculate the expected sum for the board size N
            if (entry.getValue() != expectedSum) {
                return -1;
            }
        }

        return 0;
    }

    private int calculateBox(int row, int col, int N) {
        int sqrtN = (int) Math.sqrt(N);
        int boxRow = row / sqrtN;
        int boxCol = col / sqrtN;
        int box = boxRow * sqrtN + boxCol;
        return box;
    }

    @Override
    public boolean equals(Object other) {
        // comparing two Node objects by row, column and value
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (getClass() != other.getClass()) {
            return false;
        }
        Node otherNode = (Node) other;
        if (otherNode.row == this.row && otherNode.col == this.col && otherNode.box == this.box) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "(" + this.row + "," + this.col + ")";
    }

    /*String printDomain() {
        String str = "[";
        for (Integer i : domain) {
            str = str + i + "";
        }
        str += "]";
        return str;
    }*/
}