package dailymixes;

import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 * This class is a test class for playlist
 * details about its purpose, what abstraction it represents, and how to use it.
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
public class PlaylistTest
    extends TestCase
{

    private Playlist playlist;
    private Song rockSong;
    private Song countrySong;
    private Song popSong;

    /**
     * initializes the fields
     */
    public void setUp()
    {
        playlist = new Playlist("Daily Mix", 10, 20, 30, 50, 60, 70, 3);
        rockSong = new Song("rockSong", 15, 25, 35, "rock");
        countrySong = new Song("countrySong", 30, 40, 50, "country");
        popSong = new Song("popSong", 5, 10, 15, "pop");
    }


    // ----------------------------------------------------------
    /**
     * test to see if a song is added to the playlist
     */
    public void testAddSong()
    {
        assertFalse(playlist.isFull());

        assertTrue(playlist.addSong(rockSong));
        assertEquals(1, playlist.getNumberOfSongs());

        assertTrue(playlist.addSong(countrySong));
        assertEquals(2, playlist.getNumberOfSongs());

        // assertTrue(playlist.addSong(popSong));
        assertEquals(2, playlist.getNumberOfSongs());

        assertFalse(playlist.addSong(popSong));
    }


    // ----------------------------------------------------------
    /**
     * test to see if the playlist is full
     */
    public void testIsFull()
    {
        playlist.addSong(rockSong);
        playlist.addSong(countrySong);
        assertFalse(playlist.isFull());

        playlist.addSong(countrySong);

        playlist.addSong(countrySong);

        playlist.addSong(countrySong);

        assertTrue(playlist.isFull());

    }


    // ----------------------------------------------------------
    /**
     * test to see if there is any spaces in the playlist
     */
    public void testGetSpacesLeft()
    {
        assertEquals(3, playlist.getSpacesLeft());
        playlist.addSong(rockSong);
        assertEquals(2, playlist.getSpacesLeft());
    }


    // ----------------------------------------------------------
    /**
     * compairing the playlist to another playlist
     */
    public void testEquals()
    {

        assertFalse(playlist.equals(null));

        Playlist playlist2 =
            new Playlist("Daily Mix", 10, 20, 30, 50, 60, 70, 3);
        assertTrue(playlist.equals(playlist2));

        assertFalse(playlist.equals(rockSong));

        Playlist playlist3 =
            new Playlist("Another Mix", 10, 20, 30, 50, 60, 70, 3);
        assertFalse(playlist.equals(playlist3));
        assertFalse(playlist3.equals(playlist));

        Playlist diffMin = new Playlist("Daily Mix", 15, 25, 35, 50, 60, 70, 3);
        Playlist diffMax = new Playlist("Daily Mix", 10, 20, 30, 55, 65, 75, 3);
        Playlist diffCap = new Playlist("Daily Mix", 10, 20, 30, 50, 60, 70, 5);
        Playlist diffSongCount =
            new Playlist("Daily Mix", 10, 20, 30, 50, 60, 70, 3);
        Playlist diffSongs =
            new Playlist("Daily Mix", 10, 20, 30, 50, 60, 70, 3);
        Playlist identical =
            new Playlist("Daily Mix", 10, 20, 30, 50, 60, 70, 3);

        assertFalse(playlist.equals(diffMin));

        assertFalse(playlist.equals(diffMax));

        assertFalse(playlist.equals(diffCap));

        playlist.addSong(rockSong);
        diffSongCount.addSong(rockSong);
        diffSongCount.addSong(countrySong);
        assertFalse(playlist.equals(diffSongCount));

        playlist2.addSong(rockSong);
        diffSongs.addSong(rockSong);
        assertTrue(playlist2.equals(diffSongs));

        identical.addSong(rockSong);
        identical.addSong(countrySong);
        assertFalse(identical.equals(diffSongs));
        diffSongs.addSong(countrySong);

        playlist2.addSong(rockSong);
        assertTrue(diffSongs.equals(identical));

        Song altRockSong = new Song("altRock", 15, 25, 35, "rock");
        Playlist playlistNew =
            new Playlist("Daily Mix", 10, 20, 30, 50, 60, 70, 3);

        playlist = new Playlist("Daily Mix", 10, 20, 30, 50, 60, 70, 3);

        rockSong = new Song("rockSong", 15, 25, 35, "rock");

        playlist.addSong(rockSong);
        playlist.addSong(countrySong);

        playlistNew.addSong(altRockSong);
        playlistNew.addSong(countrySong);

        assertFalse(playlist.equals(playlistNew));

    }


    // ----------------------------------------------------------
    /**
     * test to see if the correct string is outputted
     */
    public void testToString()
    {
        playlist.addSong(rockSong);
        playlist.addSong(countrySong);
        String expectedString =
            "Playlist: Daily Mix, # of songs: 2 (cap: 3), Requires: "
                + "Pop:10%-50%, " + "Rock:20%-60%, Country:30%-70%";
        assertEquals(expectedString, playlist.toString());
    }


    // ----------------------------------------------------------
    /**
     * test to compare different playlist
     */

    public void testCompareTo()
    {
        Playlist higherCapacity =
            new Playlist("More Capacity", 10, 20, 30, 50, 60, 70, 5);
        assertTrue(playlist.compareTo(higherCapacity) < 0);

        Playlist sameCapacity =
            new Playlist("Same Capacity", 10, 20, 30, 50, 60, 70, 3);
        playlist.addSong(rockSong);
        sameCapacity.addSong(rockSong);
        sameCapacity.addSong(countrySong);
        assertTrue(playlist.compareTo(sameCapacity) > 0);

        Playlist minGenre =
            new Playlist("MinGenre Diff", 15, 25, 35, 50, 60, 70, 1);
        assertFalse(playlist.compareTo(minGenre) < 0);

        Playlist maxGenre =
            new Playlist("MaxGenre Diff", 10, 20, 30, 55, 60, 70, 1);
        assertFalse(playlist.compareTo(maxGenre) < 0);

        Playlist sameAttributes =
            new Playlist("Zzz Mix", 10, 20, 30, 50, 60, 70, 3);
        assertTrue(playlist.compareTo(sameAttributes) < 0);
    }


    /**
     * test to see if playlist is qulified
     */
    public void testIsQualified()
    {
        assertTrue("rockSong", playlist.isQualified(rockSong));
        assertTrue("countrySong", playlist.isQualified(countrySong));
        assertFalse("popSong", playlist.isQualified(popSong));
    }


    /**
     * Test to see if the getSongs() method returns the correct array of songs.
     */
    public void testGetSongs()
    {
        playlist.addSong(rockSong);
        playlist.addSong(countrySong);

        Song[] songs = playlist.getSongs();

        assertEquals(rockSong, songs[0]);

        assertEquals(countrySong, songs[1]);

        assertNull(songs[2]);
    }

}
