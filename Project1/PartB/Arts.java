package p1;

public class Arts {
    private int artID;
    private String title;
    private int aID;
    private String aName;
    private int appraisedValue;

    Arts(int arID, String aTitle, int ID, int value){ // when first read in without artist name
        artID = arID;
        title = aTitle;
        aID = ID;
        appraisedValue = value;
    }

    Arts(int arID, String aTitle, int ID, String name, int value){ // final copy of list
        artID = arID;
        title = aTitle;
        aID = ID;
        aName = name;
        appraisedValue = value;
    }

    //GETTERS
    public int getArtID() {
        return artID;
    }

    public String getTitle() {
        return title;
    }

    public int getaID() {
        return aID;
    }

    public String getaName() {
        return aName;
    }

    public int getAppraisedValue() {
        return appraisedValue;
    }

    @Override
    public String toString() {
        return "Arts{" +
                "artID=" + artID +
                ", title='" + title + '\'' +
                ", aID=" + aID +
                ", aName='" + aName + '\'' +
                ", appraisedValue=" + appraisedValue +
                '}';
    }
}
