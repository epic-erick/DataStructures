package p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main { // rename all ITEM to the new artist....
    public static void main(String[] args) throws FileNotFoundException{
        final String artsFile = "p1arts_out.txt";
        final String artistsFile = "p1artists_out1.txt";
        final int aLISTSIZE = 61;
        final int ARTLISTSIZE = 116;
        int totalValue = 0;
        int totalArtwork = 0;

        //creates the list of Artist with there ID and uses method to fill them in
        Artist [] aList = new Artist[aLISTSIZE];
        fillArtist(aList);

        //creates the list of arts with there id to fill them in
        Arts [] artList = new Arts[ARTLISTSIZE]; //should be 115
        fillArt(artList);

        //loop to add the artist name to arts object
        Arts [] newList = new Arts[ARTLISTSIZE];
        newList = createNewArts(aList, artList, newList);

        //Write out the Artist to file.
        WriteOut artist = new WriteOut(artistsFile);
        artist.openFile();
        for(int i = 0; i<aList.length-1; i++){
            artist.artistAddToRecords(aList[i]);
        }
        artist.closeFile();

        //Writes out the art list with names of artists
        WriteOut g = new WriteOut(artsFile);
        g.openFile();
        for (Arts each:newList) {
            totalValue += each.getAppraisedValue();
            totalArtwork++;
            g.ArtsaddRecords(each);
        }
        g.writeOutTotalValue(totalValue, totalArtwork);
        g.closeFile();
    }

    public static Arts[] createNewArts (Artist [] aList, Arts [] artList, Arts [] newList){
        for (int i = 0; i<artList.length; i++){
            for (int j = 0; j<aList.length-1; j++){
                if (artList[i].getaID() == aList[j].getArtistID()) {
                    newList[i] = new Arts(artList[i].getArtID(), artList[i].getTitle(), artList[i].getaID(), aList[j].getaName(), artList[i].getAppraisedValue());
                    break; // breaks to save processing time
                }
                else if (j == (59)){
                    newList[i] = new Arts(artList[i].getArtID(), artList[i].getTitle(), artList[i].getaID(), "Unknown", artList[i].getAppraisedValue());
                }
            }
        }
        return newList;
    }

    //methods of the main
    public static Artist[] fillArtist(Artist[] list) throws FileNotFoundException{
        int counter = 0;
        try {
            Scanner input = new Scanner(new File("p1artists.txt"));

            while (input.hasNext()) {
                int tempID = input.nextInt();
                String tempName = input.next();
                list[counter] = new Artist(tempID, tempName);
                counter++;
            }
            input.close();
        }catch(FileNotFoundException e){
            System.out.println("FILE NOT FOUND!");
        }
        return list;
    }

    public static Arts[] fillArt(Arts[] list) throws FileNotFoundException{
        int counter = 0;
        String tempTitle = "";
        try {
            Scanner input = new Scanner(new File("p1arts.txt"));
            input.useDelimiter("\t|\r\n"); //delimits where the string gets parsed from text file

            while (input.hasNext()) {
                int tempID = input.nextInt();
                tempTitle = tempTitle + input.next();
                int tempTitleID = input.nextInt();
                int tempValue = input.nextInt();
                list[counter] = new Arts(tempID, tempTitle, tempTitleID, tempValue);
                counter++;
                tempTitle = "";
            }
            input.close();
        }catch(FileNotFoundException e){
            System.out.println("FILE NOT FOUND!");
        }
        return list;
    }
}
