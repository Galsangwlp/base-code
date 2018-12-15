/*admin_dept列表管理,作者:高振中,日期:2018-12-14 09:36:53*/
<template>
  <div>
    <h3>部门管理</h3>
    <hr/>
    <Form inline :label-width="70">
      <!--<FormItem label="主键"><Input placeholder="请输入主键" v-model="form.dept_id"/></FormItem>-->
      <!--<FormItem label="上级ID"><Input placeholder="请输入上级ID" v-model="form.parent_id"/></FormItem>-->
      <FormItem label="部门名称"><Input placeholder="请输入部门名称" v-model="form.name"/></FormItem>
      <!--<FormItem label="可用标志"><Input placeholder="请输入可用标志" v-model="form.enable"/></FormItem>-->
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
      <DeptDialog ref="dialog" :refresh="refresh"></DeptDialog>
  </div>
</template>
<script>
import {Message, Modal} from 'iview';
import DeptDialog from './DeptDialog.vue';
import DeptListExpand from './DeptListExpand.vue';
  export default {
    data: function () {
      const that = this;
      return {
        tableHeader: [
          {
            type: 'expand',
            width: 50,
            render: (h, params) => {
              return h(DeptListExpand, {
                props: {row: params.row}
              })
            }
          },
            {title: '主键', key: 'dept_id'},
            {title: '上级ID', key: 'parent_id'},
            {title: '部门名称', key: 'name'},
            {title: '可用标志', key: 'enable'},
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
          dept_id : null,// 主键
          parent_id : null,// 上级ID
          name : null,// 部门名称
          enable : null,// 可用标志
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
        that.$http.post("/api/dept/queryPage", JSON.stringify(requestData)).then(res => {
		          that.loading = false;
		          that.dataList = res.data.content;
		          that.total = res.data.totalElements;
		        }).catch(res => {
		        Message.error({ content: "获取admin_dept列表失败：" + res });
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
          this.$http.delete("/api/dept/delete", {
		            params: {ids: [row.dept_id]}
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
    components: {DeptDialog,DeptListExpand},
  }
</script>
<style></style>
