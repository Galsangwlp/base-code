package ali.keeep.com.vo.domain.dept;

import ali.keeep.com.vo.base.BaseCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

//import lombok.experimental.Accessors;

/**
 * @类说明 [admin_dept]查询条件实体
 * @author: 高振中
 * @date : 2018-12-13 14:30:27
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "DeptCond", description = "admin_dept查询条件实体")
public class DeptCond extends BaseCondition {

    /**
     * @方法说明: 拼加自定义条件
     **/
    @Override
    public void addCondition() {
		add(dept_id, "AND t.dept_id = ?");
		add(parent_id, "AND t.parent_id = ?");
		add(name, "AND t.name LIKE ?", 3);
		add(enable, "AND t.enable = ?");
		add(remark, "AND t.remark LIKE ?", 3);
    	// add(ids, "AND t.id IN ");
    }
    
    // 查询条件
	@ApiModelProperty(hidden = true)
	private Integer dept_id; // 主键
	@ApiModelProperty(hidden = true)
	private Integer parent_id; // 上级ID
	@ApiModelProperty(hidden = true)
	private String name; // 部门名称
	@ApiModelProperty(hidden = true)
	private Byte enable; // 可用标志
	@ApiModelProperty(hidden = true)
	private String remark; // 备注
	// private List<Long> ids;// 主键列表
}