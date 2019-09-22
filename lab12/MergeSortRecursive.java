import edu.princeton.cs.algs4.Queue;

public class MergeSortRecursive {
    /** Returns a Queue that contains the given items sorted from least to greatest. */
    public static <Item extends Comparable> Queue<Item> mergeSort(
            Queue<Item> items) {
        // recursively devide queue into single item
        // base case: one element -> return itself
        if (items.size() <= 1) return items;

        // general case:
        // two parts -> call mergeSort on each part
        Queue<Item> leftInput = new Queue<>();
        int len = items.size();
        // divide into two pieces
        while (items.size() > len / 2) {
            leftInput.enqueue(items.dequeue());
        }
        Queue<Item> leftRes = mergeSort(leftInput);
        Queue<Item> rightRes = mergeSort(items);

        // merge and return results
        return merge(leftRes, rightRes);
    }

    private static <Item extends Comparable> Queue<Item> merge(Queue<Item> left, Queue<Item> right) {
        Queue<Item> res = new Queue<>();
        while (!left.isEmpty() || !right.isEmpty()) {
            Item leftItem = left.isEmpty() ? null : left.peek();
            Item righItem = right.isEmpty() ? null : right.peek();
            if (leftItem == null || righItem != null && righItem.compareTo(leftItem) <= 0) {
                res.enqueue(right.dequeue());
            } else {
                res.enqueue(left.dequeue());
            }
        }
        return res;
    }
}
