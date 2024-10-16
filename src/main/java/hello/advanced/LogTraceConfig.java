package hello.advanced;

import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean // 수동으로 Bean을 등록하는 방법. (싱글톤으로 등록되었음)
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
