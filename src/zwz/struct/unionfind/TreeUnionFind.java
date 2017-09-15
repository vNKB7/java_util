package zwz.struct.unionfind;

import java.util.ArrayList;
import java.util.List;

public class TreeUnionFind<E> extends AbstractUnionFind<E>{

	List<Node> nodeArray = new ArrayList<>();
	
	@Override
	protected int getParent(int index) {
		return nodeArray.get(index).parent.index;
	}

	@Override
	protected void setParent(int index, int parent) {
		if (index == nodeArray.size()) {
			nodeArray.add(new Node(index));
		} else {
			nodeArray.get(index).setParent(parent);
		}
	}

	@Override
	protected int getRank(int index) {
		return nodeArray.get(index).rank;
	}

	@Override
	protected void setRank(int index, int rank) {
		if (index == nodeArray.size()) {
			nodeArray.add(new Node(index));
		}
		nodeArray.get(index).rank = rank;
	}

	
	class Node{
		int rank;
		Node parent;
//		int parentIndex;
		int index;
		
		public Node(int index){
			this.parent = this;
			this.index = index;
			this.rank = 0;
//			this.parentIndex = this.index;
		}
		
		public void setParent(int index){
			this.parent = nodeArray.get(index);
		}
	}
}
