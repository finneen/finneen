package cn.finneen.poc.test.dp;

import cn.finneen.poc.dp.singleton.SingletonInitOnDemand;
import org.junit.Test;

/**
 * Created by Finneen on 2014/11/23.
 */
public class TestSingleton {

    @Test
    public void test() {
        for (int i=0 ; i < 10; i++) {
            SingleThread thread1 = new SingleThread();
            SingleThread thread2 = new SingleThread();
            thread1.start();
            System.out.println("thread1 : " + thread1.getName());
            thread2.start();
            System.out.println("thread2 : " + thread2.getName());

        }
    }

    class SingleThread extends Thread {
        @Override
        public void run() {
            SingletonInitOnDemand singleton = SingletonInitOnDemand.getInstance();
            System.out.println(singleton);
        }
    }
}
