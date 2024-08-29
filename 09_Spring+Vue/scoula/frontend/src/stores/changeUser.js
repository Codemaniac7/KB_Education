import { defineStore } from 'pinia';

export const changeUserStore = defineStore('changeUser', () => {
    function changeRefPrimitive() {
        refPrimitive.value = 'changedStringPrimitive';
        console.log(refPrimitive);
    }
    function changeRefObjectValue() {
        refObject.value.name = '장춘식';
        console.log(refObject);
    }
    function changeReactiveObjectKey() {
        reactiveObject.name = '장춘식';
        console.log(reactiveObject);
    }

    return { changeRefPrimitive, changeRefObjectValue, changeReactiveObjectKey };
});
