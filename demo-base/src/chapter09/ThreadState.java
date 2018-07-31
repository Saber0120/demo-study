package chapter09;

/**
 * 线程的状态
 * 1、新建状态
 * 创建了一个线程对象后，如new TestThread()
 * 2、就绪状态
 * 调用了start()后，线程启动，进入排队序列，等待CPU服务
 * 3、运行状态
 * 获得处理器资源后，进入运行状态，自动调用run()方法
 * 4、阻塞状态
 * 正在执行的线程在某些特殊情况下，被人为挂起或需要执行耗时的输入输出操作时，将让出CPU并暂时中止自己的执行，进入阻塞状态。
 * 比如在执行状态下调用sleep(),suspend(),wait()等方法。
 * 阻塞时，线程不能进入排队队列，只有当阻塞消除后，才能进入就绪状态
 * 5、死亡状态
 * 调用stop()或run()执行完成后，线程进入死亡状态，不能继续运行。
 * Created by sheng on 2018/7/31.
 */
public class ThreadState {
}