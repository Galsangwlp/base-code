package ali.keep.com.system.role;
import java.util.List;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.role.Role;
import ali.keeep.com.vo.domain.role.RoleCond;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @类说明 [admin_role]业务逻辑层
 * @author 高振中
 * @date 2018-12-13 14:30:27
 **/
@Service
public class RoleService {

	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private RoleDao dao; //注入admin_role数据访问层

	/**
	 * @方法说明 新增[admin_role]记录
	 */
	@Transactional
	public int save(Role role) {
		return dao.save(role);
	}

//	/**
//	 * @方法说明 删除admin_role记录(多条)
//	 */
//	public int delete(Integer ids[]) {
//		//return dao.deleteLogic(ids);//逻辑删除
//		return dao.delete(ids);//物理删除
//	}

	/**
	 * @方法说明 更新admin_role记录
	 */
	@Transactional
	public int update(Role role) {
		return dao.update(role); 
	}

	/**
	 * @方法说明 按条件查询分页admin_role列表
	 */
	public Page<Role> queryPage(RoleCond cond) {
		return dao.queryPage(cond);
	}

	/**
	 * @方法说明  按条件查询不分页admin_role列表 
	 */
	public List<Role> queryList(RoleCond cond) {
		return dao.queryList(cond);
	}

	/**
	 * @方法说明 按主键查找单个admin_role记录
	 */
	public Role findById(Integer id) {
		return dao.findById(id);
	}

	/**
	 * @方法说明 按条件查询admin_role记录个数
	 */
	public long queryCount(RoleCond cond) {
		return dao.queryCount(cond);
	}
}