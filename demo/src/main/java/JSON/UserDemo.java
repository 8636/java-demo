package JSON;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Created by duan on 2019/12/19 14:14
 */
@Data
@AllArgsConstructor
@ToString
public class UserDemo {

    private String userName;
    private String passWord;

}
