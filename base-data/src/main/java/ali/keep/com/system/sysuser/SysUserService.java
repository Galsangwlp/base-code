package ali.keep.com.system.sysuser;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.sysuser.User;
import ali.keeep.com.vo.domain.sysuser.SysUserCond;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @类说明 [admin_sys_user]业务逻辑层
 * @author 高振中
 * @date 2018-12-13 14:30:27
 **/
@Service
public class SysUserService {

	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private SysUserDao dao; //注入admin_sys_user数据访问层

	/**
	 * @方法说明 新增[admin_sys_user]记录
	 */
	@Transactional
	public int save(User user) {
		return dao.save(user);
	}

	/**
	 * @方法说明 删除admin_sys_user记录(多条)
	 */
//	public int delete(Integer ids[]) {
//		return dao.deleteLogic(ids);//逻辑删除
//		return dao.delete(ids);//物理删除
//	}

	/**
	 * @方法说明 更新admin_sys_user记录
	 */
	@Transactional
	public int update(User user) {
		return dao.update(user);
	}

	/**
	 * @方法说明 按条件查询分页admin_sys_user列表
	 */
	public Page<User> queryPage(SysUserCond cond) {
		return dao.queryPage(cond);
	}

	/**
	 * @方法说明  按条件查询不分页admin_sys_user列表 
	 */
	public List<User> queryList(SysUserCond cond) {
		return dao.queryList(cond);
	}

	/**
	 * @方法说明 按主键查找单个admin_sys_user记录
	 */
	public User findById(Integer id) {
		return dao.findById(id);
	}

	/**
	 * @方法说明 按条件查询admin_sys_user记录个数
	 */
	public long queryCount(SysUserCond cond) {
		return dao.queryCount(cond);
	}
}