package ali.keep.com.system.sysuser;
import java.util.List;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.sysuser.SysUserCond;
import ali.keeep.com.vo.domain.sysuser.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @类说明 admin_sys_user--客户端类
 * @author 高振中
 * @date  2018-12-13 15:27:50
 **/
@FeignClient("dl-keep-base-data/sysUser")
public interface ISysUserClient {

    /**
     * @方法说明  新增[admin_sys_user]记录
     */
	@PostMapping("save")
	int save(@RequestBody User sysUser);

    /**
     * @方法说明  删除admin_sys_user记录(多条)
     */
	@PostMapping("delete")
	int delete(@RequestParam("ids[]") Integer ids[]);

    /**
     * @方法说明  修改admin_sys_user记录
     */
	@PostMapping("update")
	int update(@RequestBody User sysUser);

    /**
     * @方法说明  按条件查询分页admin_sys_user列表
     */
	@PostMapping("queryPage")
	Page<User> queryPage(@RequestBody SysUserCond cond);

    /**
     * @方法说明  按条件查询不分页admin_sys_user列表
     */
	@PostMapping("queryList")
	List<User> queryList(@RequestBody SysUserCond cond);

    /**
     * @方法说明  按主键查单个admin_sys_user记录
     */
	@PostMapping("findById")
	User findById(@RequestParam("id") Integer id);

    /**
     * @方法说明  按条件查询admin_sys_user记录个数
     */
	@PostMapping("queryCount")
	long queryCount(@RequestBody SysUserCond cond);

    /**
     * @方法说明  按条件查询分页admin_sys_user列表
     */
    //@PostMapping("queryPage")
    //String queryPageString(@RequestBody SysUserCond cond );

    /**
     * @方法说明  按条件查询不分页admin_sys_user列表
     */
    //@PostMapping("queryList")
    //String queryListString(@RequestBody SysUserCond cond );

    /**
     * @方法说明  按主键查单个admin_sys_user记录
     */
    //@PostMapping("findById")
    //String findByIdString(@RequestParam("id") Integer id);

}