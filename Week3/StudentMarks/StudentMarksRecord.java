package myPackage;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> marks = new ArrayList<>();
		marks.add(67);
		marks.add(75);
		marks.add(95);
		int high = marks.get(0);
		int low = marks.get(0);
        for(int num : marks) {
        	if(high < num) {
        		high = num;
        	}
        	if(low > num) {
        		low = num;
        	}
        }
        System.out.println("Maximum marks: " + high);
        System.out.println("Minimum marks: " + low);
	}

}
