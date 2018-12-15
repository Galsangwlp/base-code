package ali.keep.com.system.dept;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.dept.Dept;
import ali.keeep.com.vo.domain.dept.DeptCond;
import ali.keeep.com.vo.utils.SqlUtil;
import ali.keep.com.common.BaseDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @类说明 [admin_dept]数据访问层
 * @author 高振中
 * @date 2018-12-13 14:30:27
 **/
@Repository
public class DeptDao extends BaseDao {

    private StringBuilder insert = new StringBuilder();
    private StringBuilder select = new StringBuilder();

    /**
     * @方法说明 构造方法-拼加SQL 
     */
    public DeptDao () {
    	select.append("SELECT t.dept_id,t.parent_id,t.name,t.enable,t.remark");
    	select.append(" FROM admin_dept t WHERE 1=1");
		
        insert.append("INSERT INTO admin_dept (parent_id,name,enable,remark) ");
        insert.append(" VALUES (:parent_id,:name,:enable,:remark)");
    }

    /**
     * @方法说明  新增admin_dept记录
     */
    public int save(Dept vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("REPLACE INTO admin_dept (dept_id,parent_id,name,enable,remark)");
        sql.append(" VALUES (?,?,?,?,?)");
        Object[] params ={ vo.getDept_id(),vo.getParent_id(),vo.getName(),vo.getEnable(),vo.getRemark() };
        //logger.info(SqlUtil.showSql(sql.toString(), params));//显示SQL语句
        return jdbcTemplate.update(sql.toString(), params);
    }
    
    /**
     * @方法说明 新增admin_dept记录并返回自增涨主键值
     */
    public long saveReturnPK(Dept vo) {
         return saveKey(vo, insert.toString(), "dept_id");
    }
    
    /**
     * @方法说明 批量插入admin_dept记录
     */
    public int[] insertBatch(List<Dept> list) {
       return batchOperate(list, insert.toString());
    }
    
    /**
     * @方法说明 物理删除admin_dept记录(多条)
     */
//    public int delete(Integer ids[]) {
//        String sql = "DELETE FROM admin_dept WHERE dept_id" + SqlUtil.ArrayToIn(ids);
//        return jdbcTemplate.update(sql);
//    }
    
    /**
     * @方法说明 更新admin_dept记录
     */
    public int update(Dept vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE admin_dept SET parent_id=?,name=?,enable=?,remark=? ");
        sql.append(" WHERE dept_id=? ");
        Object[] params = {vo.getParent_id(),vo.getName(),vo.getEnable(),vo.getRemark(),vo.getDept_id()};
        return jdbcTemplate.update(sql.toString(), params);
      }

    /**
     * @方法说明 按条件查询分页admin_dept列表
     */
    public Page<Dept> queryPage(DeptCond cond) {
        StringBuilder sb = new StringBuilder(select);
        sb.append(cond.getCondition());
        //sb.append(cond.getOrderSql());//增加排序子句;
        //logger.info(SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, Dept.class);
    }
    
    /**
     * @方法说明 按条件查询不分页admin_dept列表
     */
    public List<Dept> queryList(DeptCond cond) {
    	StringBuilder sb = new StringBuilder(select);
    	sb.append(cond.getCondition());
    	//sb.append(" ORDER BY operate_time DESC");
    	return jdbcTemplate.query(sb.toString(), cond.getArray(), new BeanPropertyRowMapper<>(Dept.class));
    }
    
    /**
     * @方法说明 按ID查找单个admin_dept实体
     */
    public Dept findById(Integer id) {
    	StringBuilder sb = new StringBuilder(select);
    	sb.append(" AND t.dept_id=?");
    	return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new BeanPropertyRowMapper<>(Dept.class));
    }
    
    /**
     * @方法说明 按条件查询admin_dept记录个数
     */
    public long queryCount(DeptCond cond) {
    	String countSql = "SELECT COUNT(1) FROM admin_dept t WHERE 1=1" + cond.getCondition();
    	return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
    }
    
//    /**
//     * @方法说明 按条件查询admin_dept记录个数
//     */
//    public int deleteLogic(Integer ids[]) {
//    	String sql = "UPDATE admin_dept SET delete_remark=1 WHERE dept_id" + SqlUtil.ArrayToIn(ids);
//    	return jdbcTemplate.update(sql);
//    }
 
}