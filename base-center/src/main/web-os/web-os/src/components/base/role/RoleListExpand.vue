/*admin_role列表扩展,作者:高振中,日期:2018-12-14 09:36:53*/
<template>
  <div>
    <Row class="expand-row">
      <i-col span="6">
        <span class="expand-key">主键</span>
        <span class="expand-value">{{row.id}}</span>
      </i-col>
      <i-col span="6">
        <span class="expand-key">名称</span>
        <span class="expand-value">{{row.name}}</span>
      </i-col>
      <i-col span="6">
        <span class="expand-key">备注</span>
        <span class="expand-value">{{row.remark}}</span>
      </i-col>
    </Row>
  </div>
</template>
<script>
  export default {
    props: {row: Object}
  };
</script>
<style scoped>
  .expand-row {
    margin-bottom: 6px;
  }
  .expand-key {
    font-weight: bold;
    line-height: 25px;
  }
  .expand-value {}
</style>
