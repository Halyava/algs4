/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitryi
 */
public class Percolation {
    private boolean[][] sites;
    private int gridSize;
    private WeightedQuickUnionUF uf;
    
    /*
     * Create N-by-N grid, with all sites blocked.
     * @param N size of the grid
     */
    public Percolation(int N)
    {
        gridSize = N;
        sites = new boolean[N][N];
        uf = new WeightedQuickUnionUF(N * N + 1);
    }
    
    /*
     * Open site if it is not already opened.
     * @param i index of the row
     * @param j index of the column
     */
    public void open(int i, int j)
    {
        checkIndices(j, j);
        sites[i-1][j-1] = true;
        if (i == 1)
        {
            uf.union(0, xyToID(j, j));
        }
    }
    
    /*
     * Is site open?
     * @param i index of the row
     * @param j index of the column
     */
    public boolean isOpen(int i, int j)
    {
        checkIndices(j, j);
        return sites[i-1][j-1];
    }

    /*
     * Is site full?
     * @param i index of the row
     * @param j index of the column
     */
    public boolean isFull(int i, int j)
    {
        checkIndices(j, j);
        return uf.connected(0, xyToID(j, j));
    }

    /*
     * Does the system percolate?
     */
    public boolean percolates()
    {
        for (int col = 1; col <= gridSize; col++)
        {
            if (isOpen(gridSize, col))
            {
                if (uf.connected(0, xyToID(gridSize, col)))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    private int xyToID(int row, int col)
    {
        return (row - 1) * gridSize + col;
    }
    
    private void checkIndices(int row, int col)
    {
        if (row < 1 || row > gridSize || col < 1 || col > gridSize)
            throw new java.lang.IndexOutOfBoundsException();
    }
}