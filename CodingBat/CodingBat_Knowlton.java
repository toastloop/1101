/*
    Name: CodingBat_Knowlton
    Author Name: Matthew Knowlton
    Lab Number: CodingBat
    Date: 13 April 2022
*/
public class CodingBat_Knowlton{
    public static void main(String[] args) {
        int[] bigDiff = {7,2,10,9};
        System.out.println(bigDiff(bigDiff));
        int[] sum13 = {1,2,2,1,13};
        System.out.println(sum13(sum13));
        int[] lucky13 = {1,2,3};
        System.out.println(lucky13(lucky13));
        int[] sum28 = {2,3,2,2,4,2};
        System.out.println(sum28(sum28));
        int[] more14 = {1,4,1,4};
        System.out.println(more14(more14));
    }
    public static int bigDiff(int[] intArray) {
        int min = intArray[0];
        int max = intArray[0];
        for(int i = 0; i < intArray.length; i++){
            if(intArray[i] > max){
                max = intArray[i];
            }
            if(intArray[i] < min){
                min = intArray[i];
            }
        }
        return max-min;
    }
    public static int sum13(int[] intArray){
        if(intArray.length  == 0){
            return 0;
        }
        else{
            int sum = 0;
            for(int i = 0; i < intArray.length; i++){
                if(intArray[i] < 13){
                    sum += intArray[i];
                }
            }
            return sum;
        }
    }
    public static boolean lucky13(int[] intArray){
        boolean no13 = true;
        for(int i = 0; i < intArray.length; i++){
            if(intArray[i] == 1 || intArray[i] == 3){
                no13 = false;
            }
        }
        return no13;
    }
    public static boolean sum28(int[] intArray) {
        int sum = 0;
        for(int i = 0; i < intArray.length; i++){
            if(intArray[i] == 2){
                sum += 2;
            }
        }
        return (sum == 8);
    }
    public static boolean more14(int[] intArray) {
        int counter1 = 0;
        int counter4 = 0;
        for(int i = 0; i < intArray.length; i++){
            if(intArray[i] == 1){
                counter1++;
            } else if(intArray[i] == 4){
                counter4++;
            }
        }
        return (counter1 > counter4);
    }
}