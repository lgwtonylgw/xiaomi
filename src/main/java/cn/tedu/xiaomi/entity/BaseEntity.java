package cn.tedu.xiaomi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类的基类
 * 
 * @author 535160909
 *
 */
// 不直接new的就应该是抽象类
public abstract class BaseEntity implements Serializable {
	/**
	 * 不仅仅是抽象类，还继承序列化接口 Serializable标识作用，下面序列化id代表方案 封装值得类都需要实现序列化借口，这些都是描述属性用
	 * （数据克隆，移动，都不用我们做，tomcat会帮我们处理，描述属性用借口，其他业务层什么的不用）
	 */
	private static final long serialVersionUID = -4006824984031415365L;
	private String createdUser;
	private Date createdTime;
	private String modifiedUser;
	private Date modifiedTime;

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "BaseEntity [createdUser=" + createdUser + ", createdTime=" + createdTime + ", modifiedUser="
				+ modifiedUser + ", modifiedTime=" + modifiedTime + "]";
	}
}
