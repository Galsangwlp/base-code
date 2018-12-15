package ali.keeep.com.vo.domain.sysuser;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Set;

/**
 * @类说明 [admin_sys_user]实体类
 * @author 高振中
 * @date 2018-12-13 14:30:27
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder	
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "User", description = "admin_sys_user实体")
public class User {
    // 数据库中的字段
	@ApiModelProperty(value = "主键", dataType = "Integer")
	private Integer user_id; // 主键
	@ApiModelProperty(value = "姓名", dataType = "String")
	private String name; // 姓名
	@ApiModelProperty(value = "会员编号", dataType = "String")
	private String password; // 会员编号
	@ApiModelProperty(value = "手机号", dataType = "String")
	private String phone; // 手机号
	@ApiModelProperty(value = "性别", dataType = "Byte")
	private Byte gender; // 性别
	@ApiModelProperty(value = "状态", dataType = "Byte")
	private Byte status; // 状态
	@ApiModelProperty(value = "部门ID", dataType = "Integer")
	private Integer department_id; // 部门ID
	@ApiModelProperty(value = "微信号", dataType = "String")
	private String wechat; // 微信号
	@ApiModelProperty(value = "备注", dataType = "String")
	private String remark; // 备注
    // 此处可添加查询显示辅助字段
	private Set<String> permissions;
}