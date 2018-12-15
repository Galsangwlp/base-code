/*菜单列表管理,作者:高振中,日期:2018-12-14 09:36:53*/
<template>
  <div>
    <h3>菜单管理</h3>
    <hr/>
    <Form inline :label-width="70">
      <!--<FormItem label="主键"><Input placeholder="请输入主键" v-model="form.func_id"/></FormItem>-->
      <!--<FormItem label="类型"><Input placeholder="请输入类型" v-model="form.type"/></FormItem>-->
      <!--<FormItem label="颜色"><Input placeholder="请输入颜色" v-model="form.color"/></FormItem>-->
      <!--<FormItem label="图标"><Input placeholder="请输入图标" v-model="form.icon"/></FormItem>-->
      <FormItem label="名称"><Input placeholder="请输入名称" v-model="form.name"/></FormItem>
      <!--<FormItem label="父结点ID"><Input placeholder="请输入父结点ID" v-model="form.parent_id"/></FormItem>-->
      <!--<FormItem label="提示信息"><Input placeholder="请输入提示信息" v-model="form.tip"/></FormItem>-->
      <!--<FormItem label="备注"><Input placeholder="请输入备注" v-model="form.remark"/></FormItem>-->
      <!--<FormItem label="状态"><Input placeholder="请输入状态" v-model="form.status"/></FormItem>-->
      <!--<FormItem label="地址"><Input placeholder="请输入地址" v-model="form.url"/></FormItem>-->
      <!--<FormItem label="排序编号"><Input placeholder="请输入排序编号" v-model="form.order_num"/></FormItem>-->
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
      <FuncDialog ref="dialog" :refresh="refresh"></FuncDialog>
  </div>
</template>
<script>
import {Message, Modal} from 'iview';
import FuncDialog from './FuncDialog.vue';
import FuncListExpand from './FuncListExpand.vue';
  export default {
    data: function () {
      const that = this;
      return {
        tableHeader: [
          {
            type: 'expand',
            width: 50,
            render: (h, params) => {
              return h(FuncListExpand, {
                props: {row: params.row}
              })
            }
          },
            {title: '主键', key: 'func_id'},
            {title: '类型', key: 'type'},
            {title: '颜色', key: 'color'},
            {title: '图标', key: 'icon'},
            {title: '名称', key: 'name'},
            {title: '父结点ID', key: 'parent_id'},
            {title: '提示信息', key: 'tip'},
            {title: '备注', key: 'remark'},
            {title: '状态', key: 'status'},
            {title: '地址', key: 'url'},
            {title: '排序编号', key: 'order_num'},
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
        that.$http.post("/api/func/queryPage", JSON.stringify(requestData)).then(res => {
		          that.loading = false;
		          that.dataList = res.data.content;
		          that.total = res.data.totalElements;
		        }).catch(res => {
		        Message.error({ content: "获取菜单列表失败：" + res });
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
          this.$http.delete("/api/func/delete", {
		            params: {ids: [row.func_id]}
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
    components: {FuncDialog,FuncListExpand},
  }
</script>
<style></style>
