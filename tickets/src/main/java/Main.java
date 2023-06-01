import solver.LuckyTicketsSolverBasicImpl;
import solver.LuckyTicketsSolverImpl;

public class Main {
    public static void main(String[] args) {

        int a[] = new int[]{1,2,2,3,4,4,4,6,8};
        removeDuplicates(a);
        System.out.println("sda");
        LuckyTicketCounterRunner luckyTicketCounterRunner
                = new LuckyTicketCounterRunner(new LuckyTicketsSolverBasicImpl(), new LuckyTicketsSolverImpl());
        luckyTicketCounterRunner.run();
    }


    public static int removeDuplicates(int[] nums) {

        int addIndex = 1; //index that unique characters will be inserted at

        for(int i = 0; i < nums.length - 1; i++) {

            if(nums[i] < nums[i + 1]){ //if true, num[i + 1] is a new unique number
                nums[addIndex] = nums[i + 1];
                addIndex++;
            }
        }

        return addIndex ; // Return the length of the new subarray
    }


}
