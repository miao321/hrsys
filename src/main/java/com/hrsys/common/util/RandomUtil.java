package com.hrsys.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 随机生成相关数据
 * 
 * @author Lofu
 *
 */
public class RandomUtil {

	/** 随机生成人名 */
	public static String getRandomName() {
		String[] firstName = { "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "楮", "卫", "蒋", "沈", "韩", "杨", "朱", "秦",
				"尤", "许", "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦",
				"章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎", "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳",
				"酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常", "乐",
				"于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和", "穆", "萧", "尹", "姚", "邵",
				"湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒",
				"屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闽", "席", "季", "麻", "强", "贾", "路", "娄", "危", "江", "童", "颜", "郭",
				"梅", "盛", "林", "刁", "锺", "徐", "丘", "骆", "高", "夏" };
		String[] lastName = { "伟", "伟", "芳", "伟", "秀英", "秀英", "娜", "秀英", "伟", "敏", "静", "丽", "静", "丽", "强", "静", "敏",
				"敏", "磊", "军", "洋", "勇", "勇", "艳", "杰", "磊", "强", "军", "杰", "娟", "艳", "涛", "涛", "明", "艳", "超", "勇", "娟",
				"杰", "秀兰", "霞", "敏", "军", "丽", "强", "平", "刚", "杰", "桂英", "芳", "嘉懿", "煜城", "懿轩", "烨伟", "苑博", "伟泽", "熠彤",
				"鸿煊", "博涛", "烨霖", "烨华", "煜祺", "智宸", "正豪", "昊然", "明杰", "立诚", "立轩", "立辉", "峻熙", "弘文", "熠彤", "鸿煊", "烨霖",
				"哲瀚", "鑫鹏", "致远", "俊驰", "雨泽", "烨磊", "晟睿", "天佑", "文昊", "修洁", "黎昕", "远航", "旭尧", "鸿涛", "伟祺", "荣轩", "越泽",
				"浩宇", "瑾瑜", "皓轩", "擎苍", "擎宇", "志泽", "睿渊", "楷瑞", "子轩", "弘文", "哲瀚", "雨泽", "鑫磊", "修杰", "伟诚", "建辉", "晋鹏",
				"天磊", "绍辉", "泽洋", "明轩", "健柏", "鹏煊", "昊强", "伟宸", "博超", "君浩", "子骞", "明辉", "鹏涛", "炎彬", "鹤轩", "越彬", "风华",
				"靖琪", "明诚", "高格", "光华", "国源", "冠宇", "晗昱", "涵润", "翰飞", "翰海", "昊乾", "浩博", "和安", "弘博", "宏恺", "鸿朗", "华奥",
				"华灿", "嘉慕", "坚秉", "建明", "金鑫", "锦程", "瑾瑜", "晋鹏", "经赋", "景同", "靖琪", "君昊", "俊明", "季同", "开济", "凯安", "康成",
				"乐语", "力勤", "良哲", "理群", "茂彦", "敏博", "明达", "朋义", "彭泽", "鹏举", "濮存", "溥心", "璞瑜", "浦泽", "奇邃", "祺祥", "荣轩",
				"锐达", "睿慈", "绍祺", "圣杰", "晟睿", "思源", "斯年", "泰宁", "天佑", "同巍", "奕伟", "祺温", "文虹", "向笛", "心远", "欣德", "新翰",
				"兴言", "星阑", "修为", "旭尧", "炫明", "学真", "雪风", "雅昶", "阳曦", "烨熠", "英韶", "永贞", "咏德", "宇寰", "雨泽", "玉韵", "越彬",
				"蕴和", "哲彦", "振海", "正志", "子晋", "自怡", "德赫", "君平" };
		int a = (int) Math.abs(firstName.length * Math.random());
		int b = (int) Math.abs(lastName.length * Math.random());
		String name = firstName[a] + lastName[b];
		return name;
	}
	
	/** 随机生成性别 */
	public static String getRandomSex() {
		String sex = (Math.random() > 0.5) ? "男" : "女";
		return sex;
	}
	
	/** 随机生成部门 */
	public static String getRandomDept() {
		String[] dept = { "人事部", "财务部", "策划部", "招聘部", "培训部", "研发部", "技术部", "市场部", "营销部", "考核部", "保卫部", "后勤部" };
		int i = (int) Math.abs(dept.length * Math.random());
		String deptName = dept[i];
		return deptName;
	}
	
	/** 随机生成职位 */
	public static String getRandomPosition() {
		String[] arr = { "部门总监", "副总监", "部门主管", "副主管", "部门职员", "临时员工", "实习生" };
		int i = (int) Math.abs(arr.length * Math.random());
		String position = arr[i];
		return position;
	}
	
	/** 随机生成工资 */
	public static int getRandomSalary() {
		int salary = (int)(Math.random() * 300) * 200 + 3000;
		return salary;
	}
	
	/** 随机生成学历 */
	public static String getRandomEducation() {
		String[] arr = { "博士", "硕士", "本科", "大专", "高职", "高中", "初中" };
		int i = (int) Math.abs(arr.length * Math.random());
		String education = arr[i];
		return education;
	}
	
	/** 随机生成学校 */
	public static String getRandomGraduate() {
		String[] arr = { "东莞理工学院", "中山大学", "清华大学", "北京大学", "广东职业技术学院", "广东执信中学" };
		int i = (int) Math.abs(arr.length * Math.random());
		String graduate = arr[i];
		return graduate;
	}
	
	/** 随机生成4位数字 */
	private static String getRandomXxxx() {
		int num = (int) (Math.random() * 9999);
		while(num < 1000) {
			num = (int) (Math.random() * 9999);
		}
		return num+"";
	}
	
	/** 随机生成手机号码 */
	public static String getRandomPhone() {
		String[] telFirst= {"134","135","136","137","138","139","150","151","152","157","158","159","130","131","132","155","156","133","153"};
		int a = (int) Math.abs(telFirst.length * Math.random());
		String b = getRandomXxxx();
		String c = getRandomXxxx();
		String phone = telFirst[a] + "-" + b + "-" + c;
		return phone;
	}
	
	/** 随机生成邮箱地址 */
	public static String getRandomEmail() {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		String[] email_suffix = "@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com,@ask.com,@live.com,@qq.com,@0355.net,@163.com,@163.net,@263.net,@3721.net,@yeah.net,@googlemail.com,@126.com,@sina.com,@sohu.com,@yahoo.com.cn"
				.split(",");
		int length = (int) (Math.random() * 10) + 6;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = (int) (Math.random() * base.length());
			sb.append(base.charAt(number));
		}
		sb.append(email_suffix[(int) (Math.random() * email_suffix.length)]);
		return sb.toString();
	}
	
	/** 获得一个随机的日期 */
	public static Date getRandomDate() {
		long date = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");  
        	Date start = sdf.parse("2015/01/01");	// 构造开始日期  
			Date end = sdf.parse("2017/12/31");		// 构造结束日期  
			date = start.getTime() + (long)(Math.random() * (end.getTime() - start.getTime())) ;  
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		return new Date(date) ;  
	}
	
	/** 随机生成身份证号码 */
	public static String getRandomIdCard() {
		String[] top = { "653224", "431081", "130207", "320202", "510923", "110100", "533122", "210401", "361002",
				"341122", "450481", "653726", "210402", "350800", "130637" };
		String birthday = DateUtil.dateToNum(getRandomDate());
		int a = (int) Math.abs(top.length * Math.random());
		String end = getRandomXxxx();
		String idCard = top[a] + birthday + end;
		return idCard;
	}
	
	/** 随机生成籍贯 */
	public static String getRandomNative() {
		String[] nativePlaces = { "河北石家庄", "辽宁沈阳", "黑龙江哈尔滨", "浙江杭州", "福建福州", "山东济南", "广东广州", "湖北武汉", "四川成都", "云南昆明",
				"甘肃兰州", "台湾台北", "广西南宁", "宁夏银川", "山西太原", "吉林长春", "江苏南京", "安徽合肥", "江西南昌", "河南郑州", "湖南长沙", "海南海口", "贵州贵阳",
				"陕西西安", "青海西宁", "西藏拉萨", "新疆乌鲁木齐", "内蒙古呼和浩特" };
		int i = (int) Math.abs(nativePlaces.length * Math.random());
		String nativePlace = nativePlaces[i];
		return nativePlace;
	}
	
	/** 随机生成加班内容 */
	public static String getRandomContent() {
		String[] contents = { "加班测试", "完成上午的工作", "完成下午的工作", "临时加班", "预备下周工作", "准备明天的会议", 
				"完成报告PPT", "数据报表的统计", "产品预备上线", "领导组织额外工作", "上线产品调优", "处理紧急事务", "主动加班" };
		int i = (int) Math.abs(contents.length * Math.random());
		String content = contents[i];
		return content;
	}
	
	/** 随机生成请假事由 */
	public static String getRandomLeaveType() {
		String[] types = { "病假", "事假", "婚假", "丧假", "产假", "公假"};
		int i = (int) Math.abs(types.length * Math.random());
		String leaveType = types[i];
		return leaveType;
	}
	
	/** 随机生成请假时长 */
	public static String getRandomLeaveTime() {
		String[] times = {"上午","下午","全天"};
		int i = (int) Math.abs(times.length * Math.random());
		String timeLong = times[i];
		return timeLong;
	}
	
	/** 随机生成领导 */
	public static String getRandomLeader() {
		String[] leaders = {"总经理", "副经理", "部门总监", "副总监", "部门主管", "副主管"};
		int i = (int) Math.abs(leaders.length * Math.random());
		String leader = leaders[i];
		return leader;
	}
	
	/** 随机生成违规类型 */
	public static String getRandomBreachType() {
		String[] types = { "迟到", "早退", "旷工" };
		int i = (int) Math.abs(types.length * Math.random());
		String type = types[i];
		return type;
	}
	
}
