package paintFill;
// graph 要记住的是，原来的x y 并不是原来的含义。应该是graph[y][x] 一般是这么表示。
// 是要将原来的颜色替换成新的颜色。如果是一样的颜色就可以直接返回。
// 如果不是就要进入递归，因为要传入的参数多了现有的颜色和原来的颜色进行比较所以是新的函数。
// base case 是这个点不是原来的颜色。但是这个不需要做什么就直接return 所以可以不必写。
// 最开始要判断边界。作为基本的return
// 其他的情况是周围四个方向检查是否要重新涂色。
public class PaintFill {
	enum Color {
		Black, White, Red, Yellow, Green
	}

	public boolean paintFull(Color[][] screen, int x, int y, Color ocolor,
			Color ncolor) {
		if (x < 0 || x >= screen[0].length || y < 0 || y >= screen.length) {
			return false;
		}

		if (screen[y][x] == ocolor) {
			screen[y][x] = ncolor;
			paintFull(screen, x - 1, y, ocolor, ncolor);
			paintFull(screen, x + 1, y, ocolor, ncolor);
			paintFull(screen, x, y - 1, ocolor, ncolor);
			paintFull(screen, x, y + 1, ocolor, ncolor);
		}
		return true;
	}

	public boolean paintFull(Color[][] screen, int x, int y, Color ncolor) {
		if (screen[y][x] == ncolor) {
			return false;
		}
		return paintFull(screen, x, y, screen[y][x], ncolor);
	}
}
