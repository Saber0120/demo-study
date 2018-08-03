package chapter01;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 合理利用线程有一下好处：
 * 1、降低资源消耗
 * 2、提高响应速度
 * 3、提高线程的可管理性
 * 但是线程不可无限制的创建，否则，不仅会消耗系统资源，还会降低系统稳定性
 *
 * Java1.5引入了Executor框架来管理线程池
 * Created by sheng on 2018/8/3.
 */
public class ExecutorCase {

    //  初始化一个包含10个线程的线程池executor
    //  负责执行任务的线程的生命周期都由Executor框架管理
    private static Executor executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            //  通过executor.execute()方法提交20个任务，每个任务打印当前线程名
            executor.execute(new Task());
        }
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
