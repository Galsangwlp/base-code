package ali.keep.com.system.dept;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.dept.Dept;
import ali.keeep.com.vo.domain.dept.DeptCond;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * @类说明 admin_dept--客户端类
 * @author 高振中
 * @date  2018-12-13 15:27:50
 **/
@FeignClient("dl-keep-base-data/dept")
public interface IDeptClient {

    /**
     * @方法说明  新增[admin_dept]记录
     */
	@PostMapping("save")
	int save(@RequestBody Dept dept);

    /**
     * @方法说明  删除admin_dept记录(多条)
     */
	@PostMapping("delete")
	int delete(@RequestParam("ids[]") Integer ids[]);

    /**
     * @方法说明  修改admin_dept记录
     */
	@PostMapping("update")
	int update(@RequestBody Dept dept);

    /**
     * @方法说明  按条件查询分页admin_dept列表
     */
	@PostMapping("queryPage")
	Page<Dept> queryPage(@RequestBody DeptCond cond);

    /**
     * @方法说明  按条件查询不分页admin_dept列表
     */
	@PostMapping("queryList")
	List<Dept> queryList(@RequestBody DeptCond cond);

    /**
     * @方法说明  按主键查单个admin_dept记录
     */
	@PostMapping("findById")
	Dept findById(@RequestParam("id") Integer id);

    /**
     * @方法说明  按条件查询admin_dept记录个数
     */
	@PostMapping("queryCount")
	long queryCount(@RequestBody DeptCond cond);

    /**
     * @方法说明  按条件查询分页admin_dept列表
     */
    //@PostMapping("queryPage")
    //String queryPageString(@RequestBody DeptCond cond );

    /**
     * @方法说明  按条件查询不分页admin_dept列表
     */
    //@PostMapping("queryList")
    //String queryListString(@RequestBody DeptCond cond );

    /**
     * @方法说明  按主键查单个admin_dept记录
     */
    //@PostMapping("findById")
    //String findByIdString(@RequestParam("id") Integer id);

}