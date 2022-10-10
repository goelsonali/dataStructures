package binarySearch;

/**
 * To perform binary search on the input array of int elements , that cen be sorted in Asc or Desc
 * Time complexity of this problem is O(log n) : As the search is N^K ( N no: of elements , K : times need to perform search)
 */
public class OrderAgnostic {

    public static void main(String[] arg) {
        int[] ascending = {34,56,76,89,100};
        int[] descending = {100,99,86,84,76,54,32};
        int elementToSearch = 76;
        int positionOfAscElement = orderAgnosticSearch(elementToSearch,ascending);
        int positionOfDescElement = orderAgnosticSearch(elementToSearch,descending);
        System.out.println("The position of the element in an ascending array: " + positionOfAscElement);
        System.out.println("The position of the element in an descending array: " + positionOfDescElement);
    }

    /**
     * Return the position of the element to searched for in an array.
     * @param target element to search
     * @param inputArray source array
     * @return position of the element
     */
    static int orderAgnosticSearch( int target, int[] inputArray) {
        //return - 1 if the target element not found
        int startIndex = 0;
        int endIndex = inputArray.length -1;
        boolean isAsc = inputArray[startIndex] < inputArray[endIndex];

        //The basic condition to narrow down the search of the element
        while (startIndex <= endIndex){
            int midIndex = startIndex + ((endIndex-startIndex)/2) ;

            if(inputArray[midIndex] == target ){
                return midIndex;
            }
            if(isAsc) {
                if (target < inputArray[midIndex]){
                    endIndex = midIndex -1;
                } else {
                    startIndex = midIndex +1;
                }
            } else {
                if (target < inputArray[midIndex]){
                    startIndex = midIndex +1;
                } else {
                    endIndex = midIndex -1;
                }
            }
        }
        return -1;
    }
}
