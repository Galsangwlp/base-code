// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import http from './util/http'
import VueCookie from 'vue-cookie'
import ElementUI from 'element-ui'
import iView from 'iview';
import {isAuth} from './util/index'
import 'element-ui/lib/theme-chalk/index.css';
import 'iview/dist/styles/iview.css'


//将$http绑定到全局
Vue.prototype.$http = http;
// 挂载权限方法
Vue.prototype.isAuth = isAuth
Vue.use(VueCookie)
Vue.use(ElementUI)
Vue.use(iView)

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
