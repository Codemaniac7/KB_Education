<script setup>
import { ref, reactive } from 'vue';

const refPrimitive = ref('ref를 화면에 뿌릴 때(primitive) StringPrimitive');
const refObject = ref({ 'name': '정승민', '음식': '김치찌개', '운동': '테니스' });
const reactiveObject = reactive({
    'name': '정승민',
    '음식': '김치찌개',
    '운동': '테니스'
});


// function changeRefPrimitive() {
//     refPrimitive.value = 'changedStringPrimitive';
//     console.log(refPrimitive);
// }
// function changeRefObjectValue() {
//     refObject.value.name = '장춘식';
//     console.log(refObject);
// }
// function changeReactiveObjectKey() {
//     reactiveObject.name = '장춘식';
//     console.log(reactiveObject);
// }


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
        <input type="button" value="변경" @click="changeReactiveObjectKey"></input>
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
    background-color: #4caf50;
    width: 50px;
    margin-left: 20px;
    color: white;
    padding: 5px 10px;
    cursor: pointer;
}
</style>
