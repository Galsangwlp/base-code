package ali.keep.com.system.func;
import java.util.List;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.func.Func;
import ali.keeep.com.vo.domain.func.FuncCond;
import ali.keep.com.common.PrincipalAction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
/**
 * @类说明 菜单--前端控制器层
 * @author 高振中
 * @date  2018-12-13 14:57:59
 **/
@RestController
@RequestMapping("api/func")
public class FuncAction extends PrincipalAction {

//	@SuppressWarnings("unused")
//	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private FuncBus bus; //菜单Business层

    /**
     * @方法说明  新增[菜单]记录
     */
	@PostMapping("save")
	public int save(@RequestBody Func func, Principal principal) {
		return bus.save(func);
	}

    /**
     * @方法说明 删除菜单记录(多条)
     */
	@DeleteMapping("delete")
	public int delete(@RequestParam("ids[]") Integer ids[]) {
		return bus.delete(ids);
	}

    /**
     * @方法说明 修改菜单记录
     */
	@PostMapping("update")
	public int update(@RequestBody Func func, Principal principal) {
		return bus.update(func); 
	}

    /**
     * @方法说明 按条件查询分页菜单列表
     */
	@PostMapping("queryPage")
	public Page<Func> queryPage(@RequestBody FuncCond cond, Principal principal){
		//cond.setBranch_id(getDefaultBranchId(principal));
		return bus.queryPage(cond);
	}

    /**
     * @方法说明 按条件查询不分页菜单列表
     */
    @PostMapping("queryList")
    public List<Func> queryList(@RequestBody FuncCond cond, Principal principal){
        //cond.setBranch_id(getDefaultBranchId(principal));
        return bus.queryList(cond);
    }

    /**
     * @方法说明 按主键查找单个菜单记录
     */
	@GetMapping("findById")
	public Func findById(@RequestParam("id") Integer id) {
		return bus.findById(id);
	}

    /**
     * @方法说明 按条件查询菜单记录个数
     */
	@PostMapping("queryCount")
	public long queryCount(@RequestBody FuncCond cond){
		return bus.queryCount(cond);
	}
    
    /**
     * @方法说明  新增[菜单]记录
     */
    //@PostMapping("validate")
    //public MessageInfo validate(@RequestBody FuncCond cond, Principal principal) {
    //MessageInfo mi = new MessageInfo();
    ////此处写验证逻辑
    ////cond.setfield(...)
    ////int count=bus.queryCount(cond)
    ////if(count = 0){
    ////mi.setMessage(1, "记录个数不能为0!\
    ////}
    //return mi;
    //}
}