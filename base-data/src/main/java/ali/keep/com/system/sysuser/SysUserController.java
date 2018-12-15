package ali.keep.com.system.sysuser;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.sysuser.User;
import ali.keeep.com.vo.domain.sysuser.SysUserCond;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @类说明 [admin_sys_user]控制器
 * @author 高振中
 * @date 2018-12-13 14:30:27
 **/
@RestController
@RequestMapping("sysUser")
public class SysUserController {

	@SuppressWarnings("unused")
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private SysUserService service; //注入admin_sys_user数据逻辑层

    /**
     * @方法说明  新增[admin_sys_user]记录
     */
	@PostMapping("save")
	public int save(@RequestBody User user) {
		return service.save(user);
	}

    /**
     * @方法说明 删除admin_sys_user记录(多条)
     */
//	@PostMapping("delete")
//	public int delete(@RequestParam("ids[]") Integer ids[]) {
//		return service.delete(ids);
//	}

    /**
     * @方法说明 修改admin_sys_user记录
     */
	@PostMapping("update")
	public int update(@RequestBody User user) {
		return service.update(user);
	}

    /**
     * @方法说明 按条件查询分页admin_sys_user列表
     */
	@PostMapping("queryPage")
	public Page<User> queryPage(@RequestBody SysUserCond cond ){
		return service.queryPage(cond);
	}

    /**
     * @方法说明 按条件查询不分页admin_sys_user列表
     */
	@PostMapping("queryList")
	public List<User> queryList(@RequestBody SysUserCond cond ){
		return service.queryList(cond);
	}

    /**
     * @方法说明 按主键查单个admin_sys_user记录
     */
	@PostMapping("findById")
	public User findById(@RequestParam("id") Integer id) {
		return service.findById(id);
	}

    /**
     * @方法说明 按条件查询admin_sys_user记录个数
     */
	@PostMapping("queryCount")
	public long queryCount(@RequestBody SysUserCond cond ){
		return service.queryCount(cond);
	}
}