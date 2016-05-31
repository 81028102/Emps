package cn.jbit.entity;

/**
 * @author 任锯东
 * @date 2016-3-12 上午11:22:02
 */
public class Emp {
	private int id;//流水号
	private String name;//用户名称
	private Long iphone;//电话号码
	private int age;//年龄
	private String love;//爱好
	private String email;//邮箱帐号
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getIphone() {
		return iphone;
	}
	public void setIphone(Long iphone) {
		this.iphone = iphone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLove() {
		return love;
	}
	public void setLove(String love) {
		this.love = love;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Emp(int id, String name, Long iphone, int age, String love,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.iphone = iphone;
		this.age = age;
		this.love = love;
		this.email = email;
	}
	public Emp() {
	}

}
