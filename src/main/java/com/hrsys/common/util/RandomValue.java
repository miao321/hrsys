package com.hrsys.common.util;

import java.util.HashMap;  
import java.util.Map;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;  
/**
 * 随机生成中文姓名，性别，Email，手机号，住址
 * @author Administrator
 *
 */
public class RandomValue {  
    public static String base = "abcdefghijklmnopqrstuvwxyz0123456789";   
    private static String[] firstName="赵 钱 孙 李 周 吴 郑 王 冯 陈 楮 卫 蒋 沈 韩 杨 朱 秦 尤 许 何 吕 施 张 孔 曹 严 华 金 魏 陶 姜 戚 谢 邹 喻 柏 水 窦 章 云 苏 潘 葛 奚 范 彭 郎 鲁 韦 昌 马 苗 凤 花 方 俞 任 袁 柳 酆 鲍 史 唐 费 廉 岑 薛 雷 贺 倪 汤 滕 殷 罗 毕 郝 邬 安 常 乐 于 时 傅 皮 卞 齐 康 伍 余 元 卜 顾 孟 平 黄 和 穆 萧 尹 姚 邵 湛 汪 祁 毛 禹 狄 米 贝 明 臧 计 伏 成 戴 谈 宋 茅 庞 熊 纪 舒 屈 项 祝 董 梁 杜 阮 蓝 闽 席 季 麻 强 贾 路 娄 危 江 童 颜 郭 梅 盛 林 刁 锺 徐 丘 骆 高 夏 蔡 田 樊 胡 凌 霍 虞 万 支 柯 昝 管 卢 莫 经 房 裘 缪 干 解 应 宗 丁 宣 贲 邓 郁 单 杭 洪 包 诸 左 石 崔 吉 钮 龚 程 嵇 邢 滑 裴 陆 荣 翁 荀 羊 於 惠 甄 麹 家 封 芮 羿 储 靳 汲 邴 糜 松 井 段 富 巫 乌 焦 巴 弓 牧 隗 山 谷 车 侯 宓 蓬 全 郗 班 仰 秋 仲 伊 宫 宁 仇 栾 暴 甘 斜 厉 戎 祖 武 符 刘 景 詹 束 龙 叶 幸 司 韶 郜 黎 蓟 薄 印 宿 白 怀 蒲 邰 从 鄂 索 咸 籍 赖 卓 蔺 屠 蒙 池 乔 阴 郁 胥 能 苍 双 闻 莘 党 翟 谭 贡 劳 逄 姬 申 扶 堵 冉 宰 郦 雍 郤 璩 桑 桂 濮 牛 寿 通 边 扈 燕 冀 郏 浦 尚 农 温 别 庄 晏 柴 瞿 阎 充 慕 连 茹 习 宦 艾 鱼 容 向 古 易 慎 戈 廖 庾 终 暨 居 衡 步 都 耿 满 弘 匡 国 文 寇 广 禄 阙 东 欧 殳 沃 利 蔚 越 夔 隆 师 巩 厍 聂 晁 勾 敖 融 冷 訾 辛 阚 那 简 饶 空 曾 毋 沙 乜 养 鞠 须 丰 巢 关 蒯 相 查 后 荆 红 游 竺 权 逑 盖 益 桓 公 晋 楚 阎 法 汝 鄢 涂 钦 岳 帅 缑 亢 况 后 有 琴 商 牟 佘 佴 伯 赏 墨 哈 谯 笪 年 爱 阳 佟 万俟 司马 上官 欧阳 夏侯 诸葛 闻人 东方 赫连 皇甫 尉迟 公羊 澹台 公冶 宗政 濮阳 淳于 单于 太叔 申屠 公孙 仲孙 轩辕 令狐 锺离 宇文 长孙 慕容 鲜于 闾丘 司徒 司空 丌官 司寇 仉 督 子车 颛孙 端木 巫马 公西 漆雕 乐正 壤驷 公良 拓拔 夹谷 宰父 谷梁 段干 百里 东郭 南门 呼延 归 海 羊舌 微生 梁丘 左丘 东门 西门 南宫".split(" ");  
    private static String girl="秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";  
    private static String boy="伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";  
    private static String[] road="重庆大厦,黑龙江路,十梅庵街,遵义路,湘潭街,瑞金广场,仙山街,仙山东路,仙山西大厦,白沙河路,赵红广场,机场路,民航街,长城南路,流亭立交桥,虹桥广场,长城大厦,礼阳路,风岗街,中川路,白塔广场,兴阳路,文阳街,绣城路,河城大厦,锦城广场,崇阳街,华城路,康城街,正阳路,和阳广场,中城路,江城大厦,顺城路,安城街,山城广场,春城街,国城路,泰城街,德阳路,明阳大厦,春阳路,艳阳街,秋阳路,硕阳街,青威高速,瑞阳街,丰海路,双元大厦,惜福镇街道,夏庄街道,古庙工业园,中山街,太平路,广西街,潍县广场,博山大厦,湖南路,济宁街,芝罘路,易州广场,荷泽四路,荷泽二街,荷泽一路,荷泽三大厦,观海二广场,广西支街,观海一路,济宁支街,莒县路,平度广场,明水路,蒙阴大厦,青岛路,湖北街,江宁广场,郯城街,天津路,保定街,安徽路,河北大厦,黄岛路,北京街,莘县路,济南街,宁阳广场,日照街,德县路,新泰大厦,荷泽路,山西广场,沂水路,肥城街,兰山路,四方街,平原广场,泗水大厦,浙江路,曲阜街,寿康路,河南广场,泰安路,大沽街,红山峡支路,西陵峡一大厦,台西纬一广场,台西纬四街,台西纬二路,西陵峡二街,西陵峡三路,台西纬三广场,台西纬五路,明月峡大厦,青铜峡路,台西二街,观音峡广场,瞿塘峡街,团岛二路,团岛一街,台西三路,台西一大厦,郓城南路,团岛三街,刘家峡路,西藏二街,西藏一广场,台西四街,三门峡路,城武支大厦,红山峡路,郓城北广场,龙羊峡路,西陵峡街,台西五路,团岛四街,石村广场,巫峡大厦,四川路,寿张街,嘉祥路,南村广场,范县路,西康街,云南路,巨野大厦,西江广场,鱼台街,单县路,定陶街,滕县路,钜野广场,观城路,汶上大厦,朝城路,滋阳街,邹县广场,濮县街,磁山路,汶水街,西藏路,城武大厦,团岛路,南阳街,广州路,东平街,枣庄广场,贵州街,费县路,南海大厦,登州路,文登广场,信号山支路,延安一街,信号山路,兴安支街,福山支广场,红岛支大厦,莱芜二路,吴县一街,金口三路,金口一广场,伏龙山路,鱼山支街,观象二路,吴县二大厦,莱芜一广场,金口二街,海阳路,龙口街,恒山路,鱼山广场,掖县路,福山大厦,红岛路,常州街,大学广场,龙华街,齐河路,莱阳街,黄县路,张店大厦,祚山路,苏州街,华山路,伏龙街,江苏广场,龙江街,王村路,琴屿大厦,齐东路,京山广场,龙山路,牟平街,延安三路,延吉街,南京广场,东海东大厦,银川西路,海口街,山东路,绍兴广场,芝泉路,东海中街,宁夏路,香港西大厦,隆德广场,扬州街,郧阳路,太平角一街,宁国二支路,太平角二广场,天台东一路,太平角三大厦,漳州路一路,漳州街二街,宁国一支广场,太平角六街,太平角四路,天台东二街,太平角五路,宁国三大厦,澳门三路,江西支街,澳门二路,宁国四街,大尧一广场,咸阳支街,洪泽湖路,吴兴二大厦,澄海三路,天台一广场,新湛二路,三明北街,新湛支路,湛山五街,泰州三广场,湛山四大厦,闽江三路,澳门四街,南海支路,吴兴三广场,三明南路,湛山二街,二轻新村镇,江南大厦,吴兴一广场,珠海二街,嘉峪关路,高邮湖街,湛山三路,澳门六广场,泰州二路,东海一大厦,天台二路,微山湖街,洞庭湖广场,珠海支街,福州南路,澄海二街,泰州四路,香港中大厦,澳门五路,新湛三街,澳门一路,正阳关街,宁武关广场,闽江四街,新湛一路,宁国一大厦,王家麦岛,澳门七广场,泰州一路,泰州六街,大尧二路,青大一街,闽江二广场,闽江一大厦,屏东支路,湛山一街,东海西路,徐家麦岛函谷关广场,大尧三路,晓望支街,秀湛二路,逍遥三大厦,澳门九广场,泰州五街,澄海一路,澳门八街,福州北路,珠海一广场,宁国二路,临淮关大厦,燕儿岛路,紫荆关街,武胜关广场,逍遥一街,秀湛四路,居庸关街,山海关路,鄱阳湖大厦,新湛路,漳州街,仙游路,花莲街,乐清广场,巢湖街,台南路,吴兴大厦,新田路,福清广场,澄海路,莆田街,海游路,镇江街,石岛广场,宜兴大厦,三明路,仰口街,沛县路,漳浦广场,大麦岛,台湾街,天台路,金湖大厦,高雄广场,海江街,岳阳路,善化街,荣成路,澳门广场,武昌路,闽江大厦,台北路,龙岩街,咸阳广场,宁德街,龙泉路,丽水街,海川路,彰化大厦,金田路,泰州街,太湖路,江西街,泰兴广场,青大街,金门路,南通大厦,旌德路,汇泉广场,宁国路,泉州街,如东路,奉化街,鹊山广场,莲岛大厦,华严路,嘉义街,古田路,南平广场,秀湛路,长汀街,湛山路,徐州大厦,丰县广场,汕头街,新竹路,黄海街,安庆路,基隆广场,韶关路,云霄大厦,新安路,仙居街,屏东广场,晓望街,海门路,珠海街,上杭路,永嘉大厦,漳平路,盐城街,新浦路,新昌街,高田广场,市场三街,金乡东路,市场二大厦,上海支路,李村支广场,惠民南路,市场纬街,长安南路,陵县支街,冠县支广场,小港一大厦,市场一路,小港二街,清平路,广东广场,新疆路,博平街,港通路,小港沿,福建广场,高唐街,茌平路,港青街,高密路,阳谷广场,平阴路,夏津大厦,邱县路,渤海街,恩县广场,旅顺街,堂邑路,李村街,即墨路,港华大厦,港环路,馆陶街,普集路,朝阳街,甘肃广场,港夏街,港联路,陵县大厦,上海路,宝山广场,武定路,长清街,长安路,惠民街,武城广场,聊城大厦,海泊路,沧口街,宁波路,胶州广场,莱州路,招远街,冠县路,六码头,金乡广场,禹城街,临清路,东阿街,吴淞路,大港沿,辽宁路,棣纬二大厦,大港纬一路,贮水山支街,无棣纬一广场,大港纬三街,大港纬五路,大港纬四街,大港纬二路,无棣二大厦,吉林支路,大港四街,普集支路,无棣三街,黄台支广场,大港三街,无棣一路,贮水山大厦,泰山支路,大港一广场,无棣四路,大连支街,大港二路,锦州支街,德平广场,高苑大厦,长山路,乐陵街,临邑路,嫩江广场,合江路,大连街,博兴路,蒲台大厦,黄台广场,城阳街,临淄路,安邱街,临朐路,青城广场,商河路,热河大厦,济阳路,承德街,淄川广场,辽北街,阳信路,益都街,松江路,流亭大厦,吉林路,恒台街,包头路,无棣街,铁山广场,锦州街,桓台路,兴安大厦,邹平路,胶东广场,章丘路,丹东街,华阳路,青海街,泰山广场,周村大厦,四平路,台东西七街,台东东二路,台东东七广场,台东西二路,东五街,云门二路,芙蓉山村,延安二广场,云门一街,台东四路,台东一街,台东二路,杭州支广场,内蒙古路,台东七大厦,台东六路,广饶支街,台东八广场,台东三街,四平支路,郭口东街,青海支路,沈阳支大厦,菜市二路,菜市一街,北仲三路,瑞云街,滨县广场,庆祥街,万寿路,大成大厦,芙蓉路,历城广场,大名路,昌平街,平定路,长兴街,浦口广场,诸城大厦,和兴路,德盛街,宁海路,威海广场,东山路,清和街,姜沟路,雒口大厦,松山广场,长春街,昆明路,顺兴街,利津路,阳明广场,人和路,郭口大厦,营口路,昌邑街,孟庄广场,丰盛街,埕口路,丹阳街,汉口路,洮南大厦,桑梓路,沾化街,山口路,沈阳街,南口广场,振兴街,通化路,福寺大厦,峄县路,寿光广场,曹县路,昌乐街,道口路,南九水街,台湛广场,东光大厦,驼峰路,太平山,标山路,云溪广场,太清路".split(",");  
    private static String[] place="辽宁 吉林 黑龙江 河北 山西 陕西 山东 安徽 江苏 浙江 河南 湖北 湖南 江西 台湾 福建 云南 海南 四川 贵州 广东 甘肃 青海 西藏 新疆 广西 内蒙古 宁夏 北京 天津 上海 重庆 香港 澳门 海外".split(" ");
    private static final String[] email_suffix="@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com,@ask.com,@live.com,@qq.com,@0355.net,@163.com,@163.net,@263.net,@3721.net,@yeah.net,@googlemail.com,@126.com,@sina.com,@sohu.com,@yahoo.com.cn".split(",");  
    private static String[] education="博士以上 博士 硕士 本科 专科 高中及以下".split(" ");
    private static String[] job="市场分析 产品策划 推广 运营 业务拓展 销售管理 渠道管理 产品开发 运营维护 测试 财务 人事".split(" ");
    private static String[] course="高绩效的团队建设 打造优秀企业文化 团队凝聚力、执行力方案 沟通技能 大客户销售技巧与管理 电话营销技巧 双赢谈判技巧 专业销售技巧培训 职业销售素养提升的8个步骤 店面销售技巧高级 市场开发与经销商管理 十大必胜成交绝技 十三种客户类型 实战市场营销 谁是谈判高手 品牌与战略管理 顾客抱怨处理与应对技巧 客户满意与客户服务技巧 高效客户服务体系建立 金牌营销员服务技能训练 用感动服务提升企业竞争力 客户信用管理与风险控制 客户信用管理与应收账款回收 微笑服务礼仪 接待与电话技巧 职业化助理与秘书综合技能 如何做好一个称职的行政文秘人员 高级秘书、助理和行政人员技能提高 商务公文写作职业化训练 实效管理骨干班—财务精英 实效管理总裁班—财务罗盘 财务报表阅读分析与风险管控 企业所得税深度解读与分析 风险管理与内部控制 纳税筹划技巧与实务 设备、固定资产管理 实效管理方案班—财务再造 财务管理重点与难点剖析 精准成本控制与全面预算管理 实效管理骨干班—财务精英 内部审计实操与技能提升 会议管理 商务演讲技巧 情商管理与压力缓解 演讲与表达技巧 有效的时间管理 员工素质提升与职业能力塑造 职业形象与商务礼仪 office在管理中应用 优秀员工这样工作--新主人翁精神 企业管理者的经济学 无忧人际关系的建立 性格决定命运 赢在执行 有效沟通 执行不力的十大病因 九型人格工作坊 快乐的工作，幸福的生活 中层干部管理能力提升 基层主管现场技能培训 领导力与团队管理 实效管理总裁班—领袖正道 目标管理 如何当好班组长/杰出班组长 问题解决与决策技术 项目管理 实效管理骨干班—带队之道 职业经理人的七个习惯 卓越的执行力 有效授权与激励艺术 高效时间管理 留驻核心人才 管理者常犯的管理 年度经营计划与全面预算管理 非人力资源主管的人力资源预算管理 绩效管理实务 解除终止劳动合同操作实务 劳动争议仲裁与诉讼应对 内部讲师（TTT）训练 企业培训规划与管理 企业选才、育才、留才方法 新劳动合同、员工手册及规章制度操作 员工职业生涯规划 招聘体系与面试技巧 职位分析评估与薪酬福利设计 员工关系全方位管理 3E薪资设计与薪酬管理技巧 企业培训体系构建与培训管理实务 如何识别人的不同人格类型 现代企业股权激励方案设计与实施 心理学在人力资源中的应用 新法下的人力资源管理制度设计与风险 ".split(" ");
    private static String[] language="英语 国语 粤语".split(" ");
    private static String[] courseMethod="面授 网授".split(" ");
    private static String[] employChannel="现场招聘 网络招聘 校园招聘 传统媒体广告 人才介绍机构 内部招聘 员工推荐".split(" ");
    private static String[] trainMaterialSource="公司内部 政府机构 国际组织 行业协会 专门调研机构 联合服务公司 官方和民间信息机构".split(" ");
    private static String[] employActivity="应届生专场招聘会 大型综合招聘会 行业人才招聘会 中高级人才招聘会 网络招聘会".split(" ");
    private static String[] employApplySchool="东莞理工学院 中山大学 华南理工大学 暨南大学 华南师范大学 广东外语外贸大学 清华大学 北京大学 复旦大学 浙江大学 哥伦比亚大学 麻省理工学院 剑桥大学 ".split(" ");
    private static String[] employApplyMajor="软件工程 商务英语 传播学  会计 工商管理 市场营销 金融 法学经济学 国际经济与贸易 金融学 保险学 投资学 财政学 工商管理 计算机科学与技术 土木工程 信息与通信工程 电子科学与技术 机械设计制造及其自动化专业 外国语言文学".split(" ");
    
    public static String name_sex = ""; 
    
    public static int getNum(int start,int end) {  
        return (int)(Math.random()*(end-start+1)+start);  
    }  
      
    /** 
     * 返回Email 
     * @param lMin 最小长度 
     * @param lMax 最大长度 
     * @return 
     */  
    public static String getEmail(int lMin,int lMax) {  
        int length=getNum(lMin,lMax);  
        StringBuffer sb = new StringBuffer();       
        for (int i = 0; i < length; i++) {       
            int number = (int)(Math.random()*base.length());  
            sb.append(base.charAt(number));       
        }  
        sb.append(email_suffix[(int)(Math.random()*email_suffix.length)]);  
        return sb.toString();     
    }  
  
    /** 
     * 返回手机号码 
     */  
    private static String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");  
    public static String getTel() {  
        int index=getNum(0,telFirst.length-1);  
        String first=telFirst[index];  
        String second=String.valueOf(getNum(1,888)+10000).substring(1);  
        String third=String.valueOf(getNum(1,9100)+10000).substring(1);  
        return first+second+third;  
    }  
      
    /** 
     * 返回中文姓名 
     */  
    
    public static String getChineseName() {  
    	
    	    	
    	int index=getNum(0,firstName.length-1); 
    	String first=firstName[index];  

        int sex=getNum(0,1);  
        String str=boy;  
        int length=boy.length();  
        if(sex==0){  
            str=girl;  
            length=girl.length();  
            name_sex = "女";  
        }else {  
            name_sex="男";  
        }  
        index=getNum(0,length-1);  
        String second=str.substring(index, index+1);  
        int hasThird=getNum(0,1);  
        String third="";  
        if(hasThird==1){  
            index=getNum(0,length-1);  
            third=str.substring(index, index+1);  
        }  
        
        return first+second+third;  
    }  
      



	/** 
     * 返回地址 
     * @return 
     */  
    public static String getRoad() {  
        int index=getNum(0,road.length-1);  
        String first=road[index];  
        String second=String.valueOf(getNum(11,150))+"号";  
        String third="-"+getNum(1,20)+"-"+getNum(1,10);  
        return first+second+third;  
    }  
     /**
      * 返回籍贯 
      * @return
      */
    public static String getPlace() {
    	int index=getNum(0,place.length-1); 
    	String placeStr=place[index];  
    	return placeStr;
    }
    /**
     * 返回学历
     * @return
     */
    public static String  getEducation() {
    	int index=getNum(0,education.length-1); 
    	String educationStr=education[index];  
    	return educationStr;
    }
    
    public static String  getJob() {
    	int index=getNum(0,job.length-1); 
    	String jobStr=job[index];  
    	return jobStr;
    }
    /**
     * 返回课程 
     * @return
     */
   public static String getCourse() {
   	int index=getNum(0,course.length-1); 
   	String courseStr=course[index];  
   	return courseStr;
   }
   
   /**
    * 返回语言
    * @return
    */
  public static String getLanguage() {
  	int index=getNum(0,language.length-1); 
  	String languageStr=language[index];  
  	return languageStr;
  }
  
  /**
   * 返回培训方式
   * @return
   */
 public static String getCourseMethod() {
 	int index=getNum(0,courseMethod.length-1); 
 	String courseMethodStr=courseMethod[index];  
 	return courseMethodStr;
 }
 
 /**
  * 返回招聘渠道
  * @return
  */
public static String getEmployChannel() {
	int index=getNum(0,employChannel.length-1); 
	String employChannelStr=employChannel[index];  
	return employChannelStr;
}
/**
 * 返回培训材料来源
 * @return
 */
public static String getTrainMaterialSource() {
	int index=getNum(0,trainMaterialSource.length-1); 
	String trainMaterialSourceStr=trainMaterialSource[index];  
	return trainMaterialSourceStr;
}


public static String getEmployActivity() {
	int index=getNum(0,employActivity.length-1); 
	String employActivityStr=employActivity[index];  
	return employActivityStr;
}



public static String getEmployApplySchool() {
	int index=getNum(0,employApplySchool.length-1); 
	String employApplySchoolStr=employApplySchool[index];  
	return employApplySchoolStr;
}

public static String getEmployApplyMajor() {
	int index=getNum(0,employApplyMajor.length-1); 
	String employApplyMajorStr=employApplyMajor[index];  
	return employApplyMajorStr;
}
    /** 
     * 数据封装 
     * @return 
     */  
    public static Map getAddress() {  
        Map map=new HashMap();  
        map.put("name", getChineseName());  
        map.put("sex", name_sex);  
        map.put("road", getRoad());  
        map.put("tel", getTel());  
        map.put("email", getEmail(6,9));  
        return map;  
    }  
      
/*    public static void main(String[] args) {  
        for (int i = 0; i < 100; i++) {  
            System.out.println(getAddress());  
//          System.out.println(getEmailName(6,9));  
        }  
    } */ 
}  