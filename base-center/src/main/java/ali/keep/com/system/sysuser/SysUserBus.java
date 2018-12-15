package ali.keep.com.system.sysuser;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.sysuser.SysUserCond;
import ali.keeep.com.vo.domain.sysuser.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @类说明 admin_sys_user--业务逻辑层
 * @author 高振中
 * @date  2018-12-13 15:27:50
 **/
@Service
public class SysUserBus {

	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(getClass());

	@Autowired
	private ISysUserClient client; //注入admin_sys_user客户端类

	/**
	 * @方法说明  新增[admin_sys_user]记录
	 */
	public int save(User sysUser) {
		return client.save(sysUser);
	}

	/**
	 * @方法说明  删除admin_sys_user记录(多条)
	 */
	public int delete(Integer ids[]) {
		return client.delete(ids);//物理删除
	}

	/**
	 * @方法说明  更新admin_sys_user记录
	 */
	public int update(User sysUser) {
		return client.update(sysUser);
	}

	/**
	 * @方法说明  按条件查询分页admin_sys_user列表
	 */
	public Page<User> queryPage(SysUserCond cond) {
		return client.queryPage(cond);
	}

	/**
	 * @方法说明  按条件查询不分页admin_sys_user列表
	 */
	public List<User> queryList(SysUserCond cond) {
		return client.queryList(cond);
	}

	/**
	 * @方法说明 按条件查询admin_sys_user记录个数
	 */
	public long queryCount(SysUserCond cond) {
		return client.queryCount(cond);
	}

	/**
	 * @方法说明按主键查找单个admin_sys_user记录
	 */
	public User findById(Integer id) {
		return client.findById(id);
	}

}