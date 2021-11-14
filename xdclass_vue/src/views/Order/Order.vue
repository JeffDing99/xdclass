<template>
    <div class="main">
        <!--订单列表-->
        <div class="list" v-if="orders.length > 0">
            
            <div class="box" v-for="(item, index) of orders" :key="index">
                <router-link :to="{path:'/coursedetail', query:{ video_id : item.video_id }}">
                    <div class="smallbox">
                        
                        <div class="imgdiv">
                            <img :src="item.video_img" alt="小滴课堂课程图片"/>
                        </div>

                        <div class="textdiv">
                            <p class="title"> {{item.video_title}} </p>
                            <p class="price"> {{(item.total_fee / 100).toFixed(2)}}</p>
                        </div>

                    </div>
                </router-link>
            </div>

        </div>

        <div class="no_order" v-else>
            <p>暂未购买课程 </p>
        </div>

    <!--底部导航-->
        <common-footer></common-footer>

    </div>
</template>
<script>

import CommonFooter from '@/components/CommonFooter'
import { getOrderList } from "@/api/getData.js";

export default {

    components:{
        CommonFooter
    },

    data(){
        return{
            orders:[]
        }
    },

    methods:{
        //获取订单列表
    async getOrderList(){
        try{
            const result =  await getOrderList(this.$store.state.token)
            if(result.data.code == 0){
                this.orders = result.data.data || []
            }

        }catch(error){
            console.log(error)
        } 
    }

    },
    mounted(){
        this.getOrderList();
    }
    
}
</script>

<style lang="scss" scoped>
.list {
  padding: 0 20px;
}

// 视频个体
.box {
  padding: 20px 0;
  background-color: #fff;
  border-bottom: 1px solid #ddd;
  // 标题
  .title {
    font-size: 14px;
    margin-bottom: 15px;
  }
  // 订单详情
  .smallbox {
    //flex左右排列，两端对齐
    display: flex;
    justify-content: space-between;
    .imgdiv {
      width: 90px;
      height: 60px;
      flex-shrink: 0;
      img {
        width: 100%;
        height: 100%;
        border-radius: 10px;
      }
    }
    .textdiv p {
      margin-top: 10px;
      padding-left: 10px;
    }
  }
}

.no_order {
  margin-top: 50px;
  text-align: center;
}
</style>