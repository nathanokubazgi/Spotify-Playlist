package dailymixes;

import junit.framework.TestCase;
import list.AList;

// -------------------------------------------------------------------------
/**
 * this class test the playlist calculator class
 */
/**
 * // Virginia Tech Honor Code Pledge: // // As a Hokie, I will conduct myself
 * with honor and integrity at all times. // I will not lie, cheat, or steal,
 * nor will I accept the actions of those who // do. // -- Nathan Okubazgi
 * (906705115) This class test the methods in the playlist calculator class
 * 
 * @author nathanokubazgi
 * @version Apr 15, 2025
 */
public class PlaylistCalculatorTest
    extends TestCase
{

    private PlaylistCalculator calculator;
    private Playlist[] playlists;
    private ArrayQueue<Song> queue;

    /**
     * this setups the test methods
     */
    public void setUp()
    {

        queue = new ArrayQueue<>(1);
        playlists = new Playlist[PlaylistCalculator.NUM_PLAYLISTS];
        playlists[0] = new Playlist("Countrymusic", 10, 20, 30, 50, 60, 70, 2);
        playlists[1] = new Playlist("rock", 1, 1, 1, 1, 1, 1, 2);
        playlists[2] = new Playlist("rock", 100, 200, 300, 400, 800, 900, 3);

        calculator = new PlaylistCalculator(queue, playlists);

    }


    // ----------------------------------------------------------
    /**
     * This method test the list of the rejected track also
     */
    public void testReject()
    {
        calculator.reject();
        assertFalse(calculator.addSongToPlaylist());
    }


    // ----------------------------------------------------------
    /**
     * test the next song in line should be put on the list of rejected tracks
     */
    public void testGetRejectedTracks()
    {

        Song songReject = new Song("rock", 1, 2, 3, "rock");
        queue.enqueue(songReject);
        calculator.reject();

        assertTrue(queue.isEmpty());

        AList<Song> rejected = calculator.getRejectedTracks();
        assertEquals(1, rejected.getLength());

    }


    // ----------------------------------------------------------
    /**
     * test the getter method for getQueue
     */
    public void testGetQueue()
    {

        assertEquals(queue, calculator.getQueue());
    }


    // ----------------------------------------------------------
    /**
     * This test to see if a song is added on to a playlist also text an empty
     * song queue
     */
    public void testAddSongToPlaylist()
    {
        assertFalse(calculator.addSongToPlaylist());
        Song song = new Song("rock", 20, 30, 40, "rock");

        assertFalse(calculator.addSongToPlaylist());
        queue.enqueue(song);

        assertEquals(song, queue.getFront());

        queue.enqueue(song);
        queue.enqueue(song);

        queue.enqueue(song);

        assertTrue(calculator.addSongToPlaylist());
        assertEquals(1, playlists[0].getNumberOfSongs());
    }


    // ----------------------------------------------------------
    /**
     * test the exception
     */
    @SuppressWarnings("unused")
    public void testException()
    {
        {
            Exception exception = null;
            try
            {

                new PlaylistCalculator(null, playlists);

            }
            catch (IllegalArgumentException e)
            {
                exception = e;
            }
            assertNotNull(exception);
        }

    }


    // ----------------------------------------------------------
    /**
     * test to see if the next song can be added to a playlist
     */
    public void testGetPlaylistForSong()
    {
        Song nextSong = null;

        assertNull(null, calculator.getPlaylistForSong(nextSong));

        Song song1 = new Song("rock", 1, 1, 1, "rock");
        Playlist result = calculator.getPlaylistForSong(song1);
        assertEquals("rock", result.getName());

        Song indexSong = new Song("IndexSong", 1, 1, 1, "rock");

        Playlist playlist = calculator.getPlaylistForSong(indexSong);

        assertEquals("rock", result.getName());
        assertFalse(playlist.isFull());
        assertTrue(playlist.isQualified(indexSong));

    }


    // ----------------------------------------------------------
    /**
     * This method test to see if playlist index is returned and it will return
     * -1 if its above 3 playlist
     */
    public void testGetPlaylistIndex()
    {
        assertEquals(0, calculator.getPlaylistIndex("Countrymusic"));
        assertEquals(-1, calculator.getPlaylistIndex("popMusic"));
        assertEquals(-1, calculator.getPlaylistIndex("music"));

        Song song2 = new Song("pop", 1, 2, 3, "pop");
        playlists[0].addSong(song2);
        playlists[0].addSong(new Song("rock", 2, 3, 4, "rock"));
        assertFalse(calculator.addSongToPlaylist());
    }

}
