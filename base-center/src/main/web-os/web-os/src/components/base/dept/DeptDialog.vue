/*admin_dept新增与修改,作者:高振中,日期:2018-12-14 09:36:53*/
<template>
  <Modal :title="title" v-model="show" :scrollable="false" :mask-closable="false" width="600" draggable >
    <Form :common="form" ref="form" :rules="rules" :label-width="100">
      <Row>
        <i-col>
          <!--<FormItem label="主键" prop="dept_id"><Input placeholder="主键" v-model="form.dept_id"/></FormItem>-->
          <FormItem label="上级ID" prop="parent_id"><Input placeholder="上级ID" v-model="form.parent_id"/></FormItem>
          <FormItem label="部门名称" prop="name"><Input placeholder="部门名称" v-model="form.name"/></FormItem>
          <FormItem label="可用标志" prop="enable"><Input placeholder="可用标志" v-model="form.enable"/></FormItem>
          <FormItem label="备注" prop="remark"><Input placeholder="备注" v-model="form.remark"/></FormItem>
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
          // dept_id : [
          //   {required: true, message: '请输入主键', trigger: 'blur'},
          //   {min: 1, max: 10, message: '主键长度不正确}', trigger: 'blur'},
          // ],
          parent_id : [
            {required: true, message: '请输入上级ID', trigger: 'blur'},
            {min: 1, max: 10, message: '上级ID长度不正确}', trigger: 'blur'},
          ],
          name : [
            {required: true, message: '请输入部门名称', trigger: 'blur'},
            {min: 1, max: 10, message: '部门名称长度不正确}', trigger: 'blur'},
          ],
          enable : [
            {required: true, message: '请输入可用标志', trigger: 'blur'},
            {min: 1, max: 10, message: '可用标志长度不正确}', trigger: 'blur'},
          ],
          remark : [
            {required: true, message: '请输入备注', trigger: 'blur'},
            {min: 1, max: 10, message: '备注长度不正确}', trigger: 'blur'},
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
          that.$http.post("/api/dept/" + that.dialogMode, JSON.stringify(that.form)).then(res => {
            that.show = false;
            that.refresh();
            Message.success({ content: '保存admin_dept信息成功'});
          }).catch(res => {
             Message.error({ content: '保存admin_dept信息失败' + res });
          });
        });
      },
      initForm() {//初始数据
        return {
          dept_id : null,// 主键
          parent_id : null,// 上级ID
          name : null,// 部门名称
          enable : null,// 可用标志
          remark : null,// 备注
        }
      },
      addDialog() {//新增
        this.title = "新增admin_dept";
        this.dialogMode = "save";
        this.form = this.initForm();
        this.show = true;
      },
      editDialog(row) {//修改
        this.title = "修改admin_dept";
        this.dialogMode = "update";
        this.form = {...row};
        this.show = true;
      },
    },
    components: {}
  }
</script>
<style></style>
