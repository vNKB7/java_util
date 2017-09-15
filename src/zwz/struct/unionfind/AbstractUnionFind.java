package zwz.struct.unionfind;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractUnionFind<E> implements UnionFindSet<E> {

	private Map<E, Integer> map;
	private int unionSuc = 0;

	public AbstractUnionFind() {
		map = new HashMap<>();
	}

	public boolean contains(E e) {
		return map.containsKey(e);
	}

	protected int getIndex(E e) {
		return map.get(e);
	}

	public int size() {
		return map.size();
	}

	public int disSetSize() {

		return size() - unionSuc;
	}

	protected int addElement(E e) {
		if (!map.containsKey(e)) {
			map.put(e, this.map.size());
		}
		int index = map.get(e);
		setParent(index, index);
		setRank(index, 0);

		return index;
	}

	public int makeSet(E e) {
		return addElement(e);
	}

	public int findSet(E e) {
		return findSetByIndex(getIndex(e));
	}

	public int findSetByIndex(int index) {
		if (index != getParent(index)) {
			setParent(index, findSetByIndex(getParent(index)));
		}
		return getParent(index);
	}

	public void union(E e1, E e2) {
		int index1 = findSet(e1);
		int index2 = findSet(e2);
		if (index1 == index2) {
			return;
		} else {
			link(index1, index2);
			unionSuc++;
		}
	}

	protected void link(int x, int y) {
		int xRank = getRank(x);
		int yRank = getRank(y);

		if (xRank > yRank) {
			setParent(y, x);
		} else {
			setParent(x, y);
			if (xRank == yRank) {
				setRank(y, yRank + 1);
			}
		}
	}

	protected abstract int getParent(int index);

	protected abstract void setParent(int index, int parent);

	protected abstract int getRank(int index);

	protected abstract void setRank(int index, int rank);

	public boolean connected(E e1, E e2) {
		return findSet(e1) == findSet(e2);
	}

	public void delete(E e) {
		throw new UnsupportedOperationException();
	}

	public void deleteSet(E e) {
		throw new UnsupportedOperationException();
	}
}
