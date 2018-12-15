/*admin_role列表管理,作者:高振中,日期:2018-12-14 09:36:53*/
<template>
  <div>
    <h3>admin_role管理</h3>
    <hr/>
    <Form inline :label-width="70">
      <FormItem label="主键"><Input placeholder="请输入主键" v-model="form.id"/></FormItem>
      <FormItem label="名称"><Input placeholder="请输入名称" v-model="form.name"/></FormItem>
      <FormItem label="备注"><Input placeholder="请输入备注" v-model="form.remark"/></FormItem>
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
      <RoleDialog ref="dialog" :refresh="refresh"></RoleDialog>
  </div>
</template>
<script>
import {Message, Modal} from 'iview';
import RoleDialog from './RoleDialog.vue';
import RoleListExpand from './RoleListExpand.vue';
  export default {
    data: function () {
      const that = this;
      return {
        tableHeader: [
          {
            type: 'expand',
            width: 50,
            render: (h, params) => {
              return h(RoleListExpand, {
                props: {row: params.row}
              })
            }
          },
            {title: '主键', key: 'id'},
            {title: '名称', key: 'name'},
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
          id : null,// 主键
          name : null,// 名称
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
        that.$http.post("/api/role/queryPage", JSON.stringify(requestData)).then(res => {
		          that.loading = false;
		          that.dataList = res.data.content;
		          that.total = res.data.totalElements;
		        }).catch(res => {
		        Message.error({ content: "获取admin_role列表失败：" + res });
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
          this.$http.delete("/api/role/delete", {
		            params: {ids: [row.id]}
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
    components: {RoleDialog,RoleListExpand},
  }
</script>
<style></style>
