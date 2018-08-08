/*Shontinique Uqdah
 * August 7, 2018
 */
package co.grandcircus.Lab18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Occurence {

	
	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 2, 2, 4, 5, 5, 7, 8, 4, 4, 1, 0, 10};
		
		
		System.out.println("Count frequency using a hashmap: ");
		printMap(getFrequencyHashMap(numbers));
		System.out.println();
		System.out.println("Count frequency using an array: ");
		getAndPrintFrequencyArray(numbers);
	}


	//Estimated O(n)...single Loop
	public static Map<Integer, Integer> getFrequencyHashMap(int[] numbers) {
		Map<Integer, Integer> frequency = new HashMap<>();
		for (int num : numbers) {
			if (frequency.containsKey(num)) {
				frequency.replace(num, frequency.get(num) + 1);
			}
			frequency.putIfAbsent(num, 1);
			}
		return frequency;
		}
		

	//Estimated O(n^2) ...Nested Loop
	public static void getAndPrintFrequencyArray(int[] numbers) {
		Arrays.sort(numbers);
		
		int count = 0;
	    int start = 0; 
	    int move = 0;
	    
	    while(start < numbers.length){
            for (int j = 0; j < numbers.length; j++){
                int currentInt = numbers[start];;
                if (currentInt == numbers[j])
                {
                    count++;
                    move++;
                }
            }
             System.out.println("[" + numbers[start] + "] : " + count);
                count = 0;
                start = start + move;
                move = 0;
        }
	}
	
	
//	Estimated O(n)....Single loop
	public static void printMap(Map<Integer, Integer> frequency) {
		for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
			System.out.println("[" + entry.getKey() + "] : " + entry.getValue());
		}
	}

}
