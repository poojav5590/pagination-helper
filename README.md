# Pagination Helper

<h2>Overview</h2>
<p>This project creates a Pagination Helper class, which can be used to design pagination UI components and consists of units tests. This class can be found under
the src/com folder. The class has a constructor, which takes an array of values and number of items per page, and consists of the following methods: </p>

- itemCount : returns total number of items defined in array
- pageCount: returns total number of pages based on items per page
- pageItemCount: returns total number of items on a given page index
- pageIndex: returns page index given an item idex.

<h2> Unit Tests </h2>
The unit tests for each method are defined and can be run under the main method. The unit tests verify the following conditions and its boundary cases:
- Total Items in Array exceeds Number Items per Page
- Total Items in Array less than Number Items per Page
- Number Items per Page = 0

Any invalid page or item index will return -1. 
