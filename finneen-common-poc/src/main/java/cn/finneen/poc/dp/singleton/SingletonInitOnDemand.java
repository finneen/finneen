package cn.finneen.poc.dp.singleton;

/**
 * Created by yaofeng on 2014/11/20.\
 * <p/>
 * 单例实现
 */
public class SingletonInitOnDemand {

	private SingletonInitOnDemand() {
	}

	private static class SingletonHolder {
		private static final SingletonInitOnDemand Instance = new SingletonInitOnDemand();
	}

	public static SingletonInitOnDemand getInstance() {
		return SingletonHolder.Instance;
	}
}
