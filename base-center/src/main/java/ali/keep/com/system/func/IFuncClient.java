package ali.keep.com.system.func;
import java.util.List;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.func.Func;
import ali.keeep.com.vo.domain.func.FuncCond;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @类说明 菜单--客户端类
 * @author 高振中
 * @date  2018-12-13 14:57:59
 **/
@FeignClient("dl-keep-base-data/func")
public interface IFuncClient {

    /**
     * @方法说明  新增[菜单]记录
     */
	@PostMapping("save")
	int save(@RequestBody Func func);

    /**
     * @方法说明  删除菜单记录(多条)
     */
	@PostMapping("delete")
	int delete(@RequestParam("ids[]") Integer ids[]);

    /**
     * @方法说明  修改菜单记录
     */
	@PostMapping("update")
	int update(@RequestBody Func func);

    /**
     * @方法说明  按条件查询分页菜单列表
     */
	@PostMapping("queryPage")
	Page<Func> queryPage(@RequestBody FuncCond cond);

    /**
     * @方法说明  按条件查询不分页菜单列表
     */
	@PostMapping("queryList")
	List<Func> queryList(@RequestBody FuncCond cond);

    /**
     * @方法说明  按主键查单个菜单记录
     */
	@PostMapping("findById")
	Func findById(@RequestParam("id") Integer id);

    /**
     * @方法说明  按条件查询菜单记录个数
     */
	@PostMapping("queryCount")
	long queryCount(@RequestBody FuncCond cond);

    /**
     * @方法说明  按条件查询分页菜单列表
     */
    //@PostMapping("queryPage")
    //String queryPageString(@RequestBody FuncCond cond );

    /**
     * @方法说明  按条件查询不分页菜单列表
     */
    //@PostMapping("queryList")
    //String queryListString(@RequestBody FuncCond cond );

    /**
     * @方法说明  按主键查单个菜单记录
     */
    //@PostMapping("findById")
    //String findByIdString(@RequestParam("id") Integer id);

}