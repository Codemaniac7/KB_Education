import { defineStore } from 'pinia';
import { ref, reactive } from 'vue';
export const changeUserStore = defineStore('changeUser', () => {
    const refPrimitive = ref('ref를 화면에 뿌릴 때(primitive) StringPrimitive');
    const refObject = ref({ name: '정승민', 음식: '김치찌개', 운동: '테니스' });
    const reactiveObject = reactive({
        name: '정승민',
        음식: '김치찌개',
        운동: '테니스',
    });
    const changeRefPrimitive = () => {
        refPrimitive.value = 'changedStringPrimitive';
        console.log('Updated refPrimitive:', refPrimitive.value);
    };
    function changeRefObjectValue() {
        refObject.value.name = '장춘식';
        console.log(refObject);
    }
    function changeReactiveObjectValue() {
        reactiveObject.name = '장춘식';
        console.log(reactiveObject);
    }
    return {
        refPrimitive,
        refObject,
        reactiveObject,
        changeRefPrimitive,
        changeRefObjectValue,
        changeReactiveObjectValue,
    };
});
