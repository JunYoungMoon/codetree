import java.util.*;

class Cell {
    private final int x, y, value;

    public Cell(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Cell(%d, %d, %d)", x, y, value);
    }
}

class Grid {
    private final int[][] matrix;
    private final int size;
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    public Grid(int[][] matrix) {
        this.size = matrix.length;
        this.matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            System.arraycopy(matrix[i], 0, this.matrix[i], 0, size);
        }
    }

    public int getSize() {
        return size;
    }

    public int getValue(int x, int y) {
        if (!isValidPosition(x, y)) {
            throw new IndexOutOfBoundsException("Invalid position (" + x + ", " + y + ")");
        }
        return matrix[x][y];
    }

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && y >= 0 && x < size && y < size;
    }

    public List<Cell> getAllCells() {
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells.add(new Cell(i, j, matrix[i][j]));
            }
        }
        return cells;
    }

    public List<Cell> getNeighbors(int x, int y) {
        List<Cell> neighbors = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];
            if (isValidPosition(nx, ny)) {
                neighbors.add(new Cell(nx, ny, matrix[nx][ny]));
            }
        }
        return neighbors;
    }
}

class DynamicProgrammingTable {
    private final int[][] dp;
    private final int size;

    public DynamicProgrammingTable(int size) {
        this.size = size;
        this.dp = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                dp[i][j] = 1;
            }
        }
    }

    public int getValue(int x, int y) {
        return dp[x][y];
    }

    public void setValue(int x, int y, int value) {
        dp[x][y] = value;
    }

    public int getMaxValue() {
        int max = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}

class LongestIncreasingPathFinder {
    private final Grid grid;
    private final DynamicProgrammingTable dpTable;

    public LongestIncreasingPathFinder(Grid grid) {
        this.grid = grid;
        this.dpTable = new DynamicProgrammingTable(grid.getSize());
    }

    public int findLongestPath() {
        List<Cell> cells = grid.getAllCells();

        cells.sort(Comparator.comparing(Cell::getValue));

        for (Cell cell : cells) {
            updateDPForCell(cell);
        }

        return dpTable.getMaxValue();
    }

    private void updateDPForCell(Cell cell) {
        int x = cell.getX();
        int y = cell.getY();
        int currentValue = cell.getValue();

        List<Cell> neighbors = grid.getNeighbors(x, y);

        for (Cell neighbor : neighbors) {
            int nx = neighbor.getX();
            int ny = neighbor.getY();

            int neighborValue = neighbor.getValue();

            if (neighborValue > currentValue) {
                int currentDP = dpTable.getValue(x, y);
                int neighborDP = dpTable.getValue(nx, ny);

                if (neighborDP <= currentDP) {
                    dpTable.setValue(nx, ny, currentDP + 1);
                }
            }
        }
    }
}

class InputProcessor {
    private final Scanner scanner;

    public InputProcessor() {
        this.scanner = new Scanner(System.in);
    }

    public Grid readGrid() {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return new Grid(matrix);
    }
}

public class Main {
    public static void main(String[] args) {
        InputProcessor inputProcessor = new InputProcessor();

        Grid grid = inputProcessor.readGrid();

        LongestIncreasingPathFinder pathFinder = new LongestIncreasingPathFinder(grid);
        int result = pathFinder.findLongestPath();

        System.out.println(result);
    }
}
