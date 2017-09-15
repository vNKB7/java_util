package zwz.struct.unionfind;

import java.util.ArrayList;
import java.util.List;

public class ArrayUnionFind<E> extends AbstractUnionFind<E> {
	List<Integer> parentArray = new ArrayList<>();
	List<Integer> rankArray = new ArrayList<>();

	@Override
	protected int getParent(int index) {
		return parentArray.get(index);
	}

	@Override
	protected void setParent(int index, int parent) {
		if (index == parentArray.size()) {
			parentArray.add(parent);
		} else {
			parentArray.set(index, parent);
		}
	}

	@Override
	protected int getRank(int index) {
		return rankArray.get(index);
	}

	@Override
	protected void setRank(int index, int rank) {
		if (index == rankArray.size()) {
			rankArray.add(rank);
		} else {
			rankArray.set(index, rank);
		}
	}

}
