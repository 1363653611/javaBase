进程：程序的一次执行过程，程序运行的基本单位。系统的运行，是从系统的创建到系统销往的过程。

线程：线程是比进程更小的运行单位，线程运行在进程上。多个线程可以运行在一个进程上。与进程不同的是，多个线程可以共享一块内存空间。
线程：线程是比进程更小的运行单位，线程运行在进程上。多个线程可以运行在一个进程上。与进程不同的是，多个线程可以共享一块内存空间，一组系统资源。
     在多个线程间切换时，比进程要轻量级很多。
多线程：多个线程同时运行（多核cpu）或者交替运行（单核cpu）。

概念：
    同步运行：同步方法调用一个方法，必须得等到调用方法返回值后才执行下一步操作
    异步运行：类似于发送消息，触发异步方法即可，不用等待，即可进行下一步操作。

    并发 concurrency  并行 Parallelism

    concurrency：并发，是指一个业务功能，大量用户同时启用。并发偏重于多个任务交替执行，而多个任务之间有可能还是串行的
    parallelism：并行，是指一个任务真正意义上的同时执行

   High concurrency 高并发： 互联网系统中必须考虑的因素之一，通过设计能够保证系统能够同时处理多个请求。
        常用指标：Response Time(响应时间) Though put(吞吐量) Query per Second （QPS 每秒钟查询量） 并发用户数 等。。。。

   临界区：一种共享资源或者公共数据，可以被多个线程使用。但每一次，只能有一个线程使用它，一旦该资源（临界区）被占用，其他线程要想访问该
         资源，就必须等待。在并行程序或者多线程程序中，临界区是需要保护的对象。

    block unblock 阻塞 非阻塞
   非阻塞：不能立即获得程序执行结果前，该程序不会阻塞当前线程，而是立刻返回。（异步调用）
   阻塞：程序等到返回结果后，执行下一步。（同步调用）

   线程优先级：线程的优先级可以在程序中表明该线程的重要性，如果有很多线程处于就绪状态，系统会根据优先级来决定首先使哪个线程进入运行状态
       -- 线程优先级具有继承特性比如A线程启动B线程，则B线程的优先级和A是一样的。
       -- 线程优先级具有随机性也就是说线程优先级高的不一定每一次都先执行完。

Java多线程分类

    用户线程：运行在前台，执行具体的任务，如主线程，网络子线程等。
    守护线程：运行在后台，为其他线程提供服务，也可以说守护线程是JVM中非守护线程的佣人
            特点：一旦所有用户线程都结束运行，守护线程会随JVM一起结束工作
            应用：数据库连接池中的检测线程，JVM虚拟机启动后的检测线程

    最常见的守护线程：垃圾回收线程

    注意：
        setDaemon(true)必须在start（）方法前执行，否则会抛出IllegalThreadStateException异常
        在守护线程中产生的新线程也是守护线程
        不是所有的任务都可以分配给守护线程来执行，比如读写操作或者计算逻辑




