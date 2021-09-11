package com;

import java.util.ArrayList;
import java.util.List;

/**
 * PoginationHelper.java - This is a class used to determine pagination based on array of values and items per page.
 * @author  Pooja Vasudevan
 */
public class PaginationHelper<T> {

    int totalItemCount;
    int numItemsPerPage;

    /**
     * The constructor takes an array of values and a integer indicating the number of items per page
     */
    public PaginationHelper(List<T> collection, int numItemsPerPage){
        this.totalItemCount = collection.size();
        this.numItemsPerPage = numItemsPerPage;
    }

    /**
     * returns the total number of items in the collection/array
     */
    public int itemCount(){
        return totalItemCount;
    }

    /**
     * returns the total number of pages based on constructor inputs
     */
    public int pageCount(){
        int numPages = totalItemCount/numItemsPerPage;
        if(totalItemCount%numItemsPerPage!=0){
            return numPages+1;
        } else{
            return numPages;
        }
    }

    /**
     * returns the number of items on a page given the page index of interest
     */
    public int pageItemCount(int pageIdx){
        int pageCount = this.pageCount();

        if(pageIdx < 0 || pageIdx >= pageCount){
            return -1;
        }

        if(pageIdx == pageCount -1){
            return totalItemCount%numItemsPerPage;
        } else {
            return numItemsPerPage;
        }
    }

    /**
     * returns the page index for an item index
     */
    public int pageIndex(int itemIdx){

        if(itemIdx < 0 || itemIdx >=totalItemCount){
            return -1;
        }
        return itemIdx/numItemsPerPage;

    }

    public static void main(String[] args) {
	// write your code here
        ArrayList<Character> arr = new ArrayList<>();
        arr.add('a');arr.add('b');arr.add('c');arr.add('d');arr.add('e');arr.add('f');arr.add('b');
      //  char[] arr = {'a','b','c','d','e','f','b'};
        PaginationHelper helper = new PaginationHelper(arr, 2);
        /** Unit tests **/

        /**Tests to verify total item count**/
        System.out.println("Total Item Count: ");
        System.out.println(helper.itemCount());

        /**Tests to verify pageCount**/
        System.out.println("Page count: ");
        System.out.println(helper.pageCount());

        /**Tests to verify pageItemCount**/
        System.out.println("Tests to verify pageItemCount: ");
        System.out.println(helper.pageItemCount(0)); //boundary conditions - lower limit
        System.out.println(helper.pageItemCount(3)); // boundary conditions - upper limit
        System.out.println(helper.pageItemCount(helper.pageCount())); // invalid page index
        System.out.println(helper.pageItemCount(-1));

        /**Tests to verify pageIndex**/
        System.out.println("Tests to verify pageIndex: ");
        System.out.println(helper.pageIndex(0)); //boundary conditions - lower limit
        System.out.println(helper.pageIndex(6)); //boundary conditions - upper limit
        System.out.println(helper.pageIndex(3)); //boundary conditions - midway
        System.out.println(helper.pageIndex(helper.itemCount())); //invalid index
        System.out.println(helper.pageIndex(-1));

    }
}
