package cn.temptation.domain;

/**
 * 用户信息
 */
public class User {
    // 成员变量
    private Integer userid;
    private String username;
    private String password;
    private String sex;
    private String phone;
    private String name;
    private String address;
    private String guanzhu;
    private String dianzanid;
    

    // 构造函数
    public User() {
        super();
    }

    public User(Integer userid, String username, String password,String sex, String phone,String name, String address,String guanzhu,String dianzanid) {
        super();
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.guanzhu = guanzhu;
        this.dianzanid = dianzanid;
    }

    // 成员方法
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGuanzhu() {
		return guanzhu;
	}

	public void setGuanzhu(String guanzhu) {
		this.guanzhu = guanzhu;
	}

	public String getDianzanid() {
		return dianzanid;
	}

	public void setDianzanid(String dianzanid) {
		this.dianzanid = dianzanid;
	}
}