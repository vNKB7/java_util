import java.util.Arrays;
import java.util.Random;


public class KSelect {

	public static void main(String[] args) {
		int[] array = {8,4,3,2,5,6,1,7,9};
		System.out.println(kSelect(array, 8));
		System.out.println(Arrays.toString(array));
	}
	
	
	static int kSelect(int[] array, int k){
		int index = patition(array, 0, array.length-1);
		int start = 0;
		int end = array.length-1;
		
		while(index != k-1){
			if(index > k-1){
				end = index-1;
				index = patition(array, start, end);
			}else{
				start = index + 1;
				index = patition(array, start, end);
			}
		}
		return array[index];
	}
	
	static int patition(int[] array, int start, int end){
		if(end - start == 0) return start;
		Random rd = new Random();
		int p = rd.nextInt(end-start+1) + start;
		swap(array, p, start);
		
		int left = start+1, right = start+1;
		while(right <= end){
			if(array[right] <= array[start]){
				swap(array, left, right);
				left++;
				right++;
			}else{
				right++;
			}
		}
		
		swap(array, start, left-1);
		return left-1;
	}
	
	static void swap(int[] array, int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

}
