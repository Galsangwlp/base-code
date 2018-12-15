package ali.keep.com.system.func;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.func.Func;
import ali.keeep.com.vo.domain.func.FuncCond;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @类说明 [菜单]业务逻辑层
 * @author 高振中
 * @date 2018-12-13 14:57:59
 **/
@Service
public class FuncService {

	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private FuncDao dao; //注入菜单数据访问层

	/**
	 * @方法说明 新增[菜单]记录
	 */
	@Transactional
	public int save(Func func) {
		return dao.save(func);
	}
//
//	/**
//	 * @方法说明 删除菜单记录(多条)
//	 */
//	public int delete(Integer ids[]) {
//		//return dao.deleteLogic(ids);//逻辑删除
//		return dao.delete(ids);//物理删除
//	}

	/**
	 * @方法说明 更新菜单记录
	 */
	@Transactional
	public int update(Func func) {
		return dao.update(func); 
	}

	/**
	 * @方法说明 按条件查询分页菜单列表
	 */
	public Page<Func> queryPage(FuncCond cond) {
		return dao.queryPage(cond);
	}

	/**
	 * @方法说明  按条件查询不分页菜单列表 
	 */
	public List<Func> queryList(FuncCond cond) {
		return dao.queryList(cond);
	}

	/**
	 * @方法说明 按主键查找单个菜单记录
	 */
	public Func findById(Integer id) {
		return dao.findById(id);
	}

	/**
	 * @方法说明 按条件查询菜单记录个数
	 */
	public long queryCount(FuncCond cond) {
		return dao.queryCount(cond);
	}
}