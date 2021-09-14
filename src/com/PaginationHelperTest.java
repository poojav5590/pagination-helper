package com;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaginationHelperTest {

    static PaginationHelper helper;
    static PaginationHelper helper2;

    @BeforeAll
    public static void initialize(){
        //Item Count > Items Per Page
        ArrayList<Character> itemList = new ArrayList<>();
        itemList.add('a');itemList.add('b');itemList.add('c');itemList.add('d');itemList.add('e');itemList.add('f');itemList.add('b');
        helper = new PaginationHelper(itemList, 2);

        //Item Count < Items Per Page
        ArrayList<Character> itemList2 = new ArrayList<>();
        itemList2.add('a');itemList2.add('b');
        helper2 = new PaginationHelper(itemList2, 3);
    }

    private static Stream<Arguments> itemCountParameters() {
        return Stream.of(
                Arguments.of(helper, 7),
                Arguments.of(helper2, 2)
        );
    }
    @ParameterizedTest
    @MethodSource("itemCountParameters")
    void testItemCount(PaginationHelper helper, int expectedItemCount){
        assertEquals(expectedItemCount, helper.itemCount(), "Total Item Count: ");
    }

    private static Stream<Arguments> pageCountParameters() {
        return Stream.of(
                Arguments.of(helper, 4),
                Arguments.of(helper2, 1)
        );
    }
    @ParameterizedTest
    @MethodSource("pageCountParameters")
    void testPageCount(PaginationHelper helper, int expectedPageCount){
        assertEquals(expectedPageCount, helper.pageCount(), "Total Page Count for "+helper.itemCount() +" items, "+helper.numItemsPerPage+ " items per page");
    }

    private static Stream<Arguments> pageItemCountParameters() {
        return Stream.of(
                Arguments.of(0, 2),
                Arguments.of(3, 1),
                Arguments.of(-1, -1),
                Arguments.of(4, -1)
        );
    }
    @ParameterizedTest(name = "Page index {0} returns {1}")
    @MethodSource("pageItemCountParameters")
    void testPageItemCountIfItemsPerPageLess(int pageIndex, int expectedItemCount){
        assertEquals(expectedItemCount, helper.pageItemCount(pageIndex), "Total Items on Page Index " +pageIndex+" :");
    }

    private static Stream<Arguments> pageIndexParameters() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(6, 3),
                Arguments.of(3, 1),
                Arguments.of(7, -1),
                Arguments.of(-1, -1)
        );
    }
    @ParameterizedTest(name = "Item index {0} returns page index: {1}")
    @MethodSource("pageIndexParameters")
    void testPageIndexIfItemsPerPageLess(int itemIndex, int pageIndex){
        assertEquals(pageIndex, helper.pageIndex(itemIndex), "Page Index of following item index " +itemIndex+" :");
    }



    private static Stream<Arguments> pageItemCountParametersItemsPerPageGreater() {
        return Stream.of(
                Arguments.of(0, 2),
                Arguments.of(1, -1),
                Arguments.of(-1, -1)
        );
    }
    @ParameterizedTest(name = "Page index {0} returns {1}")
    @MethodSource("pageItemCountParametersItemsPerPageGreater")
    void testPageItemCountIfItemsPerPageGreater(int pageIndex, int expectedItemCount){
        assertEquals(expectedItemCount, helper2.pageItemCount(pageIndex), "Total Items on Page Index " +pageIndex+" :");
    }

    private static Stream<Arguments> pageIndexParametersItemsPerPageGreater() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 0),
                Arguments.of(2, -1),
                Arguments.of(-1, -1)
        );
    }
    @ParameterizedTest(name = "Item index {0} returns page index: {1}")
    @MethodSource("pageIndexParametersItemsPerPageGreater")
    void testPageIndexIfItemsPerPageGreater(int itemIndex, int pageIndex){
        assertEquals(pageIndex, helper2.pageIndex(itemIndex), "Page index on following item index " +itemIndex+" :");
    }

    private static Stream<Arguments> pageCountZeroParameters() {
        ArrayList<Character> itemList = new ArrayList<>();
        itemList.add('x');itemList.add('b');
        return Stream.of(
                Arguments.of(new PaginationHelper(itemList, 0)),
                Arguments.of(new PaginationHelper(new ArrayList<Character>(), 2))
        );
    }
    @ParameterizedTest
    @MethodSource("pageCountZeroParameters")
    void testPageCountWhenZero(PaginationHelper helper){
        assertEquals(0, helper.pageCount(), "Total Page Count ");
    }

    @ParameterizedTest
    @MethodSource("pageCountZeroParameters")
    void testPageItemCountWhenPageCountIsZero(PaginationHelper helper){
        assertEquals(-1, helper.pageItemCount(0), "Invalid page index: ");
    }

    @ParameterizedTest
    @MethodSource("pageCountZeroParameters")
    void testPageIndexWhenPageCountIsZero(PaginationHelper helper){
        assertEquals(-1, helper.pageIndex(0), "Invalid item index: ");
    }

}
