package dailymixes;

// -------------------------------------------------------------------------
/**
 * Creates what the playlist is consisted of including all string, songs, and
 * genres of the songs
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
public class Playlist
    implements Comparable<Playlist>
{

    private GenreSet minGenreSet;
    private GenreSet maxGenreSet;
    private Song[] songs;
    private int capacity;
    private int numberOfSongs;
    private String name;

    // ----------------------------------------------------------
    /**
     * @param playlistName
     *            name of the playlist
     * @param minPop
     *            minimum percent composition
     * @param minRock
     *            minimum percent composition
     * @param minCountry
     *            minimum percent composition
     * @param maxPop
     *            maximum percent composition
     * @param maxRock
     *            maximum percent composition
     * @param maxCountry
     *            maximum percent composition
     * @param playlistCap
     *            maximum capacity for the playlist
     */
    // Playlist constructor
    public Playlist(
        String playlistName,
        int minPop,
        int minRock,
        int minCountry,
        int maxPop,
        int maxRock,
        int maxCountry,
        int playlistCap)
    {
        name = playlistName;
        minGenreSet = new GenreSet(minPop, minRock, minCountry);
        maxGenreSet = new GenreSet(maxPop, maxRock, maxCountry);
        capacity = playlistCap;
        songs = new Song[playlistCap];
        numberOfSongs = 0;
    }


    // ----------------------------------------------------------
    /**
     * The minimum genre composition for the playlist
     * 
     * @return minGenreSet in the playlist
     */
    public GenreSet getMinGenreSet()
    {
        return minGenreSet;

    }


    // ----------------------------------------------------------
    /**
     * Allows users to change the name
     * 
     * @param name
     *            different name
     */
    public void setName(String name)
    {
        this.name = name;

    }


    // ----------------------------------------------------------
    /**
     * The amount of spaces remaining in the playlist
     * 
     * @return the amount of spaces left in the playlist
     */
    public int getSpacesLeft()
    {
        return capacity - numberOfSongs;
    }


    // ----------------------------------------------------------
    /**
     * The maximum genre composition for the playlist
     * 
     * @return maxGenreSet in the playlist
     */
    public GenreSet getMaxGenreSet()
    {
        return maxGenreSet;

    }


    /**
     * This method should order the playlists based on capacity
     * 
     * @param other
     *            playlist being compared
     * @return the max Genere set
     */
    public int compareTo(Playlist other)
    {
        if (getCapacity() != other.getCapacity())
        {
            return Integer.compare(getCapacity(), other.getCapacity());
        }

        if (getCapacity() != other.getSpacesLeft())
        {
            return Integer.compare(getSpacesLeft(), other.getSpacesLeft());
        }

        if (!getMinGenreSet().equals(other.getMinGenreSet()))
        {
            return getMinGenreSet().compareTo(other.getMinGenreSet());
        }

        if (!getMaxGenreSet().equals(other.getMaxGenreSet()))

        {
            return getMaxGenreSet().compareTo(other.getMaxGenreSet());

        }

        return getName().compareTo(other.getName());
    }


    // ----------------------------------------------------------
    /**
     * this method returns the number of songs in the playlsit
     * 
     * @return the nuumber of songs
     */
    public int getNumberOfSongs()
    {
        return numberOfSongs;

    }


    // ----------------------------------------------------------
    /**
     * adds a new song to the list
     * 
     * @param newSong
     *            being added to the playlist
     * @return a new song
     */
    public boolean addSong(Song newSong)
    {
        if (isFull())
        {
            return false;
        }

        if (isQualified(newSong))
        {
            songs[numberOfSongs++] = newSong;
            return true;
        }
        return false;
    }


    /**
     * This method creates a string builder concatenate the name, capacity of
     * the playlist, required genre set
     * 
     * @return the string result
     */
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Playlist: ").append(name).append(", # of songs: ")
            .append(numberOfSongs).append(" (cap: ").append(capacity)
            .append("), Requires: Pop:").append(minGenreSet.getPop())
            .append("%-").append(maxGenreSet.getPop()).append("%, ")
            .append("Rock:").append(minGenreSet.getRock()).append("%-")
            .append(maxGenreSet.getRock()).append("%, ").append("Country:")
            .append(minGenreSet.getCountry()).append("%-")
            .append(maxGenreSet.getCountry()).append("%");
        return stringBuilder.toString();
    }


    // ----------------------------------------------------------
    /**
     * This method returns true if the number of song in the playlist is full
     * 
     * @return true if full
     */
    public boolean isFull()
    {
        return numberOfSongs >= capacity;
    }


    /**
     * this method returns true if Two playlists are equal if all 8 of their
     * input fields
     * 
     * @return if playlist are equal the equals method
     */
    @Override
    public boolean equals(Object obj)
    {

        if (obj == null)
        {
            return false;
        }

        if (getClass() != obj.getClass())
        {
            return false;
        }

        Playlist playlist = (Playlist)obj;

        if (!playlist.getMinGenreSet().equals(this.minGenreSet))
        {
            return false;
        }
        if (!playlist.getMaxGenreSet().equals(this.maxGenreSet))
        {
            return false;
        }
        if (capacity != playlist.getCapacity())
        {
            return false;
        }
        if (numberOfSongs != playlist.getNumberOfSongs())
        {
            return false;
        }
        if (!name.equals(playlist.getName()))
        {
            return false;
        }

        for (int i = 0; i < numberOfSongs; i++)
        {
            if (!this.songs[i].equals(playlist.songs[i]))
            {
                return false;
            }

        }

        return true;

    }


    /**
     * getter method for songs
     * 
     * @return the songs
     */
    public Song[] getSongs()
    {
        return songs;
    }


    // ----------------------------------------------------------
    /**
     * getter method for the capacity of songs in the playlist
     * 
     * @return the number of songs
     */
    public int getCapacity()
    {
        return capacity;

    }


    // ----------------------------------------------------------
    /**
     * getter method for name
     * 
     * @return the name
     */
    public String getName()
    {
        return name;

    }


    /**
     * @param song
     *            in the playlist
     * @return the genre
     */
    public boolean isQualified(Song song)
    {
        return song.getGenreSet().isWithinRange(minGenreSet, maxGenreSet);
    }

}
