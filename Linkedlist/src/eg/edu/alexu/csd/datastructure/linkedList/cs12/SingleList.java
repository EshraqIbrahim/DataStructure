package eg.edu.alexu.csd.datastructure.linkedList.cs12;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class SingleList implements ILinkedList {
	public node head = null ;
	
	public void print(){
		   node current = head;
		   while(current != null){
			   System.out.print(current.data);
			   current = current.next;
	}}

	@Override
	public void add(int index, Object element) {
		   node newNode = new node(element);
		   if(index == 0 ){
			   newNode.next = head;
			   head = newNode;
		   }
		   else{
			   node current = head;
			   for(int i=0 ; i<index-1;i++){
				   current = current.next;
			   }
			   newNode.next=current.next;
			   current.next = newNode;
		// TODO Auto-generated method stub
		   }
	}

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set(int index, Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

}



