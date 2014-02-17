
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitryi
 */
public class PercolationStats {
    private static boolean log = false;
    private double[] openedSites;
    private int gridSize;
    private int expNumber;

    /*
     * Perform T independent computational experiments on an N-by-N grid
     */
    public PercolationStats(int N, int T)
    {
        if (N <= 0 || T <= 0) throw new java.lang.IllegalArgumentException();
        
        expNumber = T;
        openedSites = new double[expNumber];
        gridSize = N;
        
        for (int i = 0; i < T; i++)
        {
            Out f = null;
            if (log)
            {
                f = new Out(N + "x" + T + "-" + i + ".txt");
                f.println(N);
            }
            
            boolean isPercolate = false;
            Percolation p = new Percolation(N);
            Random rowGen = new Random();
            Random colGen = new Random();
            while (!isPercolate)
            {
                int row = rowGen.nextInt(gridSize) + 1;
                int col = colGen.nextInt(gridSize) + 1;
                if (!p.isOpen(row, col))
                {
                    p.open(row, col);
                    openedSites[i] += 1;
                    isPercolate = p.percolates();
                    if (log) f.println(row + " " + col);
                }
            }
            openedSites[i] = openedSites[i] / (gridSize * gridSize);
        }
    }

    /*
     * Sample mean of percolation threshold.
     */
    public double mean()
    {
        double total = 0.0;
        for (int i = 0; i < expNumber; i++)
        {
            total += openedSites[i];
        }
        return total / expNumber;
    }
    
    /*
     * Sample standard deviation of percolation threshold
     */
    public double stddev()
    {
        double total = Double.NaN;
        if (expNumber > 1)
        {
            total = 0.0;
            double mean = mean();
            for (int i = 0; i < expNumber; i++)
            {
                double val = openedSites[i] - mean;
                total += val * val;
            }
            total = Math.pow(total / (expNumber - 1), 0.5);
        }
        return total;
    }
    
    /*
     * Returns lower bound of the 95% confidence interval
     */
    public double confidenceLo()
    {
        return mean() - 1.96 * stddev() / Math.pow(expNumber, 0.5);
    }
    
    /*
     * Returns upper bound of the 95% confidence interval
     */
    public double confidenceHi()
    {
        return mean() + 1.96 * stddev() / Math.pow(expNumber, 0.5);
    }
    
    /*
     * Test client, described below.
     */
    public static void main(String[] args)
    {
        int N = 0;
        int T = 0;
        if (args.length >= 2)
        {
            N = Integer.parseInt(args[0]);
            T = Integer.parseInt(args[1]);
            log = args.length == 3;
        }
        
        PercolationStats ps = new PercolationStats(N, T);
        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println("95% confidence interval = " + ps.confidenceLo() + ", " + ps.confidenceHi());
    }
}