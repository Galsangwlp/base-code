package ali.keep.com.system.role;
import java.util.List;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.role.Role;
import ali.keeep.com.vo.domain.role.RoleCond;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @类说明 [admin_role]控制器
 * @author 高振中
 * @date 2018-12-13 14:30:27
 **/
@RestController
@RequestMapping("role")
public class RoleController {

	@SuppressWarnings("unused")
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private RoleService service; //注入admin_role数据逻辑层

    /**
     * @方法说明  新增[admin_role]记录
     */
	@PostMapping("save")
	public int save(@RequestBody Role role) {
		return service.save(role);
	}

    /**
     * @方法说明 删除admin_role记录(多条)
     */
//	@PostMapping("delete")
//	public int delete(@RequestParam("ids[]") Integer ids[]) {
//		return service.delete(ids);
//	}

    /**
     * @方法说明 修改admin_role记录
     */
	@PostMapping("update")
	public int update(@RequestBody Role role) {
		return service.update(role);
	}

    /**
     * @方法说明 按条件查询分页admin_role列表
     */
	@PostMapping("queryPage")
	public Page<Role> queryPage(@RequestBody RoleCond cond ){
		return service.queryPage(cond);
	}

    /**
     * @方法说明 按条件查询不分页admin_role列表
     */
	@PostMapping("queryList")
	public List<Role> queryList(@RequestBody RoleCond cond ){
		return service.queryList(cond);
	}

    /**
     * @方法说明 按主键查单个admin_role记录
     */
	@PostMapping("findById")
	public Role findById(@RequestParam("id") Integer id) {
		return service.findById(id);
	}

    /**
     * @方法说明 按条件查询admin_role记录个数
     */
	@PostMapping("queryCount")
	public long queryCount(@RequestBody RoleCond cond ){
		return service.queryCount(cond);
	}
}