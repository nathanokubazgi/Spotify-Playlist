package dailymixes;

// -------------------------------------------------------------------------
/**
 * Creates the genres of the songs in the playlist including pop, rock, and
 * country
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
public class GenreSet
{

    private int pop;
    private int rock;
    private int country;

    // ----------------------------------------------------------
    /**
     * Create a new GenreSet object.
     * 
     * @param pop
     *            type of music genre
     * @param rock
     *            type of music genre
     * @param country
     *            type of music genre
     */
    public GenreSet(int pop, int rock, int country)

    {
        this.pop = pop;
        this.rock = rock;
        this.country = country;

    }


    /**
     * getter method for rock
     * 
     * @return rock
     */
    public int getRock()
    {
        return rock;

    }


    /**
     * getter method for pop
     * 
     * @return pop
     */
    public int getPop()
    {
        return pop;

    }


    /**
     * This method is the string representation of a GenreSet
     * 
     * @return the string
     */
    public String toString()
    {
        return "Pop:" + pop + " Rock:" + rock + " Country:" + country;
    }


    /**
     * compare two objects to each other
     * 
     * @return the GenreSet objects are equal if all three fields are equal
     * @param obj
     *            is being compared
     */
    @Override
    public boolean equals(Object obj)
    {

        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        if (this == obj)
        {
            return true;
        }
        GenreSet other = (GenreSet)obj;
        return pop == other.pop && rock == other.rock
            && country == other.country;

    }


    /**
     * checks to see if a GenreSet object is within range of the minimum and
     * maximum genre set
     * 
     * @param minGenreSet
     *            minimum genre set
     * @param maxGenreSet
     *            maximum genre set
     * @return an integer
     */
    public boolean isWithinRange(GenreSet minGenreSet, GenreSet maxGenreSet)
    {
        return isLessThanOrEqualTo(maxGenreSet)
            && minGenreSet.isLessThanOrEqualTo(this);
    }


    /**
     * method for isWithinRange
     * 
     * @param genreSet
     *            to compare too
     * @return if its less then or equal too
     */
    private boolean isLessThanOrEqualTo(GenreSet genreSet)
    {
        return pop <= genreSet.pop && rock <= genreSet.rock
            && country <= genreSet.country;
    }


    /**
     * This method sees if the sum of the genre percent composition of the
     * current object are less than, greater than, or equal to the sum of the
     * genre percent composition
     * 
     * @param other
     *            GenereSet
     * @return a negative integer, positive integer, or zero
     */
    public int compareTo(GenreSet other)
    {
        int sumThis = this.pop + this.rock + this.country;
        int sumOther = other.pop + other.rock + other.country;
        return Integer.compare(sumThis, sumOther);

    }


    /**
     * getter method for country
     * 
     * @return country
     */
    public int getCountry()
    {
        return country;

    }

    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

}
