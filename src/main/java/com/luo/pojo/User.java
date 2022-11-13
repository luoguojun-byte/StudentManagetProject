package com.luo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
}
