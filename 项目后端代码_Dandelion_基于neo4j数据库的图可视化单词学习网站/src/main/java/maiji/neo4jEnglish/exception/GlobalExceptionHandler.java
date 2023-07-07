package maiji.neo4jEnglish.exception;

import maiji.neo4jEnglish.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 全局异常处理器
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 捕获所有异常
    @ExceptionHandler(Exception.class)
    public Result ex(Exception ex) {
        ex.printStackTrace();
        return Result.error("对不起，操作失败，请联系开发人员");
    }
}
