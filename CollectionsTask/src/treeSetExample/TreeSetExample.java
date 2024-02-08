package treeSetExample;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        //1. Create a TreeSet of integers
        TreeSet<Integer> treeSet = new TreeSet<>();

        // 2. Adding elements to the TreeSet
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(8);
        treeSet.add(1);
        System.out.println("TreeSet after adding elements: " + treeSet); // treeset will be automatically sorted here

        // 3. Removing an element from the TreeSet
        treeSet.remove(2);
        System.out.println("TreeSet after removing a element: " + treeSet);

        // 4. Checking for specific elements
        int elementToCheck = 5;
        if (treeSet.contains(elementToCheck)) {
            System.out.println("TreeSet contains " + elementToCheck);
        } else {
            System.out.println("TreeSet does not contain " + elementToCheck);
        }
    }
}
