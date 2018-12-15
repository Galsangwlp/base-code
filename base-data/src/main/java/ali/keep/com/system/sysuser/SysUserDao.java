package ali.keep.com.system.sysuser;

import ali.keeep.com.vo.base.Page;
import ali.keeep.com.vo.domain.sysuser.User;
import ali.keeep.com.vo.domain.sysuser.SysUserCond;
import ali.keep.com.common.BaseDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

 /**
 * @类说明 [admin_sys_user]数据访问层
 * @author 高振中
 * @date 2018-12-13 14:30:27
 **/
@Repository
public class SysUserDao extends BaseDao {

     private StringBuilder insert = new StringBuilder();
    private StringBuilder select = new StringBuilder();

    /**
     * @方法说明 构造方法-拼加SQL 
     */
    public SysUserDao () {
    	select.append("SELECT t.user_id,t.name,t.password,t.phone,t.gender,t.status,t.department_id,t.wechat,t.remark");
    	select.append(" FROM admin_sys_user t WHERE 1=1");
		
        insert.append("INSERT INTO admin_sys_user (name,password,phone,gender,status,department_id,wechat,remark) ");
        insert.append(" VALUES (:name,:password,:phone,:gender,:status,:department_id,:wechat,:remark)");
    }

    /**
     * @方法说明  新增admin_sys_user记录
     */
    public int save(User vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("REPLACE INTO admin_sys_user (user_id,name,password,phone,gender,status,department_id,wechat,remark)");
        sql.append(" VALUES (?,?,?,?,?,?,?,?,?)");
        Object[] params ={ vo.getUser_id(),vo.getName(),vo.getPassword(),vo.getPhone(),vo.getGender(),vo.getStatus(),vo.getDepartment_id(),vo.getWechat(),vo.getRemark() };
        //logger.info(SqlUtil.showSql(sql.toString(), params));//显示SQL语句
        return jdbcTemplate.update(sql.toString(), params);
    }
    
    /**
     * @方法说明 新增admin_sys_user记录并返回自增涨主键值
     */
    public long saveReturnPK(User vo) {
         return saveKey(vo, insert.toString(), "user_id");
    }
    
    /**
     * @方法说明 批量插入admin_sys_user记录
     */
    public int[] insertBatch(List<User> list) {
       return batchOperate(list, insert.toString());
    }
    
//    /**
//     * @方法说明 物理删除admin_sys_user记录(多条)
//     */
//    public int delete(Integer ids[]) {
//        String sql = "DELETE FROM admin_sys_user WHERE user_id" + SqlUtil.ArrayToIn(ids);
//        return jdbcTemplate.update(sql);
//    }
    
    /**
     * @方法说明 更新admin_sys_user记录
     */
    public int update(User vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE admin_sys_user SET name=?,password=?,phone=?,gender=?,status=?,department_id=?,wechat=?,remark=? ");
        sql.append(" WHERE user_id=? ");
        Object[] params = {vo.getName(),vo.getPassword(),vo.getPhone(),vo.getGender(),vo.getStatus(),vo.getDepartment_id(),vo.getWechat(),vo.getRemark(),vo.getUser_id()};
        return jdbcTemplate.update(sql.toString(), params);
      }

    /**
     * @方法说明 按条件查询分页admin_sys_user列表
     */
    public Page<User> queryPage(SysUserCond cond) {
        StringBuilder sb = new StringBuilder(select);
        sb.append(cond.getCondition());
        //sb.append(cond.getOrderSql());//增加排序子句;
        //logger.info(SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, User.class);
    }
    
    /**
     * @方法说明 按条件查询不分页admin_sys_user列表
     */
    public List<User> queryList(SysUserCond cond) {
    	StringBuilder sb = new StringBuilder(select);
    	sb.append(cond.getCondition());
    	//sb.append(" ORDER BY operate_time DESC");
    	return jdbcTemplate.query(sb.toString(), cond.getArray(), new BeanPropertyRowMapper<>(User.class));
    }
    
    /**
     * @方法说明 按ID查找单个admin_sys_user实体
     */
    public User findById(Integer id) {
    	StringBuilder sb = new StringBuilder(select);
    	sb.append(" AND t.user_id=?");
    	return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }
    
    /**
     * @方法说明 按条件查询admin_sys_user记录个数
     */
    public long queryCount(SysUserCond cond) {
    	String countSql = "SELECT COUNT(1) FROM admin_sys_user t WHERE 1=1" + cond.getCondition();
    	return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
    }
    
//    /**
//     * @方法说明 按条件查询admin_sys_user记录个数
//     */
//    public int deleteLogic(Integer ids[]) {
//    	String sql = "UPDATE admin_sys_user SET delete_remark=1 WHERE user_id" + SqlUtil.ArrayToIn(ids);
//    	return jdbcTemplate.update(sql);
//    }
 
}