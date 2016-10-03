package p1;

public class Artist{
    private int artistID;
    private String aName;

    Artist(int aID, String name){
        artistID = aID;
        aName = name;

    }

    public int getArtistID() {
        return artistID;
    }

    public String getaName() {
        return aName;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistID=" + artistID +
                ", aName='" + aName + '\'' +
                '}';
    }
}
