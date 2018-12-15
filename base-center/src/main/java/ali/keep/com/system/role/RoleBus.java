package ali.keep.com.system.role;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.role.Role;
import ali.keeep.com.vo.domain.role.RoleCond;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @类说明 admin_role--业务逻辑层
 * @author 高振中
 * @date  2018-12-13 15:27:50
 **/
@Service
public class RoleBus {

	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(getClass());

	@Autowired
	private IRoleClient client; //注入admin_role客户端类

	/**
	 * @方法说明  新增[admin_role]记录
	 */
	public int save(Role role) {
		return client.save(role);
	}

	/**
	 * @方法说明  删除admin_role记录(多条)
	 */
	public int delete(Integer ids[]) {
		return client.delete(ids);//物理删除
	}

	/**
	 * @方法说明  更新admin_role记录
	 */
	public int update(Role role) {
		return client.update(role);
	}

	/**
	 * @方法说明  按条件查询分页admin_role列表
	 */
	public Page<Role> queryPage(RoleCond cond) {
		return client.queryPage(cond);
	}

	/**
	 * @方法说明  按条件查询不分页admin_role列表
	 */
	public List<Role> queryList(RoleCond cond) {
		return client.queryList(cond);
	}

	/**
	 * @方法说明 按条件查询admin_role记录个数
	 */
	public long queryCount(RoleCond cond) {
		return client.queryCount(cond);
	}

	/**
	 * @方法说明按主键查找单个admin_role记录
	 */
	public Role findById(Integer id) {
		return client.findById(id);
	}

}