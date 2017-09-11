package zwz.random;

import java.util.Random;

/*
 * 从源代码中可以看到，Random在生成实例的时候会产生一个种子，种子是由当前的系统时间和seedUniquifier（一个多线程安全的类变量，每次生成一个Random实例都会改变取值）
 * 然后调用一个next()的方法生成随机数。使用的是线性同余随机数生成器。
 */
public class JavaRandom {

	public static void main(String[] args) {
		Random rd = new Random();
		rd.nextInt(10);

	}

}
