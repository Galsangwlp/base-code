package ali.keep.com.system.role;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.role.Role;
import ali.keeep.com.vo.domain.role.RoleCond;
import ali.keep.com.common.PrincipalAction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
/**
 * @类说明 admin_role--前端控制器层
 * @author 高振中
 * @date  2018-12-13 15:27:50
 **/
@RestController
@RequestMapping("api/role")
public class RoleAction extends PrincipalAction {

	@SuppressWarnings("unused")
	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private RoleBus bus; //admin_roleBusiness层

    /**
     * @方法说明  新增[admin_role]记录
     */
	@PostMapping("save")
	public int save(@RequestBody Role role, Principal principal) {
		return bus.save(role);
	}

    /**
     * @方法说明 删除admin_role记录(多条)
     */
	@DeleteMapping("delete")
	public int delete(@RequestParam("ids[]") Integer ids[]) {
		return bus.delete(ids);
	}

    /**
     * @方法说明 修改admin_role记录
     */
	@PostMapping("update")
	public int update(@RequestBody Role role, Principal principal) {
		return bus.update(role); 
	}

    /**
     * @方法说明 按条件查询分页admin_role列表
     */
	@PostMapping("queryPage")
	public Page<Role> queryPage(@RequestBody RoleCond cond, Principal principal){
		//cond.setBranch_id(getDefaultBranchId(principal));
		return bus.queryPage(cond);
	}

    /**
     * @方法说明 按条件查询不分页admin_role列表
     */
    @PostMapping("queryList")
    public List<Role> queryList(@RequestBody RoleCond cond, Principal principal){
        //cond.setBranch_id(getDefaultBranchId(principal));
        return bus.queryList(cond);
    }

    /**
     * @方法说明 按主键查找单个admin_role记录
     */
	@GetMapping("findById")
	public Role findById(@RequestParam("id") Integer id) {
		return bus.findById(id);
	}

    /**
     * @方法说明 按条件查询admin_role记录个数
     */
	@PostMapping("queryCount")
	public long queryCount(@RequestBody RoleCond cond){
		return bus.queryCount(cond);
	}
    
    /**
     * @方法说明  新增[admin_role]记录
     */
    //@PostMapping("validate")
    //public MessageInfo validate(@RequestBody RoleCond cond, Principal principal) {
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