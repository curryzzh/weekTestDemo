import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css';

Vue.use(ElementUI)
Vue.config.productionTip = false
import axios from "axios";
axios.defaults.baseURL = "http://localhost:8080/" ;
Vue.prototype.$axios = axios;
new Vue({
  render: h => h(App),
}).$mount('#app')
