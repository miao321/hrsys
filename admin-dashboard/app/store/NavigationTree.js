Ext.define('Admin.store.NavigationTree', {
    extend: 'Ext.data.TreeStore',

    storeId: 'NavigationTree',

    fields: [{
        name: 'text'
    }],

    root: {
        expanded: true,
        children: [
            {
                text: '系统管理',
                iconCls: 'x-fa fa-desktop',
                //rowCls: 'nav-tree-badge nav-tree-badge-new',
                viewType: 'admindashboard',
                routeId: 'dashboard', // routeId defaults to viewType
                children: [
                    {
                        text: '角色管理',
                        iconCls: 'x-fa fa-user-plus',
                        viewType: 'userModelPanel',
                        leaf: true
                    },

                    {
                        text: '模块管理',
                        iconCls: 'x-fa fa-clone',
                        //viewType: 'page404',
                        leaf: true
                    },{
                        text: '用户权限分配',
                        iconCls: 'x-fa fa-user-plus',
                        //viewType: 'pageblank',
                        leaf: true
                    },

                    {
                        text: '组织机构管理',
                        iconCls: 'x-fa fa-users',
                        //viewType: 'page404',
                        leaf: true
                    },
                    {
                        text: '日志管理',
                        iconCls: 'x-fa fa-envelope-o',
                        //viewType: 'page404',
                        leaf: true
                    }]
       		},
	        {
	        	text:'用户管理模块',
	        	iconCls:'x-fa fa-user',
	        	viewType:'userModelPanel',
	        		children: [
                {
                    text: '修改密码',
                    iconCls: 'x-fa fa-exchange',
                    viewType: 'pageblank',
                    leaf: true
                },{
                    text: '添加用户',
                    iconCls: 'x-fa fa-user-plus',
                    viewType: 'pageblank',
                    leaf: true
                },{
                    text: '用户信息',
                    iconCls: 'x-fa fa-user',
                    viewType: 'pageblank',
                    leaf: true
                },{
                    text: '退出系统',
                   // href:'login.jsp',
                    iconCls: 'x-fa fa-power-off',
                    viewType: 'login.jsp',
                    leaf: true
                }]	
	        },
            {
                text: '人事管理',
                iconCls: 'x-fa fa-user-circle',
                //rowCls: 'nav-tree-badge nav-tree-badge-hot',
                viewType: 'email',
               
           		children: [
                {
                    text: '职员信息',
                    iconCls: 'x-fa fa-user-circle',
                    viewType: 'pageblank',
                    leaf: true
                },
                {
                    text: '职员合同管理',
                    iconCls: 'x-fa fa-file-o',
                    viewType: 'page404',
                    leaf: true
                },
                {
                    text: '人事变动',
                    iconCls: 'x-fa fa-user-circle',
                    viewType: 'page404',
                    leaf: true
                },
                {
                    text: '人事变动查询',
                    iconCls: 'x-fa fa-user-circle',
                    viewType: 'page404',
                    leaf: true
                },
                {
                    text: '外出人员安排',
                    iconCls: 'x-fa fa-user-circle',
                    viewType: 'page404',
                    leaf: true
                },
                {
                    text: '外出人员查询',
                    iconCls: 'x-fa fa-user-circle',
                    viewType: 'page404',
                    leaf: true
                }]
            },
            {
                text: '薪资管理',
                iconCls: 'x-fa fa-money',
                viewType: 'profile',
                children: [
                {
                    text: '账套管理',
                    iconCls: 'x-fa fa-money',
                    viewType: 'pageblank',
                    leaf: true
                },
                {
                    text: '薪资项目管理',
                    iconCls: 'x-fa fa-money',
                    viewType: 'page404',
                    leaf: true
                },
                {
                    text: '绩效考核设置',
                    iconCls: 'x-fa fa-money',
                    viewType: 'page404',
                    leaf: true
                },
                {
                    text: '绩效考核表',
                    iconCls: 'x-fa fa-money',
                    viewType: 'page404',
                    leaf: true
                },
                {
                    text: '考核记录管理',
                    iconCls: 'x-fa fa-money',
                    viewType: 'page404',
                    leaf: true
                },
                {
                    text: '薪资计算',
                    iconCls: 'x-fa fa-money',
                    viewType: 'page404',
                    leaf: true
                },
                {
                    text: '薪资导出',
                    iconCls: 'x-fa fa-money',
                    viewType: 'page404',
                    leaf: true
                }]
            },
            {
                text: '招聘管理',
                iconCls: 'x-fa fa-hand-pointer-o',
                viewType: 'searchresults',
                children: [
                {
                    text: '招聘职位管理',
                    iconCls: 'x-fa fa-file-o',
                    viewType: 'pageblank',
                    leaf: true
                },
                {
                    text: '招聘渠道管理',
                    iconCls: 'x-fa fa-star',
                    viewType: 'page404',
                    leaf: true
                },
                {
                    text: '招聘活动管理',
                    iconCls: 'x-fa fa-file-o',
                    viewType: 'page404',
                    leaf: true
                },
                {
                    text: '应聘者管理',
                    iconCls: 'x-fa fa-star',
                    viewType: 'page404',
                    leaf: true
                },
                {
                    text: '人才库管理',
                    iconCls: 'x-fa fa-file-o',
                    viewType: 'page404',
                    leaf: true
                },
                {
                    text: '招聘统计及分析',
                    iconCls: 'x-fa fa-map',
                    viewType: 'page404',
                    leaf: true
                }]
            },
            {
                text: '培训管理',
                iconCls: 'x-fa fa-heart',
                //viewType: 'faq',
                children: [
                {
                    text: '培训计划管理',
                    iconCls: 'x-fa fa-file-o',
                    viewType: 'pageblank',
                    leaf: true
                },
                {
                    text: '培训实施管理',
                    iconCls: 'x-fa fa-star',
                    viewType: 'page404',
                    leaf: true
                },
                {
                    text: '培训需求计划',
                    iconCls: 'x-fa fa-file-o',
                    viewType: 'page404',
                    leaf: true
                },
                {
                    text: '培训课程管理',
                    iconCls: 'x-fa fa-star',
                    viewType: 'page404',
                    leaf: true
                },
                {
                    text: '培训材料管理',
                    iconCls: 'x-fa fa-file-o',
                    viewType: 'page404',
                    leaf: true
                },
                {
                    text: '培训统计及分析',
                    iconCls: 'x-fa fa-map',
                    viewType: 'page404',
                    leaf: true
                }]
            },
            {
                text: '考勤管理',
                iconCls: 'x-fa fa-leanpub',
                expanded: false,
                selectable: false,
                //routeId: 'pages-parent',
                //id: 'pages-parent',

                children: [
                    {
                        text: '上下班打卡记录',
                        iconCls: 'x-fa fa-file-o',
                        viewType: 'pageblank',
                        leaf: true
                    },

                    {
                        text: '加班记录',
                        iconCls: 'x-fa fa-star',
                        viewType: 'page404',
                        leaf: true
                    },
                    {
                        text: '考勤规则',
                        iconCls: 'x-fa fa-file-o',
                        viewType: 'page500',
                        leaf: true
                    },
                    {
                        text: '加班通知',
                        iconCls: 'x-fa fa-star',
                        viewType: 'lockscreen',
                        leaf: true
                    },

                    {
                        text: '数据分析及显示',
                        iconCls: 'x-fa fa-map',
                        viewType: 'login',
                        leaf: true
                    },
                    {
                        text: '考勤信息下载',
                        iconCls: 'x-fa fa-share-square-o',
                        viewType: 'register',
                        leaf: true
                    }
                ]
            }
        ]
    }
});
