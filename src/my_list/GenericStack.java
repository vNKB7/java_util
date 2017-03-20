package my_list;

import java.util.ArrayList;

public class GenericStack<E> {
	private ArrayList<E> list = new ArrayList<E>();
	
	public GenericStack(){
		
	}
	
	public int getSize(){
		return list.size();
	}
	
	public E peek(){
		return list.get(list.size()-1);
	}
	
	public void push(E o){
		list.add(o);
	}
	
	public E pop(){
		E o = list.get(list.size()-1);
		list.remove(list.size()-1);
		return o;
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
