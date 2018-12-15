package ali.keep.com.system.dept;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.dept.Dept;
import ali.keeep.com.vo.domain.dept.DeptCond;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @类说明 [admin_dept]业务逻辑层
 * @author 高振中
 * @date 2018-12-13 14:30:27
 **/
@Service
public class DeptService {

	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private DeptDao dao; //注入admin_dept数据访问层

	/**
	 * @方法说明 新增[admin_dept]记录
	 */
	@Transactional
	public int save(Dept dept) {
		return dao.save(dept);
	}

	/**
	 * @方法说明 删除admin_dept记录(多条)
	 */
//	public int delete(Integer ids[]) {
//		//return dao.deleteLogic(ids);//逻辑删除
//		return dao.delete(ids);//物理删除
//	}

	/**
	 * @方法说明 更新admin_dept记录
	 */
	@Transactional
	public int update(Dept dept) {
		return dao.update(dept); 
	}

	/**
	 * @方法说明 按条件查询分页admin_dept列表
	 */
	public Page<Dept> queryPage(DeptCond cond) {
		return dao.queryPage(cond);
	}

	/**
	 * @方法说明  按条件查询不分页admin_dept列表 
	 */
	public List<Dept> queryList(DeptCond cond) {
		return dao.queryList(cond);
	}

	/**
	 * @方法说明 按主键查找单个admin_dept记录
	 */
	public Dept findById(Integer id) {
		return dao.findById(id);
	}

	/**
	 * @方法说明 按条件查询admin_dept记录个数
	 */
	public long queryCount(DeptCond cond) {
		return dao.queryCount(cond);
	}
}