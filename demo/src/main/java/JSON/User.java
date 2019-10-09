package JSON;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @JSONField(name = "UserName")
    private String UserName;
    @JSONField(name = "PassWord")
    private String PassWord;
}
