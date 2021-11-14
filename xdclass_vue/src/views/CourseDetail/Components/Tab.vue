<template>
    
    <div>
        <cube-tab-bar v-model="selectedLabel" show-slider>
            <cube-tab v-for="item in tabs" :label="item.label" :key="item.label">
            </cube-tab>
        </cube-tab-bar>
        
        <component :videoInfo="videoInfo" :chapterList="chapterList" :is='selectedLabel==="简介"?"Summary":"Catalog" '>
        </component>

    </div>

</template>

<script>
import Summary from './Summary'
import Catalog from './Catalog'

export default {

    components:{
        Summary,
        Catalog
    },

    props:{
        videoInfo:{
            type:Object,
            required:true
        },
        chapterList:{
            type:Array,
            required:true
        }

    },

    data(){
        return{
            selectedLabel:"简介",
            tabs:[
                {
                    label:"简介"
                },{
                    label:"目录"
                }
            ]
        }
    }
}
</script>