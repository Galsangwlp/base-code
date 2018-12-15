package ali.keeep.com.vo.domain.role;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @类说明 [admin_role]实体类
 * @author 高振中
 * @date 2018-12-13 14:30:27
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder	
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Role", description = "admin_role实体")
public class Role {
    // 数据库中的字段
	@ApiModelProperty(value = "主键", dataType = "Integer")
	private Integer id; // 主键
	@ApiModelProperty(value = "名称", dataType = "String")
	private String name; // 名称
	@ApiModelProperty(value = "备注", dataType = "String")
	private String remark; // 备注
    // 此处可添加查询显示辅助字段
}