package ali.keep.com.system.func;
import java.util.List;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.func.Func;
import ali.keeep.com.vo.domain.func.FuncCond;
import ali.keeep.com.vo.utils.SqlUtil;
import ali.keep.com.common.BaseDao;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
/**
 * @类说明 [菜单]数据访问层
 * @author 高振中
 * @date 2018-12-13 14:57:59
 **/
@Repository
public class FuncDao extends BaseDao {

    private StringBuilder insert = new StringBuilder();
    private StringBuilder select = new StringBuilder();

    /**
     * @方法说明 构造方法-拼加SQL 
     */
    public FuncDao () {
    	select.append("SELECT t.func_id,t.type,t.color,t.icon,t.name,t.parent_id,t.tip,t.remark,t.status,t.url,"); 
		select.append("t.order_num");
    	select.append(" FROM admin_func t WHERE 1=1");
		
        insert.append("INSERT INTO admin_func (type,color,icon,name,parent_id,tip,remark,status,url,"); 
		insert.append("order_num) ");
        insert.append(" VALUES (:type,:color,:icon,:name,:parent_id,:tip,:remark,:status,:url,"); 
		insert.append(":order_num)");
    }

    /**
     * @方法说明  新增菜单记录
     */
    public int save(Func vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("REPLACE INTO admin_func (func_id,type,color,icon,name,parent_id,tip,remark,status,url,"); 
		sql.append("order_num)");
        sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?)");
        Object[] params ={ vo.getFunc_id(),vo.getType(),vo.getColor(),vo.getIcon(),vo.getName(),vo.getParent_id(),vo.getTip(),vo.getRemark(),vo.getStatus(),vo.getUrl(),vo.getOrder_num() };
        //logger.info(SqlUtil.showSql(sql.toString(), params));//显示SQL语句
        return jdbcTemplate.update(sql.toString(), params);
    }
    
    /**
     * @方法说明 新增菜单记录并返回自增涨主键值
     */
    public long saveReturnPK(Func vo) {
         return saveKey(vo, insert.toString(), "func_id");
    }
    
    /**
     * @方法说明 批量插入菜单记录
     */
    public int[] insertBatch(List<Func> list) {
       return batchOperate(list, insert.toString());
    }
    
//    /**
//     * @方法说明 物理删除菜单记录(多条)
//     */
//    public int delete(Integer ids[]) {
//        String sql = "DELETE FROM admin_func WHERE func_id" + SqlUtil.ArrayToIn(ids);
//        return jdbcTemplate.update(sql);
//    }
    
    /**
     * @方法说明 更新菜单记录
     */
    public int update(Func vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE admin_func SET type=?,color=?,icon=?,name=?,parent_id=?,tip=?,remark=?,status=?,url=?,"); 
		sql.append("order_num=? ");
        sql.append(" WHERE func_id=? ");
        Object[] params = {vo.getType(),vo.getColor(),vo.getIcon(),vo.getName(),vo.getParent_id(),vo.getTip(),vo.getRemark(),vo.getStatus(),vo.getUrl(),vo.getOrder_num(),vo.getFunc_id()};
        return jdbcTemplate.update(sql.toString(), params);
      }

    /**
     * @方法说明 按条件查询分页菜单列表
     */
    public Page<Func> queryPage(FuncCond cond) {
        StringBuilder sb = new StringBuilder(select);
        sb.append(cond.getCondition());
        //sb.append(cond.getOrderSql());//增加排序子句;
        //logger.info(SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, Func.class);
    }
    
    /**
     * @方法说明 按条件查询不分页菜单列表
     */
    public List<Func> queryList(FuncCond cond) {
    	StringBuilder sb = new StringBuilder(select);
    	sb.append(cond.getCondition());
    	//sb.append(" ORDER BY operate_time DESC");
    	return jdbcTemplate.query(sb.toString(), cond.getArray(), new BeanPropertyRowMapper<>(Func.class));
    }
    
    /**
     * @方法说明 按ID查找单个菜单实体
     */
    public Func findById(Integer id) {
    	StringBuilder sb = new StringBuilder(select);
    	sb.append(" AND t.func_id=?");
    	return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new BeanPropertyRowMapper<>(Func.class));
    }
    
    /**
     * @方法说明 按条件查询菜单记录个数
     */
    public long queryCount(FuncCond cond) {
    	String countSql = "SELECT COUNT(1) FROM admin_func t WHERE 1=1" + cond.getCondition();
    	return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
    }
    
//    /**
//     * @方法说明 按条件查询菜单记录个数
//     */
//    public int deleteLogic(Integer ids[]) {
//    	String sql = "UPDATE admin_func SET delete_remark=1 WHERE func_id" + SqlUtil.ArrayToIn(ids);
//    	return jdbcTemplate.update(sql);
//    }
 
}