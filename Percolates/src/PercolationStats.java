
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
    private double[] openedSites;
    private int gridSize;
    private int expNumber;

    /*
     * Perform T independent computational experiments on an N-by-N grid
     */
    public PercolationStats(int N, int T)
    {
        openedSites = new double[N];
        gridSize = N;
        expNumber = T;
        
        for (int i = 0; i < T; i++)
        {
            boolean isPercolate = false;
            Percolation p = new Percolation(N);
            Random rowGen = new Random();
            Random colGen = new Random();
            while (!isPercolate)
            {
                
            }
        }
    }

    /*
     * Sample mean of percolation threshold.
     */
    public double mean()
    {
        double total = 0.0;
        for (int i = 0; i < expNumber; i++) total += openedSites[i];
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
            double mean = mean();
        }
        return total;
    }
    
    /*
     * Returns lower bound of the 95% confidence interval
     */
    public double confidenceLo()
    {
        return Double.NaN;
    }
    
    /*
     * Returns upper bound of the 95% confidence interval
     */
    public double confidenceHi()
    {
        return Double.NaN;
    }
    
    /*
     * Test client, described below.
     */
    public static void main(String[] args)
    {
    }
}