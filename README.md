# Pagination Helper

<h2>Overview</h2>
<p>This project creates a Pagination Helper class, which can be used to design pagination UI components and consists of units tests. This class can be found under
the src/com folder. The class has a constructor, which takes a collection of values and number of items per page, and consists of the following methods: </p>

- itemCount : returns total number of items defined in the collection
- pageCount: returns total number of pages based on items per page
- pageItemCount: returns total number of items on a given page index
- pageIndex: returns page index given an item idex.

<h2> Unit Tests </h2>
<p> The unit tests for each method are defined and can be run under PaginationHelperTest.java under src/com. The unit tests verify the following conditions and its boundary cases: </p>

- Total Items in collection exceeds Number Items per Page
- Total Items in collection less than Number Items per Page
- Number Items per Page = 0 or Empty Collection
- Even Distribution of Items across all Pages

<p> These conditions and its boundary cases are verified in the following methods:</p>

- testItemCount: verifies total item count is as expected for all cases
- testPageCount: verifies total page count is as expected for all cases
- testPageItemCountIfItemsPerPageLess: verifies page item count for given page index when items per page is less than total item count
- testPageIndexIfItemsPerPageLess: verifies page index for an item index when items per page is less than total item count
- testPageItemCountIfItemsPerPageGreater: verifies page item count for given page index when items per page is greater than total item count
- testPageIndexIfItemsPerPageGreater: verifies page index for an item index when items per page is greater than total item count
- testPageCountWhenZero: verifies pagecount is 0 when Number Items per Page = 0 or Empty Collection
- testPageItemCountWhenPageCountIsZero: verifies page item count is -1 when Number Items per Page = 0 or Empty Collection
- testPageIndexWhenPageCountIsZero: verifies page index is -1 when Number Items per Page = 0 or Empty Collection
- testEvenDistributionPageItemCount: verifies page item count when all pages have the same number of items given a page index
- testEvenDistributionPageIndex: verifies page index given an item idex when all pages have same number of items.


Any invalid page or item index will return -1. 
