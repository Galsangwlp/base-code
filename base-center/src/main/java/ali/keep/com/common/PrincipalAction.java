package ali.keep.com.common;

import ali.keeep.com.vo.domain.sysuser.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

public class PrincipalAction {

	protected User getUser() {
		return (User) SecurityUtils.getSubject().getPrincipal();
	}

	protected Integer  getUserId() {
		return getUser().getUser_id();
	}
}
