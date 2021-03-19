package com.company;

import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class Main {
    public static int[] quickSort(ArrayList arr){
        int length = arr.size();
        if(length==0 || length==1){
            return (int[]) arr.get(arr.size());
        }else{
            int pivot = arr.
        }
        int[] low;
        int[] high;
        for(int item=0;item<arr.length;item++){
            high.append()
        }
        return arr;
    }
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	ArrayList arr = new ArrayList();
	for(int i=0;i<n;i++){
	    arr.set(i, in.nextInt());
    }
    quickSort(arr);
    }
}
