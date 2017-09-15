package zwz.struct.unionfind;

public interface UnionFindSet<E> {
	int makeSet(E e);
	int findSet(E e);
	void union(E e1, E e2);
	boolean connected(E e1, E e2);
	boolean contains(E e);
//	void getSets();
	int size();
	int disSetSize();
	void delete(E e);
	void deleteSet(E e);
}
