<script setup>
import { ref, reactive } from 'vue';
import { changeUserStore } from '@/stores/changeUser';
const store = changeUserStore();
const refPrimitive = store.refPrimitive;
const refObject = store.refObject;
const reactiveObject = store.reactiveObject;
const changeRefPrimitive = store.changeRefPrimitive;
const changeRefObjectValue = store.changeRefObjectValue;
const changeReactiveObjectValue = store.changeReactiveObjectValue;
</script>
<template>
    <h1 style="margin-bottom: 30px">게시판 페이지</h1>
    <div>
        {{ refPrimitive }}
        <input type="button" value="변경" @click="changeRefPrimitive"></input>
    </div>
    <div>
        <p>ref를 화면에 뿌릴 때(Object): {{ refObject.name }}</p>
        <input type="button" value="변경" @click="changeRefObjectValue"></input>
    </div>
    <div>
        <p>reactive를 화면에 뿌릴 때(primitive): {{ reactiveObject.name }}</p>
        <input type="button" value="변경" @click="changeReactiveObjectValue"></input>
    </div>
</template>
<style>
div>p {
    display: inline-block;
}
input {
    outline: none;
    border: none;
    width: 200px;
    margin-bottom: 10px;
}
input[type='button'] {
    background-color: #4CAF50;
    width: 50px;
    margin-left: 20px;
    color: white;
    padding: 5px 10px;
    cursor: pointer;
}
</style>