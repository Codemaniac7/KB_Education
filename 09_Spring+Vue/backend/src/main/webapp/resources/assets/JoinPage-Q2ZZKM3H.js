import{a as _,c,r as h,o as w,e as y,f as s,h as t,n as j,t as g,w as i,v as r,j as k,i as x,k as D}from"./index-CuHKsysv.js";import{a as d}from"./authApi-DNFIyFm9.js";import"./index-CNflFJFo.js";const I={class:"mt-5 mx-auto",style:{width:"500px"}},U=s("h1",{class:"my-5"},[s("i",{class:"fa-solid fa-user-plus"}),t(" 회원 가입 ")],-1),V={class:"mb-3 mt-3"},S={for:"username",class:"form-label"},B=s("i",{class:"fa-solid fa-user"},null,-1),E=s("label",{for:"avatar",class:"form-label"},[s("i",{class:"fa-solid fa-user-astronaut"}),t(" 아바타 이미지: ")],-1),M={class:"mb-3 mt-3"},N=s("label",{for:"email",class:"form-label"},[s("i",{class:"fa-solid fa-envelope"}),t(" email ")],-1),C={class:"mb-3"},T=s("label",{for:"password",class:"form-label"},[s("i",{class:"fa-solid fa-lock"}),t(" 비밀번호: ")],-1),z={class:"mb-3"},A=s("label",{for:"password",class:"form-label"},[s("i",{class:"fa-solid fa-lock"}),t(" 비밀번호 확인: ")],-1),J={class:"mb-3"},P=s("label",{for:"mbti",class:"form-label"},[s("i",{class:"fa-solid fa-lock"}),t(" mbti: ")],-1),R=D('<option value="istp">istp</option><option value="istj">istj</option><option value="intp">intp</option><option value="intj">intj</option><option value="isfp">isfp</option><option value="isfj">isfj</option><option value="entp">entp</option><option value="enfj">enfj</option><option value="enfp">enfp</option><option value="estj">estj</option><option value="estp">estp</option><option value="esfp">esfp</option><option value="esfj">esfj</option>',13),q=[R],F=["disabled"],G=s("i",{class:"fa-solid fa-user-plus"},null,-1),Q={__name:"JoinPage",setup(H){const m=_(),p=c(null),n=c(""),e=h({username:"hong",email:"hong@gmail.com",password:"12",password2:"12",avatar:null,mbti:"istp"}),l=c(!0),f=async()=>{if(!e.username)return alert("사용자 ID를 입력하세요.");l.value=await d.checkUsername(e.username),console.log(l.value,typeof l.value),n.value=l.value?"이미 사용중인 ID입니다.":"사용가능한 ID입니다."},v=()=>{l.value=!0,e.username?n.value="ID 중복 체크를 하셔야 합니다.":n.value=""},b=async()=>{if(e.password!=e.password2)return alert("비밀번호가 일치하지 않습니다.");p.value.files.length>0&&(e.avatar=p.value.files[0]);try{await d.create(e),m.push({name:"home"})}catch(u){console.error(u)}};return(u,o)=>(w(),y("div",I,[U,s("form",{onSubmit:x(b,["prevent"])},[s("div",V,[s("label",S,[B,t(" 사용자 ID : "),s("button",{type:"button",class:"btn btn-success btn-sm py-0 me-2",onClick:f},"ID 중복 확인"),s("span",{class:j(l.value.value?"text-primary":"text-danger")},g(n.value),3)]),i(s("input",{type:"text",class:"form-control",placeholder:"사용자 ID",id:"username",onInput:v,"onUpdate:modelValue":o[0]||(o[0]=a=>e.username=a)},null,544),[[r,e.username]])]),s("div",null,[E,s("input",{type:"file",class:"form-control",ref_key:"avatar",ref:p,id:"avatar",accept:"image/png, image/jpeg"},null,512)]),s("div",M,[N,i(s("input",{type:"email",class:"form-control",placeholder:"Email",id:"email","onUpdate:modelValue":o[1]||(o[1]=a=>e.email=a)},null,512),[[r,e.email]])]),s("div",C,[T,i(s("input",{type:"password",class:"form-control",placeholder:"비밀번호",id:"password","onUpdate:modelValue":o[2]||(o[2]=a=>e.password=a)},null,512),[[r,e.password]])]),s("div",z,[A,i(s("input",{type:"password",class:"form-control",placeholder:"비밀번호 확인",id:"password2","onUpdate:modelValue":o[3]||(o[3]=a=>e.password2=a)},null,512),[[r,e.password2]])]),s("div",J,[P,i(s("select",{name:"mbti",id:"mbti","onUpdate:modelValue":o[4]||(o[4]=a=>e.mbti=a)},q,512),[[k,e.mbti]])]),s("button",{type:"submit",class:"btn btn-primary mt-4",disabled:l.value},[G,t(" 확인 ")],8,F)],32)]))}};export{Q as default};
