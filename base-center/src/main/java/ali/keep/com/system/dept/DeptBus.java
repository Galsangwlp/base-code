package ali.keep.com.system.dept;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.dept.Dept;
import ali.keeep.com.vo.domain.dept.DeptCond;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
/**
 * @类说明 admin_dept--业务逻辑层
 * @author 高振中
 * @date  2018-12-13 15:27:50
 **/
@Service
public class DeptBus {

	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(getClass());

	@Autowired
	private IDeptClient client; //注入admin_dept客户端类

	/**
	 * @方法说明  新增[admin_dept]记录
	 */
	public int save(Dept dept) {
		return client.save(dept);
	}

	/**
	 * @方法说明  删除admin_dept记录(多条)
	 */
	public int delete(Integer ids[]) {
		return client.delete(ids);//物理删除
	}

	/**
	 * @方法说明  更新admin_dept记录
	 */
	public int update(Dept dept) {
		return client.update(dept);
	}

	/**
	 * @方法说明  按条件查询分页admin_dept列表
	 */
	public Page<Dept> queryPage(DeptCond cond) {
		return client.queryPage(cond);
	}

	/**
	 * @方法说明  按条件查询不分页admin_dept列表
	 */
	public List<Dept> queryList(DeptCond cond) {
		return client.queryList(cond);
	}

	/**
	 * @方法说明 按条件查询admin_dept记录个数
	 */
	public long queryCount(DeptCond cond) {
		return client.queryCount(cond);
	}

	/**
	 * @方法说明按主键查找单个admin_dept记录
	 */
	public Dept findById(Integer id) {
		return client.findById(id);
	}

}