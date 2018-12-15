package ali.keeep.com.vo.domain.sysuser;

import ali.keeep.com.vo.base.BaseCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

//import lombok.experimental.Accessors;

/**
 * @类说明 [admin_sys_user]查询条件实体
 * @author: 高振中
 * @date : 2018-12-13 14:30:27
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "SysUserCond", description = "admin_sys_user查询条件实体")
public class SysUserCond extends BaseCondition {

    /**
     * @方法说明: 拼加自定义条件
     **/
    @Override
    public void addCondition() {
		add(user_id, "AND t.user_id = ?");
		add(name, "AND t.name LIKE ?", 3);
		add(password, "AND t.password LIKE ?", 3);
		add(phone, "AND t.phone LIKE ?", 3);
		add(gender, "AND t.gender = ?");
		add(status, "AND t.status = ?");
		add(department_id, "AND t.department_id = ?");
		add(wechat, "AND t.wechat LIKE ?", 3);
		add(remark, "AND t.remark LIKE ?", 3);
    	// add(ids, "AND t.id IN ");
    }
    
    // 查询条件
	@ApiModelProperty(hidden = true)
	private Integer user_id; // 主键
	@ApiModelProperty(hidden = true)
	private String name; // 姓名
	@ApiModelProperty(hidden = true)
	private String password; // 会员编号
	@ApiModelProperty(hidden = true)
	private String phone; // 手机号
	@ApiModelProperty(hidden = true)
	private Byte gender; // 性别
	@ApiModelProperty(hidden = true)
	private Byte status; // 状态
	@ApiModelProperty(hidden = true)
	private Integer department_id; // 部门ID
	@ApiModelProperty(hidden = true)
	private String wechat; // 微信号
	@ApiModelProperty(hidden = true)
	private String remark; // 备注
	// private List<Long> ids;// 主键列表
}