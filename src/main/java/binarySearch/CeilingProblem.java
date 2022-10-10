package binarySearch;

/**
 * To find the ceiling of the target : The smallest element in the array that is = or > (greater) than the target element.
 * Time complexity of this problem is O(log n) : As the search is N^K ( N no: of elements , K : times need to perform search)
 */
public class CeilingProblem {
    public static void main(String[] arg) {
        int[] inputArray = {34,56,76,89,100};
        int targetElement = 130;
        int ceilingElementPosition = getTheCeilingElementPosition(targetElement,inputArray);
        System.out.println("The ceilingElement position : " + ceilingElementPosition);
    }

    /**
     * Return the position of the ceiling element in an array.
     * @param target element to search
     * @param inputArray source array
     * @return position of the element
     */
    static int getTheCeilingElementPosition(int target, int[] inputArray) {
        //if the target > than the last element of the array
        if( target > inputArray[inputArray.length -1]) {
            return  -1;
        }
        int startIndex = 0;
        int endIndex = inputArray.length -1;
        //To check in what order the elements are sorted in the array
        boolean isAsc = inputArray[startIndex] < inputArray[endIndex];

        // Loop condition to run until the start position is always smaller than the end position.
        while (startIndex <= endIndex){
            // the midIndex in simple is (startIndex + endIndex)/2 (middle position)
            // but the above mentioned formula can end up into "int" max allowed value , so below is same result but optimised
            int midIndex = startIndex + ((endIndex-startIndex)/2) ;

            if(inputArray[midIndex] == target ){
                return midIndex;
            }
            if(isAsc) {
                //In case of asc sorted array, if the TARGET is always less than middle element that means it is in the first half of the array
                //So here changing the position of the endIndex to search only in the first half.
                if (target < inputArray[midIndex]){
                    endIndex = midIndex -1;
                } else {
                    //Otherwise changing the position of the startIndex to search only in the second half.
                    startIndex = midIndex +1;
                }
            } else {
                //In case of desc sorted array, if the TARGET is always less than middle element that means it is in the second half of the array
                //So here changing the position of the startIndex to search only in the second half.
                if (target < inputArray[midIndex]){
                    startIndex = midIndex +1;
                } else {
                    //Otherwise changing the position of the endIndex to search only in the first half.
                    endIndex = midIndex -1;
                }
            }
        }
        //in case to identify the ceiling of the target it will always be the smallest element of the last searching array
        // when loop is broken i.e endIndex < startIndex
        return startIndex;
    }
}