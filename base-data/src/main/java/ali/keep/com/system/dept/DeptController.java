package ali.keep.com.system.dept;
import java.util.List;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.dept.Dept;
import ali.keeep.com.vo.domain.dept.DeptCond;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @类说明 [admin_dept]控制器
 * @author 高振中
 * @date 2018-12-13 14:30:27
 **/
@RestController
@RequestMapping("dept")
public class DeptController {

	@SuppressWarnings("unused")
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private DeptService service; //注入admin_dept数据逻辑层

    /**
     * @方法说明  新增[admin_dept]记录
     */
	@PostMapping("save")
	public int save(@RequestBody Dept dept) {
		return service.save(dept);
	}

    /**
     * @方法说明 删除admin_dept记录(多条)
     */
//	@PostMapping("delete")
//	public int delete(@RequestParam("ids[]") Integer ids[]) {
//		return service.delete(ids);
//	}

    /**
     * @方法说明 修改admin_dept记录
     */
	@PostMapping("update")
	public int update(@RequestBody Dept dept) {
		return service.update(dept);
	}

    /**
     * @方法说明 按条件查询分页admin_dept列表
     */
	@PostMapping("queryPage")
	public Page<Dept> queryPage(@RequestBody DeptCond cond ){
		return service.queryPage(cond);
	}

    /**
     * @方法说明 按条件查询不分页admin_dept列表
     */
	@PostMapping("queryList")
	public List<Dept> queryList(@RequestBody DeptCond cond ){
		return service.queryList(cond);
	}

    /**
     * @方法说明 按主键查单个admin_dept记录
     */
	@PostMapping("findById")
	public Dept findById(@RequestParam("id") Integer id) {
		return service.findById(id);
	}

    /**
     * @方法说明 按条件查询admin_dept记录个数
     */
	@PostMapping("queryCount")
	public long queryCount(@RequestBody DeptCond cond ){
		return service.queryCount(cond);
	}
}