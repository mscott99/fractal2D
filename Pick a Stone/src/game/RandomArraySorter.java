package game;

import java.util.Random;

public class RandomArraySorter {
 static void randomSort(Guy[] bruh){
	 for(int x=0; x <bruh.length;x++ ){
		 int position =new Random().nextInt(bruh.length-1);
		 Guy get = bruh[position];
		 bruh[position]=bruh[x];
		 bruh[x]=get;
	 }
	 
 }
}
