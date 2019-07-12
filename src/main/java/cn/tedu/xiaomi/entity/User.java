package cn.tedu.xiaomi.entity;

/**
 * �û�����ʵ����
 */
public class User extends BaseEntity {

	private static final long serialVersionUID = -1593226973032208283L;
	private Integer id;
	private String username;
	private String password;
	private String phone;
	private String email;
	private String nickname;
	private String questionone;
	private String questiontwo;
	private String questionthree;
	private String answerone;
	private String answertwo;
	private String answerthree;
	private String gender;
	private String bcnumber;
	private String areas;
	private String birth;
	private String userimg;
	private String salt;
	private Integer isdelete;

	public String getGender() {
		return gender;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getQuestionone() {
		return questionone;
	}

	public void setQuestionone(String questionone) {
		this.questionone = questionone;
	}

	public String getQuestiontwo() {
		return questiontwo;
	}

	public void setQuestiontwo(String questiontwo) {
		this.questiontwo = questiontwo;
	}

	public String getQuestionthree() {
		return questionthree;
	}

	public void setQuestionthree(String questionthree) {
		this.questionthree = questionthree;
	}

	public String getAnswerone() {
		return answerone;
	}

	public void setAnswerone(String answerone) {
		this.answerone = answerone;
	}

	public String getAnswertwo() {
		return answertwo;
	}

	public void setAnswertwo(String answertwo) {
		this.answertwo = answertwo;
	}

	public String getAnswerthree() {
		return answerthree;
	}

	public void setAnswerthree(String answerthree) {
		this.answerthree = answerthree;
	}

	public String getBcnumber() {
		return bcnumber;
	}

	public void setBcnumber(String bcnumber) {
		this.bcnumber = bcnumber;
	}

	public String getAreas() {
		return areas;
	}

	public void setAreas(String areas) {
		this.areas = areas;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getUserimg() {
		return userimg;
	}

	public void setUserimg(String userimg) {
		this.userimg = userimg;
	}

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				", nickname='" + nickname + '\'' +
				", questionone='" + questionone + '\'' +
				", questiontwo='" + questiontwo + '\'' +
				", questionthree='" + questionthree + '\'' +
				", answerone='" + answerone + '\'' +
				", answertwo='" + answertwo + '\'' +
				", answerthree='" + answerthree + '\'' +
				", gender='" + gender + '\'' +
				", bcnumber='" + bcnumber + '\'' +
				", areas='" + areas + '\'' +
				", birth='" + birth + '\'' +
				", userimg='" + userimg + '\'' +
				", salt='" + salt + '\'' +
				", isdelete=" + isdelete +
				'}';
	}
}
