/*菜单新增与修改,作者:高振中,日期:2018-12-14 09:36:53*/
<template>
  <Modal :title="title" v-model="show" :scrollable="false" :mask-closable="false" width="600" draggable >
    <Form :common="form" ref="form" :rules="rules" :label-width="100">
      <Row>
        <i-col>
          <!--<FormItem label="主键" prop="func_id"><Input placeholder="主键" v-model="form.func_id"/></FormItem>-->
          <FormItem label="类型" prop="type"><Input placeholder="类型" v-model="form.type"/></FormItem>
          <FormItem label="颜色" prop="color"><Input placeholder="颜色" v-model="form.color"/></FormItem>
          <FormItem label="图标" prop="icon"><Input placeholder="图标" v-model="form.icon"/></FormItem>
          <FormItem label="名称" prop="name"><Input placeholder="名称" v-model="form.name"/></FormItem>
          <FormItem label="父结点ID" prop="parent_id"><Input placeholder="父结点ID" v-model="form.parent_id"/></FormItem>
          <FormItem label="提示信息" prop="tip"><Input placeholder="提示信息" v-model="form.tip"/></FormItem>
          <FormItem label="备注" prop="remark"><Input placeholder="备注" v-model="form.remark"/></FormItem>
          <FormItem label="状态" prop="status"><Input placeholder="状态" v-model="form.status"/></FormItem>
          <FormItem label="地址" prop="url"><Input placeholder="地址" v-model="form.url"/></FormItem>
          <FormItem label="排序编号" prop="order_num"><Input placeholder="排序编号" v-model="form.order_num"/></FormItem>
        </i-col>
      </Row>
    </Form>
      <div slot="footer" style="text-align: right">
        <Button @click="show = false">取消</Button>
        <Button type="primary" @click="save()">确定</Button>
      </div>
    </Modal>
</template>
<script>
import {Message, Modal} from 'iview';
  export default {
    props: ["refresh"],
    data() {
      return {
        title: '',
        form: this.initForm(),
        dialogMode: "save",
        show: false,
        rules: {
          // func_id : [
          //   {required: true, message: '请输入主键', trigger: 'blur'},
          //   {min: 1, max: 10, message: '主键长度不正确}', trigger: 'blur'},
          // ],
          type : [
            {required: true, message: '请输入类型', trigger: 'blur'},
            {min: 1, max: 10, message: '类型长度不正确}', trigger: 'blur'},
          ],
          color : [
            {required: true, message: '请输入颜色', trigger: 'blur'},
            {min: 1, max: 10, message: '颜色长度不正确}', trigger: 'blur'},
          ],
          icon : [
            {required: true, message: '请输入图标', trigger: 'blur'},
            {min: 1, max: 10, message: '图标长度不正确}', trigger: 'blur'},
          ],
          name : [
            {required: true, message: '请输入名称', trigger: 'blur'},
            {min: 1, max: 10, message: '名称长度不正确}', trigger: 'blur'},
          ],
          parent_id : [
            {required: true, message: '请输入父结点ID', trigger: 'blur'},
            {min: 1, max: 10, message: '父结点ID长度不正确}', trigger: 'blur'},
          ],
          tip : [
            {required: true, message: '请输入提示信息', trigger: 'blur'},
            {min: 1, max: 10, message: '提示信息长度不正确}', trigger: 'blur'},
          ],
          remark : [
            {required: true, message: '请输入备注', trigger: 'blur'},
            {min: 1, max: 10, message: '备注长度不正确}', trigger: 'blur'},
          ],
          status : [
            {required: true, message: '请输入状态', trigger: 'blur'},
            {min: 1, max: 10, message: '状态长度不正确}', trigger: 'blur'},
          ],
          url : [
            {required: true, message: '请输入地址', trigger: 'blur'},
            {min: 1, max: 10, message: '地址长度不正确}', trigger: 'blur'},
          ],
          order_num : [
            {required: true, message: '请输入排序编号', trigger: 'blur'},
            {min: 1, max: 10, message: '排序编号长度不正确}', trigger: 'blur'},
          ],
        }
      }
    },
    methods: {
      save() {//新增及修改记录
        const that = this;
        this.$refs['form'].validate((valid) => {
          if (!valid) {
            return;
          }
          that.$http.post("/api/func/" + that.dialogMode, JSON.stringify(that.form)).then(res => {
            that.show = false;
            that.refresh();
            Message.success({ content: '保存菜单信息成功'});
          }).catch(res => {
             Message.error({ content: '保存菜单信息失败' + res });
          });
        });
      },
      initForm() {//初始数据
        return {
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
        }
      },
      addDialog() {//新增
        this.title = "新增菜单";
        this.dialogMode = "save";
        this.form = this.initForm();
        this.show = true;
      },
      editDialog(row) {//修改
        this.title = "修改菜单";
        this.dialogMode = "update";
        this.form = {...row};
        this.show = true;
      },
    },
    components: {}
  }
</script>
<style></style>
