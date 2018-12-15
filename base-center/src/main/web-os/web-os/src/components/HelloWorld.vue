<template>
  <div class="hello">
    <Layout :style="{minHeight: '100vh'}">
      <Sider collapsible :collapsed-width="78" v-model="isCollapsed">
        <Menu  theme="dark" width="auto" :class="menuitemClasses" v-for="item in dataList" >
          <MenuItem :name="item.func_id" :key="item.func_id">
            <Icon :type="item.icon"></Icon>
            <span style="width: 85px" @click="clickdd(item.func_id)">{{item.name}}</span>
          </MenuItem>
          <!--<MenuItem name="1-2">-->
            <!--<Icon type="search"></Icon>-->
            <!--<span>Option 2</span>-->
          <!--</MenuItem>-->
          <!--<MenuItem name="1-3">-->
            <!--<Icon type="settings"></Icon>-->
            <!--<span>Option 3</span>-->
          <!--</MenuItem>-->
        </Menu>
      </Sider>
      <Layout>
        <Header :style="{background: '#fff', boxShadow: '0 2px 3px 2px rgba(0,0,0,.1)'}">
          <div style="color: #2b85e4;font-size: 24px">未来篇管理系统</div>
        </Header>
        <Content :style="{padding: '0 16px 16px'}">
          <Breadcrumb :style="{margin: '16px 0'}">
            <BreadcrumbItem>Home</BreadcrumbItem>
            <BreadcrumbItem>Components</BreadcrumbItem>
            <BreadcrumbItem>Layout</BreadcrumbItem>
          </Breadcrumb>
          <Card>
            <div style="height: 600px">
              <Tabs v-model="tabvalue">
                <TabPane label="部门管理" name="name2">
                  <DeptList></DeptList>
                </TabPane>
                <TabPane label="角色管理" name="name3">
                  <FuncList></FuncList>
                </TabPane>
                <TabPane label="人员管理" name="name4">
                  <SysUserList></SysUserList>
                </TabPane>
                <TabPane label="菜单管理" name="name5">
                  <FuncList></FuncList>
                </TabPane>
              </Tabs>
            </div>
          </Card>
        </Content>
      </Layout>
    </Layout>
  </div>

</template>

<script>
  import DeptList from "./base/dept/DeptList";
  import FuncList from "./base/func/FuncList";
  import SysUserList from "./base/sysuser/SysUserList";

  export default {
    name: 'HelloWorld',
    components: {SysUserList, FuncList, DeptList},
    data() {
      return {
        tabvalue:'',//标签页
        dataList:[],
        isCollapsed: false,
        form: {
          func_id : null,// 主键
          type : null,// 类型
          color : null,// 颜色
          icon : null,// 图标
          name : null,// 名称
          parent_id : null,// 父结点ID
          tip : null,// 提示信息
          remark : null,// 备注
          status : null,// 状态
          url : null,// 地址
          order_num : null,// 排序编号
        },
      }
    },
    created: function () {
      this.refresh();
    },
    computed: {
      menuitemClasses: function () {
        return [
          'menu-item',
          this.isCollapsed ? 'collapsed-menu' : ''
        ]
      }
    },
    methods: {
      refresh() {
        const that = this;
        that.loading = true;
        const requestData = {...that.form};
        that.$http.post("/api/func/queryList", JSON.stringify(requestData)).then(res => {
          that.loading = false;
          that.dataList = res.data;
          // that.dataList = res.data.content;
          // that.total = res.data.totalElements;
        }).catch(res => {
          Message.error({content: "获取菜单列表失败：" + res});
        });
      },
      clickdd(v){
        console.log(v)
        this.tabvalue = "name"+v;
        console.log(this.tabvalue)
        // this.isCollapsed = false;
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .layout-con {
    height: 100%;
    width: 100%;
  }

  .menu-item span {
    display: inline-block;
    overflow: hidden;
    width: 69px;
    text-overflow: ellipsis;
    white-space: nowrap;
    vertical-align: bottom;
    transition: width .2s ease .2s;
  }

  .menu-item i {
    transform: translateX(0px);
    transition: font-size .2s ease, transform .2s ease;
    vertical-align: middle;
    font-size: 16px;
  }

  .collapsed-menu span {
    width: 0px;
    transition: width .2s ease;
  }

  .collapsed-menu i {
    transform: translateX(5px);
    transition: font-size .2s ease .2s, transform .2s ease .2s;
    vertical-align: middle;
    font-size: 22px;
  }
</style>
