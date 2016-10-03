package p1;

public class Main {

    public static void main(String[] args) {
        int sizeArray = 5;
        String[] contentsOfBag = new String[sizeArray];

        BagInterface<String> aBag = new ResizableArrayBag<>(contentsOfBag.length); //you can remove "contentsOfBag,length" to test default cunstructor of 5. it still works.

        // Filling the array to capacity 5/ filling hag with array
        fillArray(contentsOfBag);
        for (String aContentsOfBag : contentsOfBag) aBag.add(aContentsOfBag);

        System.out.println("The size of bag at the max is " +aBag.getCurrentSize() +
                            "\n" +  "which includes the elements: ");
        System.out.println();

        //printing out original size
        for (String each : contentsOfBag) {
            System.out.print(each + " ");
        }
        System.out.println();
        System.out.println();

        /*
        * This entry will exceep capacity,
        * It will increase the size of the array
        * then it will go back and add this new entry into the bag
        */
            aBag.add("B");
        aBag.add("B");aBag.add("B");aBag.add("B");aBag.add("B");aBag.add("B");aBag.add("B");aBag.add("B");aBag.add("B");


        //will print out the new bag
        System.out.println("The bag contains " + aBag.getCurrentSize() +
                " string(s), as follows:");
        Object[] bagArray = aBag.toArray();
        for (Object aBagArray : bagArray) {
            System.out.print(aBagArray + " ");
        } // end for

        System.out.println();
        System.out.println(aBag.getCurrentSize());
    } // end displayBag




    public static void fillArray(String[] array1){
        array1 [0] = "A";
        array1 [1] = "B";
        array1 [2] = "C";
        array1 [3] = "D";
        array1 [4] = "E";
    }
}
