package binarySearch;

/**
 * To find the floor(target) within an array
 * Floor(target) : is the greatest element in the array that is = or < (less than) target element.
 */
public class FloorProblem {

    public static void main(String[] args) {
        int[] inputArray = {34,56,76,89,100};
        int targetElement = 77;
        int floorElementPosition = getTheFloorElementPosition(targetElement,inputArray);
        System.out.println("The floorElement for asc array position: " + floorElementPosition);
    }

    static int getTheFloorElementPosition(int target, int[] inputArray) {
        int startIndex = 0;
        int endIndex = inputArray.length -1;

        // Loop condition to run until the start position is always smaller than the end position.
        while (startIndex<=endIndex) {
            // the midIndex in simple is (startIndex + endIndex)/2 (middle position)
            // but the above mentioned formula can end up into "int" max allowed value , so below is same result but optimised
            int midIndex = startIndex + ((endIndex-startIndex)/2);

            if(inputArray[midIndex] == target) {
                return midIndex;
            }

            //In case of sorted array, if the TARGET is always less than middle element that means it is in the first half of the array
            //So here changing the position of the endIndex to search only in the first half.
            if(target < inputArray[midIndex]) {
                endIndex = midIndex -1;
            }else {
                //Otherwise changing the position of the startIndex to search only in the second half.
                startIndex = midIndex +1;
            }
        }
        //in case to identify the floor of the target it will always be the greatest element of the last searching array
        // when loop is broken i.e endIndex < startIndex
        return endIndex;
    }
}
