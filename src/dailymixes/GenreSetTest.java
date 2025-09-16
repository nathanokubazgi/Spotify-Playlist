package dailymixes;

import junit.framework.TestCase;

/**
 * This test class test the methods in the GenreSet class *
 * 
 * @author nathanokubazgi
 * @version Apr 5, 2025
 */
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Nathan Okubazgi (906705115)
public class GenreSetTest
    extends TestCase
{

    private GenreSet genreSet;
    private GenreSet sameSet;
    private GenreSet sameSet2;
    private GenreSet empty;

    /**
     * setup
     */
    public void setUp()
    {
        genreSet = new GenreSet(1, 2, 3);
        sameSet = new GenreSet(100, 200, 300);
        sameSet2 = new GenreSet(100, 200, 300);
        empty = new GenreSet(0, 0, 0);
    }


    // ----------------------------------------------------------
    /**
     * this method test the getter methods for rock, pop, and country
     */
    public void testGetRockPopCountry()
    {
        assertEquals(200, sameSet.getRock());
        assertEquals(2, genreSet.getRock());

        assertEquals(100, sameSet.getPop());
        assertEquals(1, genreSet.getPop());

        assertEquals(300, sameSet.getCountry());
        assertEquals(3, genreSet.getCountry());
    }


    // ----------------------------------------------------------
    /**
     * test to see if both playlsit are the same and different
     */
    public void testEquals()
    {

        assertFalse(sameSet.equals(null));

        Playlist playlist =
            new Playlist("Daily Mix", 10, 20, 30, 50, 60, 70, 3);
        // all same
        assertTrue(sameSet.equals(sameSet2));
        // allnot same
        assertFalse(sameSet.equals(genreSet));
        // other class
        assertFalse(sameSet.equals(playlist));
        GenreSet set = new GenreSet(1, 1, 300);
        GenreSet set1 = new GenreSet(100, 1, 1);
        GenreSet set2 = new GenreSet(1, 200, 1);

        assertFalse(sameSet.equals(genreSet));
        assertTrue(genreSet.equals(genreSet));
        assertFalse(sameSet.equals(set));

        assertFalse(sameSet.equals(set1));

        assertFalse(sameSet.equals(set2));

        assertTrue(genreSet.equals(genreSet));

        GenreSet popDiff = new GenreSet(
            sameSet.getPop() + 1,
            sameSet.getRock(),
            sameSet.getCountry());
        assertFalse(sameSet.equals(popDiff));

        GenreSet rockDiff = new GenreSet(
            sameSet.getPop(),
            sameSet.getRock() + 1,
            sameSet.getCountry());
        assertFalse(sameSet.equals(rockDiff));

        GenreSet countryDiff = new GenreSet(
            sameSet.getPop(),
            sameSet.getRock(),
            sameSet.getCountry() + 1);
        assertFalse(sameSet.equals(countryDiff));

    }


    // ----------------------------------------------------------
    /**
     * test the string method to see if the output is right
     */
    public void testToString()
    {
        assertEquals("Pop:100 Rock:200 Country:300", sameSet.toString());
        assertEquals("Pop:1 Rock:2 Country:3", genreSet.toString());
        assertEquals("Pop:0 Rock:0 Country:0", empty.toString());

    }


    // ----------------------------------------------------------
    /**
     * test to see if the object is within range of the minimum genre set and
     * the maximum genre set
     */
    public void testIsWithinRange()
    {
        GenreSet min = new GenreSet(1, 1, 1);
        GenreSet max = new GenreSet(100, 200, 300);

        assertTrue(genreSet.isWithinRange(min, max));

        assertTrue(sameSet.isWithinRange(min, max));

        GenreSet minOutOfRange = new GenreSet(2, 1, 1);
        assertFalse(genreSet.isWithinRange(minOutOfRange, max));

        assertFalse(sameSet.isWithinRange(genreSet, empty));

        GenreSet set = new GenreSet(50, 0, 0);

        assertFalse(set.isWithinRange(empty, genreSet));

        GenreSet set1 = new GenreSet(0, 50, 0);

        assertFalse(set1.isWithinRange(empty, genreSet));

        GenreSet set2 = new GenreSet(0, 0, 50);

        assertFalse(set2.isWithinRange(empty, genreSet));

        assertFalse(empty.isWithinRange(genreSet, set1));

    }


    // ----------------------------------------------------------
    /**
     * test to see if the negative, positive, or zero integer are returned based
     * on whether the sum of the genre percent composition of the current object
     * are less than, greater than, or equal to the sum of the genre percent
     * composition
     */
    public void testCompareTo()
    {
        assertTrue(genreSet.compareTo(sameSet) < 0);
        assertTrue(sameSet.compareTo(genreSet) > 0);
    }
}
