package rxt.bsb.rest.common.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.SmartLifecycle;
import org.springframework.core.Ordered;

import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public  class AfterIoc implements SmartLifecycle, ApplicationContextAware, Ordered, JoinAfterIoc{

    private final static Logger logger = LoggerFactory.getLogger(AfterIoc.class);

    protected ApplicationContext ioc;

    private boolean isRunning  = false ;



    /**
     * 因为springmvc 的原因 这里解决下并发的问题 、 保证只执行一遍
     */
    static  volatile AtomicBoolean atomicBoolean = new AtomicBoolean(true);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            this.ioc  = applicationContext;
    }

    /**
     * 容器初始化完成调用 ，此时所有非懒加载的bean都已实例化
     */
    @Override
    public final void start() {
        synchronized (atomicBoolean) {
            if( !atomicBoolean.get()) return ;
            atomicBoolean.set(false);
        }

        isRunning = true;

        Map<String ,AfterIoc> aisMap = ioc.getBeansOfType(AfterIoc.class);

        int NCPU = Runtime.getRuntime().availableProcessors();

        // 核心线程数为 1 时 串行执行
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(NCPU,20,60, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        threadPool.allowCoreThreadTimeOut(true);
        try {

            // 遍历所有  AfterIoc 类型的bean(包括它自己) 执行 join 方法 异步执行
            for( JoinAfterIoc jac : aisMap.values()) {
                threadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        jac.join();
                    }
                });
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }




    @Override
    public void stop() {
        logger.info( "容器关闭  AfterIoc.stop");
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void join() {
        String info  =  "容器初始化完成  AfterIoc.start";
        logger.info( info);
    }
}
