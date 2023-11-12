package store.dongji.util;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.List;

/**
 * @Author PangJunjie
 * @Date 2022/8/3/003
 */
@Data
public class ResultJson {
    private Integer code;
    private String msg;
    private Object data;
    private Integer count;

    public static Object ok(){
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(200);
        resultJson.setMsg("success");
        return JSON.toJSON(resultJson);
    }

    public static Object ok(Object data){
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(200);
        resultJson.setMsg("success");
        resultJson.setData(data);
        return JSON.toJSON(resultJson);
    }

    public static Object page(Integer count, List<?> list){
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(0);
        resultJson.setMsg("no data");
        resultJson.setCount(count);
        resultJson.setData(list);
        return JSON.toJSON(resultJson);
    }

    public static Object error(){
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(500);
        resultJson.setMsg("error");
        return JSON.toJSON(resultJson);
    }

    public static Object error(String msg){
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(500);
        resultJson.setMsg(msg);
        return JSON.toJSON(resultJson);
    }

    public static Object error(Integer code,String msg){
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(code);
        resultJson.setMsg(msg);
        return JSON.toJSON(resultJson);
    }
}
