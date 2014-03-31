/****************************************************************************
 *  Name: Dmitryi Halyava
 *  Login: dzmitryi.halyava@gmail.com
 *  Date: 02/16/2014
 *  Compilation:  javac Percolation.java
 *  Dependencies: WeightedQuickUnionUF.java
 *
 *  Percolation model.
 *
 ****************************************************************************/

/**
 *  The <tt>Percolation</tt> class represents a percolation data structure.
 *  It supports the <em>open</em> operation, along with methods for
 *  determinig whether site opened or full and does system percolates.
 *  <p>
 *  Initializing a data structure with <em>N * N</em> objects takes linear time.
 *  Afterwards, <em>isOpen</em> takes constant time but <em>open</em>, 
 *  <em>isFull</em> and <em>percolates</em> takes linear time.
 *  <p>
 *
 *  @author Dmitryi Halyava
 */
public class Percolation {
    private boolean[][] sites;
    private int gridSize;
    private WeightedQuickUnionUF uf;
    private int bottom;
    
    /**
     * Initializes a percolation data structure with N * N blocked sites.
     * @throws java.lang.IllegalArgumentException if N < 1
     * @param N the size of the grid
     */
    public Percolation(int N)
    {
        if (N < 1) { throw new java.lang.IllegalArgumentException(); }

        gridSize = N;
        sites = new boolean[N][N];
        uf = new WeightedQuickUnionUF(N * N + 2);
        bottom = N * N + 1;
    }
    
    /* Open site if it is not already opened.
     * @param i index of the row
     * @param j index of the column
     */
    public void open(int i, int j)
    {
        checkIndices(i, j);
        sites[i-1][j-1] = true;
        if (i == 1)
        {
            uf.union(0, xyToID(i, j));
        }
        if (isValidPosition(i - 1, j) && isOpen(i - 1, j))
        {
            uf.union(xyToID(i, j), xyToID(i - 1, j));
        }
        if (isValidPosition(i + 1, j) && isOpen(i + 1, j))
        {
            uf.union(xyToID(i, j), xyToID(i + 1, j));
        }
        if (isValidPosition(i, j - 1) && isOpen(i, j - 1))
        {
            uf.union(xyToID(i, j), xyToID(i, j - 1));
        }
        if (isValidPosition(i, j + 1) && isOpen(i, j + 1))
        {
            uf.union(xyToID(i, j), xyToID(i, j + 1));
        }
    }
    
    /* Is site open?
     * @param i index of the row
     * @param j index of the column
     */
    public boolean isOpen(int i, int j)
    {
        checkIndices(i, j);
        return sites[i-1][j-1];
    }

    /* Is site full?
     * @param i index of the row
     * @param j index of the column
     */
    public boolean isFull(int i, int j)
    {
        checkIndices(i, j);
        return uf.connected(0, xyToID(i, j));
    }

    /* Does the system percolate?
     */
    public boolean percolates()
    {
        return uf.connected(0, bottom);
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
    
    private boolean isValidPosition(int row, int col)
    {
        return (row > 0 && row <= gridSize) && (col > 0 && col <= gridSize);
    }
}