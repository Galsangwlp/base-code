package ali.keep.com.system.sysuser;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.sysuser.SysUserCond;
import ali.keeep.com.vo.domain.sysuser.User;
import ali.keep.com.common.PrincipalAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
/**
 * @类说明 admin_sys_user--前端控制器层
 * @author 高振中
 * @date  2018-12-13 15:27:50
 **/
@RestController
@RequestMapping("api/sysUser")
public class SysUserAction extends PrincipalAction {

	@SuppressWarnings("unused")
//	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private SysUserBus bus; //admin_sys_userBusiness层

    /**
     * @方法说明  新增[admin_sys_user]记录
     */
	@PostMapping("save")
	public int save(@RequestBody User sysUser, Principal principal) {
		return bus.save(sysUser);
	}

    /**
     * @方法说明 删除admin_sys_user记录(多条)
     */
	@DeleteMapping("delete")
	public int delete(@RequestParam("ids[]") Integer ids[]) {
		return bus.delete(ids);
	}

    /**
     * @方法说明 修改admin_sys_user记录
     */
	@PostMapping("update")
	public int update(@RequestBody User sysUser, Principal principal) {
		return bus.update(sysUser); 
	}

    /**
     * @方法说明 按条件查询分页admin_sys_user列表
     */
	@PostMapping("queryPage")
	public Page<User> queryPage(@RequestBody SysUserCond cond, Principal principal){
		//cond.setBranch_id(getDefaultBranchId(principal));
		return bus.queryPage(cond);
	}

    /**
     * @方法说明 按条件查询不分页admin_sys_user列表
     */
    @PostMapping("queryList")
    public List<User> queryList(@RequestBody SysUserCond cond, Principal principal){
        //cond.setBranch_id(getDefaultBranchId(principal));
        return bus.queryList(cond);
    }

    /**
     * @方法说明 按主键查找单个admin_sys_user记录
     */
	@GetMapping("findById")
	public User findById(@RequestParam("id") Integer id) {
		return bus.findById(id);
	}

    /**
     * @方法说明 按条件查询admin_sys_user记录个数
     */
	@PostMapping("queryCount")
	public long queryCount(@RequestBody SysUserCond cond){
		return bus.queryCount(cond);
	}
    
    /**
     * @方法说明  新增[admin_sys_user]记录
     */
    //@PostMapping("validate")
    //public MessageInfo validate(@RequestBody SysUserCond cond, Principal principal) {
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