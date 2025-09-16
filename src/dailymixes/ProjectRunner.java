package dailymixes;

import java.io.FileNotFoundException;
import java.text.ParseException;

// -------------------------------------------------------------------------
/**
 * The ProjectRunner class will allow the program to begin
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
public class ProjectRunner
{
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * 
     * @param args
     *            this is the program input
     * @throws ParseException
     * @throws FileNotFoundException
     * @throws DailyMixDataException
     */
    @SuppressWarnings("unused")
    public static void main(String[] args)
        throws ParseException,
        FileNotFoundException,
        DailyMixDataException
    {
        if (args.length == 2)
        {
            new PlaylistReader(args[0], args[1]);
        }
        else
        {
            new PlaylistReader("input.txt", "playlists.txt");
        }
    }

    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

}
