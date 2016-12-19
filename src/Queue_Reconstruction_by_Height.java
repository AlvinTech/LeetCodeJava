import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alvin on 16/12/19.
 */

/*
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
* */
public class Queue_Reconstruction_by_Height {
    public int[][] reconstructQueue(int[][] people) {

        Comparator comparator = new Comparator() {
            public int compare(Object o1, Object o2) {
                int[] array1 = (int[]) o1;
                int[] array2 = (int[]) o2;
                if (array1[0] > array2[0])  return -1;
                else if (array1[0] < array2[0] ) return 1;
                else {
                    if (array1[1] > array2[1])  return 1;
                    else return -1;
                }
            }
        };
        Arrays.sort(people, comparator);

        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            int[] value = people[i];
            list.add(value[1], value);
        }

        int[][] array = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            array[i][0] = list.get(i)[0];
            array[i][1] = list.get(i)[1];
        }
        return array;
    }

    private void print(List<int[]> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(" (" + list.get(i)[0] + " " + list.get(i)[1] + " ), ");

        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
        new Queue_Reconstruction_by_Height().reconstructQueue(people);
    }
}
