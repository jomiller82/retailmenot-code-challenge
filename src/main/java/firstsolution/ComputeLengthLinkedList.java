package firstsolution;

import java.util.Arrays;
import java.util.LinkedList;

public class ComputeLengthLinkedList {

    public static void main(String[] args) {
        System.out.println(String.format("Linked List Length:  %d", getLinkedListLength(args)));
        System.out.println(String.format("Linked List Contains:  %s", getLinkedListStringArray(args).toString()));
    }

    public static int getLinkedListLength(String[] list) { return new LinkedList<>(Arrays.asList(list)).size(); }

    public static LinkedList getLinkedListStringArray(String[] list) { return new LinkedList<>(Arrays.asList(list)); }
}
