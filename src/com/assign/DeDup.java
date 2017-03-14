package com.assign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class DeDup {

	
	public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
            13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};   
	
	
	public int[] removeDuplicatesList(int[] list){
		
	        if(list.length == 0){
	            return null;
	        }
	        if(list.length == 1){
	            return list;
	        }

		    ArrayList<Integer> numbers = new ArrayList<>();
		    for(int i = 0; i< list.length; i++){
		        if (!numbers.contains(list[i])){
		            numbers.add(list[i]);
		        }
		    }
		    Iterator<Integer> valueIterator = numbers.iterator();
		    int[] resultArray = new int[numbers.size()]; 
		    int i = 0;
		    while (valueIterator.hasNext()) {
		        resultArray[i] = valueIterator.next();
		        i++;
		    }
		    
		 return resultArray;     

    }
	
	
	public int[] removeDuplicatesSet(int[] list){
		
		if(list.length == 0){
            return null;
        }
        if(list.length == 1){
            return list;
        }
        Set<Integer> setListNumbers = new TreeSet<Integer>();
        
        for(Integer i : list){
        	
        	setListNumbers.add(i);
        	
        }
        int[] resultArray = setListNumbers.stream().mapToInt(i->i).toArray();
	   
	    return resultArray; 
	}
	
	
	public static int[] removeCoreDuplicates(int list[]){
		
			if(list.length == 0){
	            return null;
	        }
	        if(list.length == 1){
	            return list;
	        }
		  
	        Arrays.sort(list);  
	        ArrayList<Integer> numbers = new ArrayList<>();
	        int previous = list[0];
	        numbers.add(previous);
	        for (int i = 1; i < list.length; i++) {
	            int ch = list[i];

	            if (previous != ch) {
	            	numbers.add(ch);
	            }
	            previous = ch;
	        }
	        int[] resultArray = numbers.stream().mapToInt(i->i).toArray();
	 	    return resultArray; 
	        
	}

	public static void main(String [] args) {
		
		DeDup deDup = new DeDup();
		
		//Method 1 unsorted array
		int[] randomCoreIntegers = deDup.removeDuplicatesList(deDup.randomIntegers);
		for(Integer i : randomCoreIntegers){
			System.out.print(i+",");
		}
		System.out.println("Core Length "+randomCoreIntegers.length);
		
		//Method 2 sorted array
		int[] randomSetIntegers = deDup.removeDuplicatesSet(deDup.randomIntegers);
		for(Integer i : randomSetIntegers){
			System.out.print(i+",");
		}
		System.out.println("Set Length "+randomSetIntegers.length);
		
		//Method 3 unsorted array
		int[] randomListIntegers = deDup.removeDuplicatesList(deDup.randomIntegers);
		for(Integer i : randomListIntegers){
			System.out.print(i+",");
		}
		System.out.println("List Length "+randomListIntegers.length);
		
	}

	
}
