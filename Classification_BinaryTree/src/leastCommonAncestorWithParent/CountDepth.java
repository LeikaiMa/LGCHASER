package leastCommonAncestorWithParent;
//CC
//如果有parent 就不需要递归了， 就只要从现在这个出发，然后两个往上走，如果相遇就说明这个就是他们最短的ancestor
//如果没有相遇，就说明不在同一个tree 里面。
//所以开始的时候就要先将两个node 的深度先得出来，然后得到的将深的往上把gap 填平，然后才可以一起移动。
//http://leetcode.com/2011/07/lowest-common-ancestor-of-a-binary-tree-part-ii.html
public class CountDepth {
	public TreeNode getLCA(TreeNode p, TreeNode q) {
		int h1 = getHeight(p);
		int h2 = getHeight(q);

		if (h1 < h2) {
			TreeNode tmp = p;
			p = q;
			q = tmp;
			int t = h1;
			h1 = h2;
			h2 = t;
		}

		while (h1 > h2) {
			p = p.parent;
			h1--;
		}

		while (p != null && q != null) {
			if (p == q) {
				return p;
			}

			p = p.parent;
			q = q.parent;
		}

		return null;
	}

	public int getHeight(TreeNode p) {
		int height = 0;
		while (p != null) {
			p = p.parent;
			height++;
		}
		return height;
	}
}
