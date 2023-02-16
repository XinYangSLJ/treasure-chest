package org.treasure.chest.dev.template.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
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
 * @createTime 2023-02-16 15:03
 */
@Data
public class TeacherParam {

    @NotBlank(message = "姓名不能为空")
    private String name;

    @Pattern(regexp = RegularConstants.PHONE_NUMBER.REG, message = RegularConstants.PHONE_NUMBER.DESC)
    private String phoneNumber;

    @NotEmpty(message = "学科不能为空")
    private List<String> subjects;

    @Max(value = 35, message = "年龄不得超过35岁")
    private Integer ege;

//    private List<MultipartFile> photoList;

    private MultipartFile photo;
}
