package ali.keep.com.system.role;
import java.util.List;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.role.Role;
import ali.keeep.com.vo.domain.role.RoleCond;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @类说明 admin_role--客户端类
 * @author 高振中
 * @date  2018-12-13 15:27:50
 **/
@FeignClient("dl-keep-base-data/role")
public interface IRoleClient {

    /**
     * @方法说明  新增[admin_role]记录
     */
	@PostMapping("save")
	int save(@RequestBody Role role);

    /**
     * @方法说明  删除admin_role记录(多条)
     */
	@PostMapping("delete")
	int delete(@RequestParam("ids[]") Integer ids[]);

    /**
     * @方法说明  修改admin_role记录
     */
	@PostMapping("update")
	int update(@RequestBody Role role);

    /**
     * @方法说明  按条件查询分页admin_role列表
     */
	@PostMapping("queryPage")
	Page<Role> queryPage(@RequestBody RoleCond cond);

    /**
     * @方法说明  按条件查询不分页admin_role列表
     */
	@PostMapping("queryList")
	List<Role> queryList(@RequestBody RoleCond cond);

    /**
     * @方法说明  按主键查单个admin_role记录
     */
	@PostMapping("findById")
	Role findById(@RequestParam("id") Integer id);

    /**
     * @方法说明  按条件查询admin_role记录个数
     */
	@PostMapping("queryCount")
	long queryCount(@RequestBody RoleCond cond);

    /**
     * @方法说明  按条件查询分页admin_role列表
     */
    //@PostMapping("queryPage")
    //String queryPageString(@RequestBody RoleCond cond );

    /**
     * @方法说明  按条件查询不分页admin_role列表
     */
    //@PostMapping("queryList")
    //String queryListString(@RequestBody RoleCond cond );

    /**
     * @方法说明  按主键查单个admin_role记录
     */
    //@PostMapping("findById")
    //String findByIdString(@RequestParam("id") Integer id);

}