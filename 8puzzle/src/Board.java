import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dmitry.halyava
 */
public class Board {
    
    Board[] boards = new Board[10];
    public Board(int[][] blocks)           // construct a board from an N-by-N array of blocks
    {}
                                           // (where blocks[i][j] = block in row i, column j)
    public int dimension()                 // board dimension N
    {
        return Integer.MIN_VALUE;
    }
    
    public int hamming()                   // number of blocks out of place
    {
        return Integer.MIN_VALUE;
    }
    
    public int manhattan()                 // sum of Manhattan distances between blocks and goal
    {
        return Integer.MIN_VALUE;
    }
    
    public boolean isGoal()                // is this board the goal board?
    {
        return false;
    }
    
    public Board twin()                    // a board obtained by exchanging two adjacent blocks in the same row
    {
        return null;
    }
    
    public boolean equals(Object y)        // does this board equal y?
    {
        return false;
    }
    
    public Iterable<Board> neighbors()     // all neighboring boards
    {
        return 
    }
    
    public String toString()               // string representation of the board (in the output format specified below)
    {
        return null;
    }
    
    /*
     * Return an independent iterator over items
     */
    public Iterator<Board> iterator()
    {
        return new BoardIterator();
    }


    private class BoardIterator implements Iterator<Board>
    {
        private int position = 0;
        
        public boolean hasNext() {
            return position < boards.length;
        }

        public Board next() {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }

            Board item = boards[position];
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}