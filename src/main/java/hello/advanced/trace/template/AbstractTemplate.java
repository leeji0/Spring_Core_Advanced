package hello.advanced.trace.template;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;

/**
 * - 'AbstractTemplate'은 템플릿 메서드 패턴에서 부모 클래스
 * - <T> 제네릭을 사용하여 반환타입 정의
 * - 객체를 생성할 때 내부에서 사용할 LogTrace trace 를 전달 받음
 * @param <T>
 */
public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String message) {

        TraceStatus status = null;
        try {
            status = trace.begin(message);
            //로직 호출
            T result = call();

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    /**
     * - 변하는 부분을 처리하는 메서드. 상속으로 구현 필요.
     * @return
     */
    protected abstract T call();
}
