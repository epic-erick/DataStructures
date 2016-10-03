package p1;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class WriteOut {
    private String FileName;
    private Formatter x;

    WriteOut(String Filename){
        FileName = Filename;
    }


    public String getFileName() {
        return FileName;
    }

    public void openFile (){
        try{
            x = new Formatter(getFileName());
        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }
    public void ArtsaddRecords(Arts list){
        x.format("%d %-30s %-20s %-20d %-20d %n", list.getArtID(), list.getTitle(), list.getaName(), list.getaID(), list.getAppraisedValue());
                //digit, string with padding 30, string with padding 20, digit with padding 20, digit with padding 20, %n = new line
    }

    public void artistAddToRecords (Artist list){
        x.format("%d %-30s %n",list.getArtistID(), list.getaName());
    }

    public void writeOutTotalValue(int value, int artcount){
        x.format("%nTotal Number of Artists: 60");
        x.format("%nTotal Number of Artwork: %d", artcount);
        x.format("%nThe Total Appraised Value of the Art is: $%d.00", value);
    }

    public void closeFile(){
        x.close();
    }
}
