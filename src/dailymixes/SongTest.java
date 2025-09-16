package dailymixes;

import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 * This class test the Song class details about its purpose, what abstraction it
 * represents, and how to use it.
 * 
 * @author nathanokubazgi
 * @version Apr 8, 2025
 */

public class SongTest
    extends TestCase
{

    private Song rock;
    private Song jazz;
    private Song rap;
    private Song country;

    /**
     * 
     */
    public void setUp()
    {

        rock = new Song("rock", 20, 40, 60, "rock");
        jazz = new Song("rock", 20, 40, 60, "rock");
        rap = new Song("rap", 25, 45, 65, "rap");
        country = new Song("country", 20, 40, 60, "country");

    }


    /**
     * test to see if the string is implemented
     */
    public void testToString()
    {

        Song noPlaylist = new Song("country", 20, 40, 60, "");

        assertEquals(
            noPlaylist.toString(),
            "No-Playlist country Pop:20 Rock:40 Country:60");

        assertEquals(
            rap.toString(),
            "rap Pop:25 Rock:45 Country:65 Suggested: rap");

    }


    /**
     * test to see if the playlist name is shown
     */
    public void testGetPlaylistName()
    {
        assertEquals("rock", rock.getPlaylistName());
        assertEquals("country", country.getPlaylistName());
    }


    /**
     * test to see if different playlist equal each other
     */
    public void testEquals()
    {
        Playlist playlist =
            new Playlist("Daily Mix", 10, 20, 30, 50, 60, 70, 3);

        assertTrue(rock.equals(jazz));

        assertFalse(rock.equals(rap));
        assertFalse(rap.equals(rock));
        assertFalse(rap.equals(playlist));

        assertFalse(rock.equals(country));
        assertFalse(jazz.equals(null));

        assertFalse(rock.equals(null));

        Song genreSet = new Song("rock", 21, 40, 60, "rock");
        Song suggestedPlaylist = new Song("rock", 20, 40, 60, "metal");

        Song name = new Song("rocky", 20, 40, 60, "rock");
        assertFalse(rock.equals(name));

        assertFalse(rock.equals(genreSet));

        assertFalse(rock.equals(suggestedPlaylist));
    }


    /**
     * test the getter method name test to see if the string name is output
     */
    public void testGetName()
    {
        assertEquals("rock", rock.getName());
        assertEquals("rap", rap.getName());
    }


    /**
     * test to see if the getter method genre set
     */
    public void testGetGenreSet()
    {
        assertEquals(new GenreSet(20, 40, 60), rock.getGenreSet());
    }
}
