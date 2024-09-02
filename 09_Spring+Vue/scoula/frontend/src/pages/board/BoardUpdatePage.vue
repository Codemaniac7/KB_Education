<script setup>
import { ref, reactive } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import boardApi from '@/api/boardApi';
const cr = useRoute();
const router = useRouter();
const no = cr.params.no;
const article = reactive({});
const attachments = ref([]);
const orgArticle = ref({});
const files = ref(null);
const back = () => {
    router.push({ name: 'board/detail', params: { no } });
};
const removeFile = async (no, filename) => {
    if (!confirm(filename + '을 삭제할까요?')) return;
    await boardApi.deleteAttachment(no);
    const ix = attachments.value.findIndex((f) => f.no === no);
    attachments.value.splice(ix, 1);
};
const submit = async () => {
    if (!confirm('수정할까요?')) return;
    if (files.value.files.length > 0) {
        article.files = files.value.files;
    }
    await boardApi.update(article);
    router.push({ name: 'board/detail', params: { no }, query: cr.query });
};

const reset = () => {
    article.no = orgArticle.value.no;
    article.title = orgArticle.value.title;
    article.writer = orgArticle.value.writer;
    article.content = orgArticle.value.content;
    console.log(article);
};
const load = async () => {
    const data = await boardApi.get(no);
    orgArticle.value = { ...data };
    attachments.value = data.attaches;
    reset();
};
load();
</script>
