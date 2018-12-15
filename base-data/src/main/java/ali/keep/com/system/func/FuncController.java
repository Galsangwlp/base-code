package ali.keep.com.system.func;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.func.Func;
import ali.keeep.com.vo.domain.func.FuncCond;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @类说明 [菜单]控制器
 * @author 高振中
 * @date 2018-12-13 14:57:59
 **/
@RestController
@RequestMapping("func")
public class FuncController {

	@SuppressWarnings("unused")
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private FuncService service; //注入菜单数据逻辑层

    /**
     * @方法说明  新增[菜单]记录
     */
	@PostMapping("save")
	public int save(@RequestBody Func func) {
		return service.save(func);
	}

    /**
     * @方法说明 删除菜单记录(多条)
     */
//	@PostMapping("delete")
//	public int delete(@RequestParam("ids[]") Integer ids[]) {
//		return service.delete(ids);
//	}

    /**
     * @方法说明 修改菜单记录
     */
	@PostMapping("update")
	public int update(@RequestBody Func func) {
		return service.update(func);
	}

    /**
     * @方法说明 按条件查询分页菜单列表
     */
	@PostMapping("queryPage")
	public Page<Func> queryPage(@RequestBody FuncCond cond ){
		return service.queryPage(cond);
	}

    /**
     * @方法说明 按条件查询不分页菜单列表
     */
	@PostMapping("queryList")
	public List<Func> queryList(@RequestBody FuncCond cond ){
		return service.queryList(cond);
	}

    /**
     * @方法说明 按主键查单个菜单记录
     */
	@PostMapping("findById")
	public Func findById(@RequestParam("id") Integer id) {
		return service.findById(id);
	}

    /**
     * @方法说明 按条件查询菜单记录个数
     */
	@PostMapping("queryCount")
	public long queryCount(@RequestBody FuncCond cond ){
		return service.queryCount(cond);
	}
}