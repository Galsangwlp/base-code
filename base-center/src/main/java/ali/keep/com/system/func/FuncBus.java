package ali.keep.com.system.func;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.func.Func;
import ali.keeep.com.vo.domain.func.FuncCond;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @类说明 菜单--业务逻辑层
 * @author 高振中
 * @date  2018-12-13 14:57:59
 **/
@Service
public class FuncBus {

	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(getClass());

	@Autowired
	private IFuncClient client; //注入菜单客户端类

	/**
	 * @方法说明  新增[菜单]记录
	 */
	public int save(Func func) {
		return client.save(func);
	}

	/**
	 * @方法说明  删除菜单记录(多条)
	 */
	public int delete(Integer ids[]) {
		return client.delete(ids);//物理删除
	}

	/**
	 * @方法说明  更新菜单记录
	 */
	public int update(Func func) {
		return client.update(func);
	}

	/**
	 * @方法说明  按条件查询分页菜单列表
	 */
	public Page<Func> queryPage(FuncCond cond) {
		return client.queryPage(cond);
	}

	/**
	 * @方法说明  按条件查询不分页菜单列表
	 */
	public List<Func> queryList(FuncCond cond) {
		return client.queryList(cond);
	}

	/**
	 * @方法说明 按条件查询菜单记录个数
	 */
	public long queryCount(FuncCond cond) {
		return client.queryCount(cond);
	}

	/**
	 * @方法说明按主键查找单个菜单记录
	 */
	public Func findById(Integer id) {
		return client.findById(id);
	}
}