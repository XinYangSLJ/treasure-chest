package org.treasure.chest.dev.template.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author lj
 * @version 1.0.0
 * @Description 线程池配置
 * @createTime 2021-12-07 18:15
 */
@Configuration
public class ThreadPoolConfig {

    /**
     * 核心线程数
     */
    private static final int CORE_POOL_SIZE_DEFINE = 5;

    /**
     * 最大线程数
     */
    private static final int MAX_POOL_SIZE_DEFINE = 5;

    /**
     * 非核心线程空闲存活时间
     */
    private static final int KEEP_ALIVE_SECONDS_DEFINE = 20;

    /**
     * 阻塞队列容量
     */
    private static final int QUEUE_SIZE_DEFINE = 1000;

    @Bean("commonTaskExecutor")
    public ThreadPoolTaskExecutor commonTaskExecutor(){
        ThreadPoolTaskExecutor commonTaskExecutor = new ThreadPoolTaskExecutor();
        commonTaskExecutor.setCorePoolSize(CORE_POOL_SIZE_DEFINE);
        commonTaskExecutor.setMaxPoolSize(MAX_POOL_SIZE_DEFINE);
        commonTaskExecutor.setKeepAliveSeconds(KEEP_ALIVE_SECONDS_DEFINE);
        commonTaskExecutor.setQueueCapacity(QUEUE_SIZE_DEFINE);
        commonTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return commonTaskExecutor;
    }
}
