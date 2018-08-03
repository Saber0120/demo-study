package chapter02;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor
 *
 * Created by sheng on 2018/8/3.
 */
public class ThreadPoolExecutorDemo {

    //  Executors是java线程池的工厂类，可以快速初始化一个符合业务需求的线程池
    //  其本质是通过不同的参数来初始化一个ThreadPoolExecutor对象

    //    public ThreadPoolExecutor(int corePoolSize,
    //                              int maximumPoolSize,
    //                              long keepAliveTime,
    //                              TimeUnit unit,
    //                              BlockingQueue<Runnable> workQueue) {
    //        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
    //                Executors.defaultThreadFactory(), defaultHandler);
    //    }

    //1、corePoolSize：线程池的核心线程数，当提交一个任务时，线程池就会创建一个新线程，直到线程数到达corePoolSize；
    //  如果当前线程数为corePoolSize，继续提交的任务被保存到阻塞队列中，等待被执行；
    //  如果执行了线程池的prestartAllCoreThreads()，线程池会提前创建并启动所有核心线程
    //2、


    public static void main(String[] args) {

    }
}
