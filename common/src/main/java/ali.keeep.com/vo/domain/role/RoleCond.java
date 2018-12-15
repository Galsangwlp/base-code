package ali.keeep.com.vo.domain.role;

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
 * @类说明 [admin_role]查询条件实体
 * @author: 高振中
 * @date : 2018-12-13 14:30:27
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "RoleCond", description = "admin_role查询条件实体")
public class RoleCond extends BaseCondition {

    /**
     * @方法说明: 拼加自定义条件
     **/
    @Override
    public void addCondition() {
		add(id, "AND t.id = ?");
		add(name, "AND t.name LIKE ?", 3);
		add(remark, "AND t.remark LIKE ?", 3);
    	// add(ids, "AND t.id IN ");
    }
    
    // 查询条件
	@ApiModelProperty(hidden = true)
	private Integer id; // 主键
	@ApiModelProperty(hidden = true)
	private String name; // 名称
	@ApiModelProperty(hidden = true)
	private String remark; // 备注
	// private List<Long> ids;// 主键列表
}