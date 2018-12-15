/*admin_sys_user列表管理,作者:高振中,日期:2018-12-14 09:36:53*/
<template>
  <div>
    <h3>人员管理</h3>
    <hr/>
    <Form inline :label-width="70">
      <!--<FormItem label="主键"><Input placeholder="请输入主键" v-model="form.user_id"/></FormItem>-->
      <FormItem label="姓名"><Input placeholder="请输入姓名" v-model="form.name"/></FormItem>
      <!--<FormItem label="会员编号"><Input placeholder="请输入会员编号" v-model="form.password"/></FormItem>-->
      <FormItem label="手机号"><Input placeholder="请输入手机号" v-model="form.phone"/></FormItem>
      <FormItem label="性别"><Input placeholder="请输入性别" v-model="form.gender"/></FormItem>
      <!--<FormItem label="状态"><Input placeholder="请输入状态" v-model="form.status"/></FormItem>-->
      <!--<FormItem label="部门ID"><Input placeholder="请输入部门ID" v-model="form.department_id"/></FormItem>-->
      <FormItem label="微信号"><Input placeholder="请输入微信号" v-model="form.wechat"/></FormItem>
      <!--<FormItem label="备注"><Input placeholder="请输入备注" v-model="form.remark"/></FormItem>-->
        <FormItem>
          <Button icon="search" @click="refresh" title="根据输入的条件查询" type="primary">查询</Button>
          <Button type="primary" icon="plus" @click="doAdd()" title="添加" >添加</Button>
        </FormItem>
      </Form>
      <Table :loading="loading" :columns="tableHeader" :data="dataList" style="width: 100%"></Table>
      <br/>
      <div style="text-align: right" v-if="total > 0">
        <Page size="small" :current="page" :total="total" show-total  @on-change="(curr) => {this.page = curr ; this.refresh();}"
              show-sizer @on-page-size-change="(pageSize) => { this.pageSize = pageSize ; this.refresh();}" :page-size="pageSize"></Page>
      </div>
      <SysUserDialog ref="dialog" :refresh="refresh"></SysUserDialog>
  </div>
</template>
<script>
import {Message, Modal} from 'iview';
import SysUserDialog from './SysUserDialog.vue';
import SysUserListExpand from './SysUserListExpand.vue';
  export default {
    data: function () {
      const that = this;
      return {
        tableHeader: [
          {
            type: 'expand',
            width: 50,
            render: (h, params) => {
              return h(SysUserListExpand, {
                props: {row: params.row}
              })
            }
          },
            {title: '主键', key: 'user_id'},
            {title: '姓名', key: 'name'},
            // {title: '会员编号', key: 'password'},
            {title: '手机号', key: 'phone'},
            {title: '性别', key: 'gender'},
            {title: '状态', key: 'status'},
            // {title: '部门ID', key: 'department_id'},
            {title: '微信号', key: 'wechat'},
            {title: '备注', key: 'remark'},
          {
            title: '操作',
            width: 150,
            render: (h, params) => {
              return h('div', [
                h('Button', {
                  props: {type:'primary',size:'small'},
                  style: {marginRight: '5px'},
                  on: {
                    click: () => {
                      that.doEdit(params.row)
                    }
                  }
                }, '编辑'),
                h('Button', {
                  props: {type: 'primary',size: 'small'},
                  on: {
                    click: () => {
                      that.doDelete(params.row)
                    }
                  }
                }, '删除')
              ]);
            }
          }
        ],
        total: 0,
        page: 1,
        pageSize: 20,
        dataList: [],
        form: {
          user_id : null,// 主键
          name : null,// 姓名
          password : null,// 会员编号
          phone : null,// 手机号
          gender : null,// 性别
          status : null,// 状态
          department_id : null,// 部门ID
          wechat : null,// 微信号
          remark : null,// 备注
        },
        loading: false
      }
    },
    computed: {},
    created: function () {
      this.refresh();
    },
    methods: {
      refresh() {
        const that = this;
        that.loading = true;
        const requestData = {...that.form, page: that.page - 1,size:that.pageSize};
        that.$http.post("/api/sysUser/queryPage", JSON.stringify(requestData)).then(res => {
		          that.loading = false;
		          that.dataList = res.data.content;
		          that.total = res.data.totalElements;
		        }).catch(res => {
		        Message.error({ content: "获取admin_sys_user列表失败：" + res });
		        });
      },
      doAdd() {
        this.$refs["dialog"].addDialog();
      },
      doEdit(row) {
        this.$refs["dialog"].editDialog(row);
      },
      doDelete(row) {
        const that = this;
      Modal.confirm({
        title: '提示',
        content: '您确定要删除吗?',
        closable:true,
        onOk: () => {
          this.$http.delete("/api/sysUser/delete", {
		            params: {ids: [row.user_id]}
		          }).then(res => {
		            Message.success({ content: "删除成功" });
		            that.refresh();
		          }).catch(res => {
		            Message.error({ content: "删除失败：" + res });
		          });
        },
        onCancel: () => {
        }
      });
      }
    },
    components: {SysUserDialog,SysUserListExpand},
  }
</script>
<style></style>
