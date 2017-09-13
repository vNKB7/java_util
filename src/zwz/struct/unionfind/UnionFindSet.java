package zwz.struct.unionfind;

public interface UnionFindSet {
	int makeSet();
	int findSet(int p);
	boolean connected(int p, int q);
	void union(int p, int q);
//	void getSets();
	int size();
	int disSetSize();
	void delete(int p);
	void deleteSet(int p);
}
