package binarySearch;

/**
 * To perform binary search on the input aary of int elements , that cen be sorted in Asc or Desc
 */
public class OrderAgnostic {

    public static void main(String[] arg) {
        int[] arrayOfElements = {34,56,76,89,100};
        int elementToSearch = 89;
        int positionOfElement = orderAgnosticSearch(elementToSearch,arrayOfElements);
        System.out.println("The position of the element : "+ positionOfElement);
    }

    static int orderAgnosticSearch( int target, int[] inputArray) {
        //return - 1 if the target element not found
        int startIndex = 0;
        int endIndex = inputArray.length -1;
        boolean isAsc = inputArray[startIndex] < inputArray[endIndex];

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
