package dailymixes;

import java.util.Arrays;
import list.AList;


public class PlaylistCalculator
{

    private Playlist[] playlists;
    /**
     * the number of playlist equals 3
     */
    public static final int NUM_PLAYLISTS = 3;
    /**
     * min percent equal 0
     */
    public static final int MIN_PERCENT = 0;
    private AList<Song> rejectedTracks;
    private ArrayQueue<Song> songQueue;
    /**
     * max percent equals 100
     */
    public static final int MAX_PERCENT = 100;

    // ----------------------------------------------------------
    /**
     * Create a new PlaylistCalculator object.
     * 
     * @param songQueue
     *            the songs that are going to be put in the playlist
     * @param playlists
     *            array of available playlsits
     */
    public PlaylistCalculator(ArrayQueue<Song> songQueue, Playlist[] playlists)
    {

        this.songQueue = songQueue;
        this.playlists = playlists;
        rejectedTracks = new AList<>();
        if (songQueue == null)
        {
            throw new IllegalArgumentException();
        }
    }


    // ----------------------------------------------------------
    /**
     * the next song in line should be put on the list of rejected tracks
     */
    public void reject()
    {
        if (!songQueue.isEmpty())
        {
            rejectedTracks.add(songQueue.dequeue());
        }
    }


    /**
     * A private helper method that determines the playlist with the most
     * capacity that a song can be added to while still meeting eligibility
     * requirements.
     *
     * @param aSong
     *            the song to evaluate
     * @return the most suitable playlist, or null if none are acceptable
     */
    private Playlist getPlaylistWithMaximumCapacity(Song aSong)
    {
        Playlist[] sortedPlaylists = Arrays.copyOf(playlists, playlists.length);

        Arrays.sort(sortedPlaylists);

        for (int i = sortedPlaylists.length - 1; i >= 0; i--)
        {
            Playlist current = sortedPlaylists[i];

            if (!current.isFull() && current.isQualified(aSong))
            {
                return current;
            }
        }

        return null;
    }


    // ----------------------------------------------------------
    /**
     * This method will attempt to add the next song
     * 
     * @return false if playlist is empty otherwise add the suggested song to
     *             the right playlist
     */
    public boolean addSongToPlaylist()
    {
        if (!songQueue.isEmpty())
        {

            Playlist playlist = getPlaylistForSong(songQueue.getFront());
            
            

            if (playlist != null)
            {
                playlist.addSong(songQueue.dequeue());
                return true;
            }
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * This method will check to see if the next song can be added to a
     * playlist.
     * 
     * @param nextSong
     *            to check for
     * @return to find the Playlist with the most capacity that can accept the
     *             song
     */
    public Playlist getPlaylistForSong(Song nextSong)
    {
        if (nextSong == null)
        {
            return null;
        }

        String suggestedPlaylist = nextSong.getPlaylistName();
        int index = getPlaylistIndex(suggestedPlaylist);

        if (index >= 0 && index < playlists.length)
        {
            Playlist suggested = playlists[index];
            if (!suggested.isFull() && canAccept(suggested, nextSong))
            {
                return suggested;
            }
        }

        return getPlaylistWithMaximumCapacity(nextSong);
    }


    // ----------------------------------------------------------
    /**
     * This method would return the ArrayQueue of songs.
     * 
     * @return the ArrayQueue of songs
     */
    public ArrayQueue<Song> getQueue()

    {
        return songQueue;

    }


    /**
     * Checks too see if a song can be added into a playlist.
     *
     * @param checking
     *            this object
     * @param song
     *            checking this object
     * @return true if the song is correct
     */
    private boolean canAccept(Playlist playlist, Song song)
    {
        return !playlist.isFull() && playlist.isQualified(song);
    }


    // ----------------------------------------------------------
    /**
     * getter method to see the playlist index
     * 
     * @param playlist
     *            checking the objects index
     * @return minus 1 if If the given String is not a name from the 3 playlist
     */
    public int getPlaylistIndex(String playlist)
    {
        for (int i = 0; i < NUM_PLAYLISTS; i++)
        {
            if (playlists[i].getName().equalsIgnoreCase(playlist))
            {
                return i;
            }
        }
        return -1;
    }


    // ----------------------------------------------------------
    /**
     * getter method of playlist
     * 
     * @return the ArrayQueue of songs
     */
    public Playlist[] getPlaylists()
    {
        return playlists;

    }


    // ----------------------------------------------------------
    /**
     * getter method to return the rejected tracks
     * 
     * @return the AList of rejected tracks
     */
    public AList<Song> getRejectedTracks()
    {
        return rejectedTracks;

    }

}
