/*
{*****************************************************************************
{  dubbo示例 v1.0													
{  版权信息 (c) 2005-2017 http://git.oschina.net/htengen
{  创建人：  张俊伟
{  审查人：
{  模块：											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2017-07-04  张俊伟        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package own.jadezhang.learning.almond.mp.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import own.jadezhang.base.common.domain.BaseDomain;

/**
 * 《权限用户表》 实体
 * @author 张俊伟
 *
 */
public class AuthUser extends BaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private String code; //用户code
	private String name; //用户名
	private String password; //加密后的密码
	private String phone; //手机号
	private String salt; //密码加密使用的盐值
	private Integer state; //用户状态；0：活跃；1：锁定
    
	/**
	 *默认空构造函数
	 */
	public AuthUser() {
		super();
	}
	 
	/**
	 * @return code 用户code
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 用户code
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return name 用户名
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 用户名
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * @return password 加密后的密码
	 */
	public String getPassword(){
		return this.password;
	}
	/**
	 * @param password 加密后的密码
	 */
	public void setPassword(String password){
		this.password = password;
	}
	/**
	 * @return phone 手机号
	 */
	public String getPhone(){
		return this.phone;
	}
	/**
	 * @param phone 手机号
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}
	/**
	 * @return salt 密码加密使用的盐值
	 */
	public String getSalt(){
		return this.salt;
	}
	/**
	 * @param salt 密码加密使用的盐值
	 */
	public void setSalt(String salt){
		this.salt = salt;
	}
	/**
	 * @return state 用户状态；0：活跃；1：锁定
	 */
	public Integer getState(){
		return this.state;
	}
	/**
	 * @param state 用户状态；0：活跃；1：锁定
	 */
	public void setState(Integer state){
		this.state = state;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("code",getCode())
			.append("name",getName())
			.append("password",getPassword())
			.append("phone",getPhone())
			.append("salt",getSalt())
			.append("state",getState())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getCode())
			.append(getName())
			.append(getPassword())
			.append(getPhone())
			.append(getSalt())
			.append(getState())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AuthUser == false) return false;
		if(this == obj) return true;
		AuthUser other = (AuthUser)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
