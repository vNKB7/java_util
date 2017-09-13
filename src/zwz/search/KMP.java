package zwz.search;

import java.util.ArrayList;
import java.util.List;

public class KMP {
	static final int NAIVE = 0;
	static final int OPTIMIZED = 1;

	public static int find(String s, String p) {
		return find(s, p, OPTIMIZED);
	}

	public static List<Integer> find_all(String s, String p) {
		return find_all(s, p, OPTIMIZED);
	}

	public static int find(String s, String p, int mode) {
		int[] next = new int[p.length() + 1];
		nextFactory(mode).getNext(p, next);

		int i = 0;
		int j = 0;
		int s_len = s.length();
		int p_len = p.length();

		while (i < s_len && j < p_len) {
			if (j == -1 || s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}

		if (j == p_len) {
			return i - j;
		}

		return -1;
	}

	public static List<Integer> find_all(String s, String p, int mode) {
		List<Integer> result = new ArrayList<>();

		int[] next = new int[p.length() + 1];
		nextFactory(mode).getNext(p, next);

		int i = 0;
		int j = 0;
		int s_len = s.length();
		int p_len = p.length();

		while (i < s_len && j < s_len) {
			if (j == -1 || s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}

			if (j == p_len) {
				result.add(i - j);
				j = next[p_len];
			}
		}

		return result;
	}

	private static Next nextFactory(int mode) {
		Next next = null;
		switch (mode) {
		case NAIVE:
			next = new NaiveNext();
			break;
		case OPTIMIZED:
			next = new OptimizedNext();
			break;
		default:
			next = new OptimizedNext();
		}
		return next;
	}

	interface Next {
		public void getNext(String p, int next[]);
	}

	static class NaiveNext implements Next {

		@Override
		public void getNext(String p, int[] next) {
			int p_len = p.length();
			int i = 0;
			int j = -1;
			next[0] = -1;

			while (i < p_len) {
				if (j == -1 || p.charAt(i) == p.charAt(j)) {
					i++;
					j++;
					next[i] = j;
				} else {
					j = next[j];
				}
			}
		}

	}

	static class OptimizedNext implements Next {

		@Override
		public void getNext(String p, int[] next) {
			int p_len = p.length();
			int i = 0;
			int j = -1;
			next[0] = -1;

			while (i < p_len) {
				if (j == -1 || p.charAt(i) == p.charAt(j)) {
					i++;
					j++;
					
					if(i == p_len || p.charAt(i) != p.charAt(j)){
						next[i] = j;
					}else{
						next[i] = next[j];
					}
				} else {
					j = next[j];
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(KMP.find_all("abababa", "aba"));
	}

}
