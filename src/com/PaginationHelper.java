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
     * The constructor takes a collection of values and a integer indicating the number of items per page
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
        if(numItemsPerPage > 0) {

            int numPages = totalItemCount / numItemsPerPage;
            if (totalItemCount % numItemsPerPage != 0) {
                return  numPages + 1;
            } else {
                return numPages;
            }
        }
        return 0;
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

        if(itemIdx < 0 || itemIdx >=totalItemCount || this.pageCount()==0){
            return -1;
        }
        return itemIdx/numItemsPerPage;

    }

}
