<template>
  <div class="main">
    <cube-form :model="model" @submit="submitHandler">
      
      <cube-form-group>
          <!--名称-->
        <cube-form-item :field="fields[0]"></cube-form-item>
        <!--手机号-->
        <cube-form-item :field="fields[1]"></cube-form-item>
        <!--密码-->
        <cube-form-item :field="fields[2]"></cube-form-item>
      </cube-form-group>


      <cube-form-group>
        <cube-button type="submit">注册</cube-button>
      </cube-form-group>


    </cube-form>
    <router-link to="/login" class="reg">登录</router-link> 
  </div>
</template>

<script>
//注册接口
import { registerApi } from "@/api/getData.js";
export default {
  data() {
    return {
      model: {
        phoneValue: "",
        pwdValue: "",
        nameValue: ""
      },
      fields: [ {
          type: "input",
          modelKey: "nameValue",
          label: "名称",
          props: {
            placeholder: "请输入名称"
          },
          rules: {
            required: true
          },
          messages: {
            required: "名称不能为空"
          }
        },
        {
          type: "input",
          modelKey: "phoneValue",
          label: "手机号",
          props: {
            placeholder: "请输入手机"
          },
          rules: {
            required: true
          },
          messages: {
            required: "手机号不能为空"
          }
        },
        {
          type: "input",
          modelKey: "pwdValue",
          label: "密码",
          props: {
            placeholder: "请输入密码",
            type: "password",
            eye: {
              open: false
            }
          },
          rules: {
            required: true
          },
          messages: {
            required: "密码不能为空"
          }
        }
       
      ]
    };
  },
  methods: {
    submitHandler(e, model) {
      e.preventDefault();
      //调用注册接口
      registerApi(model.phoneValue, model.pwdValue, model.nameValue).then(
        res => {
          if (res.data.code === 0) {
            const toast = this.$createToast({
              txt: "注册成功,请登录",
              type: "correct",
              time: 3000
            });
            toast.show();
            this.$router.push({path:'/login'})
          }
        }
      );
    }
  }
};
</script>
<style lang="scss" scoped>
.main {
  padding: 50px 5% 0;
  text-align: center;
}
//注册
.cube-btn {
  margin-top: 20px;
}
// 登录
.reg {
  display: inline-block;
  margin-top: 30px;
  font-size: 18px;
}
</style>