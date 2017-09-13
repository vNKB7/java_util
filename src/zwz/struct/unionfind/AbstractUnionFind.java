package zwz.struct.unionfind;

public abstract class AbstractUnionFind<E> implements UnionFindSet {

	public int makeSet() {
		return addElements(1);
	}

	public abstract int addElements(int nums);

	public boolean connected(int p, int q) {
		return findSet(p) == findSet(q);
	}

	public void delete(int p){
		throw new UnsupportedOperationException();
	}
	
	public void deleteSet(int p){
		throw new UnsupportedOperationException();
	}
}
