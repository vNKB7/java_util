package zwz.struct.unionfind;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedListUnionFind extends AbstractUnionFind {
	private List<DNode> nodes;
	private List<HNode> heads;

	public LinkedListUnionFind() {
		nodes = new ArrayList<DNode>();
	}

	public LinkedListUnionFind(int num) {
		nodes = new ArrayList<DNode>();
		addElements(num);
	}

	@Override
	public int findSet(int p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addElements(int nums) {
		if(nums < 1){
			return -1;
		}else{
			int start = nodes.size();
			for(int i = 0; i < nums; i++){
				HNode hn = new HNode();
				heads.add(hn);
				
				DNode dn = new DNode();
				nodes.add(dn);
				
				
			}
			
			return start;
		}
	}

	@Override
	protected void set(int p, int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean connected(int p, int q) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void union(int p, int q) {
		// TODO Auto-generated method stub

	}

//	@Override
//	public void getSets() {
//		// TODO Auto-generated method stub
//
//	}

	
	@Override
	public int size() {
		return nodes.size();
	}
	
	class DNode {
		DNode next;
		HNode head;
		int index;
		
		public DNode(int index){
			this.index = index;
		}
		
		public int headIndex(){
			if(head == null){
				return -1;
			}else{
				return head.headIndex();
			}
		}
	}
	
	class HNode{
		DNode head;
		DNode tail;
		int size;
		
		public HNode(){
			
		}
		
		public void insert(DNode node){
			if(node.headIndex() != headIndex()){
				
			}
		}
		
		public int headIndex(){
			if(head == null){
				return -1;
			}else{
				return head.index;
			}
		}
	}

	@Override
	public int disSetSize() {
		return heads.size();
	}
}
