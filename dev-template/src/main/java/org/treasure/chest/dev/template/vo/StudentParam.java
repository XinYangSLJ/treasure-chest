package org.treasure.chest.dev.template.vo;

import lombok.Data;
import org.treasure.chest.dev.template.common.constant.RegularConstants;


import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2022-06-14 18:33
 */
@Data
public class StudentParam {

    @NotBlank(message = "姓名不能为空")
    private String name;

    @Pattern(regexp = RegularConstants.PHONE_NUMBER.REG, message = RegularConstants.PHONE_NUMBER.DESC)
    private String phoneNumber;

    @NotEmpty(message = "学科不能为空")
    private List<String> subjects;

    @Max(value = 35, message = "年龄不得超过35岁")
    private Integer ege;
}
