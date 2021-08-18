package twoHeap;

import java.util.PriorityQueue;
//While selecting projects we have two constraints:
//
//We can select a project only when we have the required capital.
//There is a maximum limit on how many projects we can select.
//Since we don’t have any constraint on time, we should choose a project, among the projects for which we have enough capital,
// which gives us a maximum profit. Following this greedy approach will give us the best solution.
//While selecting a project, we will do two things:
//Find all the projects that we can choose with the available capital.
//From the list of projects in the 1st step, choose the project that gives us a maximum profit.
//We can follow the Two Heaps approach similar to Find the Median of a Number Stream. Here are the steps of our algorithm:
//
//Add all project capitals to a min-heap, so that we can select a project with the smallest capital requirement.
//Go through the top projects of the min-heap and filter the projects that can be completed within our available capital.
// Insert the profits of all these projects into a max-heap, so that we can choose a project with the maximum profit.
//Finally, select the top project of the max-heap for investment.
//Repeat the 2nd and 3rd steps for the required number of projects.
public class maximizeCapital {
    class MaximizeCapital {
        public  int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
            int n = profits.length;
            PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<>(n, (i1, i2) -> capital[i1] - capital[i2]);
            PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(n, (i1, i2) -> profits[i2] - profits[i1]);

            // insert all project capitals to a min-heap
            for (int i = 0; i < n; i++)
                minCapitalHeap.offer(i);

            // let's try to find a total of 'numberOfProjects' best projects
            int availableCapital = initialCapital;
            for (int i = 0; i < numberOfProjects; i++) {
                // find all projects that can be selected within the available capital and insert them in a max-heap
                while (!minCapitalHeap.isEmpty() && capital[minCapitalHeap.peek()] <= availableCapital)
                    maxProfitHeap.add(minCapitalHeap.poll());

                // terminate if we are not able to find any project that can be completed within the available capital
                if (maxProfitHeap.isEmpty())
                    break;

                // select the project with the maximum profit
                availableCapital += profits[maxProfitHeap.poll()];
            }

            return availableCapital;
        }
    }
}
