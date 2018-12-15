package ali.keeep.com.vo.domain.func;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @类说明 [菜单]实体类
 * @author 高振中
 * @date 2018-12-13 14:57:59
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder	
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Func", description = "菜单实体")
public class Func {
    // 数据库中的字段
	@ApiModelProperty(value = "主键", dataType = "Integer")
	private Integer func_id; // 主键
	@ApiModelProperty(value = "类型", dataType = "Byte")
	private Byte type; // 类型
	@ApiModelProperty(value = "颜色", dataType = "String")
	private String color; // 颜色
	@ApiModelProperty(value = "图标", dataType = "String")
	private String icon; // 图标
	@ApiModelProperty(value = "名称", dataType = "String")
	private String name; // 名称
	@ApiModelProperty(value = "父结点ID", dataType = "Integer")
	private Integer parent_id; // 父结点ID
	@ApiModelProperty(value = "提示信息", dataType = "String")
	private String tip; // 提示信息
	@ApiModelProperty(value = "备注", dataType = "String")
	private String remark; // 备注
	@ApiModelProperty(value = "状态", dataType = "Byte")
	private Byte status; // 状态
	@ApiModelProperty(value = "地址", dataType = "String")
	private String url; // 地址
	@ApiModelProperty(value = "排序编号", dataType = "Short")
	private Short order_num; // 排序编号
    // 此处可添加查询显示辅助字段
}