package dailymixes;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
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
public class Song
{

    private String name;
    private String suggestedPlaylist;
    private GenreSet genreSet;

    // ----------------------------------------------------------
    /**
     * Create a new Song object.
     * 
     * @param name
     *            of the song
     * @param pop
     *            genre of song
     * @param rock
     *            genre of song
     * @param country
     *            genre of song
     * @param suggested
     *            song
     */
    public Song(String name, int pop, int rock, int country, String suggested)
    {
        this.name = name;
        this.genreSet = new GenreSet(pop, rock, country);
        this.suggestedPlaylist = suggested;
    }


    /**
     * creates an output in string using string builder
     * 
     * @return the concatenate name
     */
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();

        if (suggestedPlaylist.isEmpty())
        {
            stringBuilder.append("No-Playlist ");
        }
        stringBuilder.append(name + " ");
        stringBuilder.append(genreSet.toString());

        if (!suggestedPlaylist.isEmpty())
        {
            stringBuilder.append(" Suggested: ").append(suggestedPlaylist);

        }

        return stringBuilder.toString();
    }


    /**
     * getter method for the suggested playlist
     * 
     * @return the suggested playlist
     */
    public String getPlaylistName()
    {
        return suggestedPlaylist;

    }


    /**
     * Two Song objects are equal when their name, genreset, and suggested
     * @return playlist values
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }

        Song song = (Song)obj;

        return name.equals(song.name) && genreSet.equals(song.genreSet)
            && suggestedPlaylist.equals(song.suggestedPlaylist);
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


    // ----------------------------------------------------------
    /**
     * getter method for genre set
     * 
     * @return the genre set
     */
    public GenreSet getGenreSet()
    {
        return genreSet;
    }

}
