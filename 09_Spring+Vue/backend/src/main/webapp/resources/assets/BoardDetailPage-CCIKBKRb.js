import{_ as C,b as x,u as D,a as B,c as S,o as l,e as r,f as t,t as c,h as n,x as f,F as _,s as I,g as Y,y as q,z as F}from"./index-CuHKsysv.js";import{b}from"./boardApi-DA73oR28.js";import{h as N}from"./moment-C5S46NFB.js";import"./index-CNflFJFo.js";const R=async o=>{try{const e=document.createElement("a");e.href=o,document.body.appendChild(e),e.click(),document.body.removeChild(e)}catch(e){console.error(e)}},s=o=>(q("data-v-88c2d76e"),o=o(),F(),o),V={class:"my-3 d-flex justify-content-between"},A=s(()=>t("i",{class:"fa -solid fa -user"},null,-1)),E=s(()=>t("i",{class:"fa -regular fa -clock"},null,-1)),H=s(()=>t("hr",null,null,-1)),L={class:"text-end"},M=["onClick"],P=s(()=>t("i",{class:"fa -solid fa -paperclip"},null,-1)),j={class:"content"},z={class:"my-5"},T=s(()=>t("i",{class:"fa-solid fa-list"},null,-1)),U=s(()=>t("i",{class:"fa-regular fa-pen-to-square"},null,-1)),$=s(()=>t("i",{class:"fa-solid fa-trash-can"},null,-1)),G={__name:"BoardDetailPage",setup(o){const e=x(),p=D(),i=B(),d=p.params.no,a=S({}),v=()=>{i.push({name:"board/list",query:p.query})},y=()=>{i.push({name:"board/update",params:{no:d}})},k=async()=>{confirm("삭제할까요?")&&(await b.delete(d),i.push({name:"board/list"}))},w=async()=>{a.value=await b.get(d)},g=async m=>{const h="/api/board/download/"+m;await R(h)};return w(),(m,h)=>(l(),r(_,null,[t("h1",null,c(a.value.title),1),t("div",V,[t("div",null,[A,n(" "+c(a.value.writer),1)]),t("div",null,[E,n(" "+c(f(N)(a.value.updateDate).format("YYYY-MM-DD HH:mm")),1)])]),H,t("div",L,[(l(!0),r(_,null,I(a.value.attaches,u=>(l(),r("div",{key:u.no,class:"attach"},[t("span",{onClick:J=>g(u.no)},[P,n(" "+c(u.filename),1)],8,M)]))),128))]),t("div",j,c(a.value.content),1),t("div",z,[t("button",{class:"btn btn-primary me-2",onClick:v},[T,n(" 목록")]),f(e).username==a.value.writer?(l(),r(_,{key:0},[t("button",{class:"btn btn-primary me-2",onClick:y},[U,n(" 수정")]),t("button",{class:"btn btn-danger",onClick:k},[$,n(" 삭제")])],64)):Y("",!0)])],64))}},X=C(G,[["__scopeId","data-v-88c2d76e"]]);export{X as default};
