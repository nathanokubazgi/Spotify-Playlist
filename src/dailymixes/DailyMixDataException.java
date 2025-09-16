package dailymixes;

import java.lang.Exception;

// -------------------------------------------------------------------------
/**
 * This class uses a single constructor that takes a String and passes it to
 * super(message)
 * 
 * @author nathanokubazgi
 * @version Apr 14, 2025
 */
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Nathan Okubazgi (906705115)
public class DailyMixDataException
    extends Exception

{

    // ----------------------------------------------------------
    /**
     * Create a new DailyMixDataException object.
     * 
     * @param string
     *            is passed into super
     */
    public DailyMixDataException(String string)
    {
        super(string);
    }

    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

}
