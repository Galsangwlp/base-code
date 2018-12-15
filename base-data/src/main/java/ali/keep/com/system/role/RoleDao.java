package ali.keep.com.system.role;
import java.util.List;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.role.Role;
import ali.keeep.com.vo.domain.role.RoleCond;
import ali.keeep.com.vo.utils.SqlUtil;
import ali.keep.com.common.BaseDao;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
/**
 * @类说明 [admin_role]数据访问层
 * @author 高振中
 * @date 2018-12-13 14:30:27
 **/
@Repository
public class RoleDao extends BaseDao {

    private StringBuilder insert = new StringBuilder();
    private StringBuilder select = new StringBuilder();

    /**
     * @方法说明 构造方法-拼加SQL 
     */
    public RoleDao () {
    	select.append("SELECT t.id,t.name,t.remark");
    	select.append(" FROM admin_role t WHERE 1=1");
		
        insert.append("INSERT INTO admin_role (name,remark) ");
        insert.append(" VALUES (:name,:remark)");
    }

    /**
     * @方法说明  新增admin_role记录
     */
    public int save(Role vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("REPLACE INTO admin_role (id,name,remark)");
        sql.append(" VALUES (?,?,?)");
        Object[] params ={ vo.getId(),vo.getName(),vo.getRemark() };
        //logger.info(SqlUtil.showSql(sql.toString(), params));//显示SQL语句
        return jdbcTemplate.update(sql.toString(), params);
    }
    
    /**
     * @方法说明 新增admin_role记录并返回自增涨主键值
     */
    public long saveReturnPK(Role vo) {
         return saveKey(vo, insert.toString(), "id");
    }
    
    /**
     * @方法说明 批量插入admin_role记录
     */
    public int[] insertBatch(List<Role> list) {
       return batchOperate(list, insert.toString());
    }
    
//    /**
//     * @方法说明 物理删除admin_role记录(多条)
//     */
//    public int delete(Integer ids[]) {
//        String sql = "DELETE FROM admin_role WHERE id" + SqlUtil.ArrayToIn(ids);
//        return jdbcTemplate.update(sql);
//    }
    
    /**
     * @方法说明 更新admin_role记录
     */
    public int update(Role vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE admin_role SET name=?,remark=? ");
        sql.append(" WHERE id=? ");
        Object[] params = {vo.getName(),vo.getRemark(),vo.getId()};
        return jdbcTemplate.update(sql.toString(), params);
      }

    /**
     * @方法说明 按条件查询分页admin_role列表
     */
    public Page<Role> queryPage(RoleCond cond) {
        StringBuilder sb = new StringBuilder(select);
        sb.append(cond.getCondition());
        //sb.append(cond.getOrderSql());//增加排序子句;
        //logger.info(SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, Role.class);
    }
    
    /**
     * @方法说明 按条件查询不分页admin_role列表
     */
    public List<Role> queryList(RoleCond cond) {
    	StringBuilder sb = new StringBuilder(select);
    	sb.append(cond.getCondition());
    	//sb.append(" ORDER BY operate_time DESC");
    	return jdbcTemplate.query(sb.toString(), cond.getArray(), new BeanPropertyRowMapper<>(Role.class));
    }
    
    /**
     * @方法说明 按ID查找单个admin_role实体
     */
    public Role findById(Integer id) {
    	StringBuilder sb = new StringBuilder(select);
    	sb.append(" AND t.id=?");
    	return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new BeanPropertyRowMapper<>(Role.class));
    }
    
    /**
     * @方法说明 按条件查询admin_role记录个数
     */
    public long queryCount(RoleCond cond) {
    	String countSql = "SELECT COUNT(1) FROM admin_role t WHERE 1=1" + cond.getCondition();
    	return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
    }
    
//    /**
//     * @方法说明 按条件查询admin_role记录个数
//     */
//    public int deleteLogic(Integer ids[]) {
//    	String sql = "UPDATE admin_role SET delete_remark=1 WHERE id" + SqlUtil.ArrayToIn(ids);
//    	return jdbcTemplate.update(sql);
//    }
 
}