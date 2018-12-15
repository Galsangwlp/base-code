package ali.keeep.com.vo.domain.dept;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @类说明 [admin_dept]实体类
 * @author 高振中
 * @date 2018-12-13 14:30:27
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder	
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Dept", description = "admin_dept实体")
public class Dept {
    // 数据库中的字段
	@ApiModelProperty(value = "主键", dataType = "Integer")
	private Integer dept_id; // 主键
	@ApiModelProperty(value = "上级ID", dataType = "Integer")
	private Integer parent_id; // 上级ID
	@ApiModelProperty(value = "部门名称", dataType = "String")
	private String name; // 部门名称
	@ApiModelProperty(value = "可用标志", dataType = "Byte")
	private Byte enable; // 可用标志
	@ApiModelProperty(value = "备注", dataType = "String")
	private String remark; // 备注
    // 此处可添加查询显示辅助字段
}