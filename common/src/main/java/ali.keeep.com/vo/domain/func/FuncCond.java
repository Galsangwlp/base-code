package ali.keeep.com.vo.domain.func;

import ali.keeep.com.vo.base.BaseCondition;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import static com.sun.javafx.fxml.expression.Expression.add;

/**
 * @类说明 [菜单]查询条件实体
 * @author: 高振中
 * @date : 2018-12-13 14:57:59
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "FuncCond", description = "菜单查询条件实体")
public class FuncCond extends BaseCondition {

    /**
     * @方法说明: 拼加自定义条件
     **/
    @Override
    public void addCondition() {
		add(func_id, "AND t.func_id = ?");
		add(type, "AND t.type = ?");
		add(color, "AND t.color LIKE ?", 3);
		add(icon, "AND t.icon LIKE ?", 3);
		add(name, "AND t.name LIKE ?", 3);
		add(parent_id, "AND t.parent_id = ?");
		add(tip, "AND t.tip LIKE ?", 3);
		add(remark, "AND t.remark LIKE ?", 3);
		add(status, "AND t.status = ?");
		add(url, "AND t.url LIKE ?", 3);
		add(order_num, "AND t.order_num = ?");
    	// add(ids, "AND t.id IN ");
    }
    
    // 查询条件
	@ApiModelProperty(hidden = true)
	private Integer func_id; // 主键
	@ApiModelProperty(hidden = true)
	private Byte type; // 类型
	@ApiModelProperty(hidden = true)
	private String color; // 颜色
	@ApiModelProperty(hidden = true)
	private String icon; // 图标
	@ApiModelProperty(hidden = true)
	private String name; // 名称
	@ApiModelProperty(hidden = true)
	private Integer parent_id; // 父结点ID
	@ApiModelProperty(hidden = true)
	private String tip; // 提示信息
	@ApiModelProperty(hidden = true)
	private String remark; // 备注
	@ApiModelProperty(hidden = true)
	private Byte status; // 状态
	@ApiModelProperty(hidden = true)
	private String url; // 地址
	@ApiModelProperty(hidden = true)
	private Short order_num; // 排序编号
	// private List<Long> ids;// 主键列表
}