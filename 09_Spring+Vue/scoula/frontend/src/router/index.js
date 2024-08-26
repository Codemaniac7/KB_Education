import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../pages/HomePage.vue';
import authRoutes from './auth';
import boardRoutes from './board';
import travelRoutes from './travel';
import galleryRoutes from './gallery';
import qnaRoutes from './qna';

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'home',
            component: HomePage,
        },
        ...authRoutes,
        ...boardRoutes,
        ...travelRoutes,
        ...galleryRoutes,
        ...qnaRoutes,
    ],
});

export default router;
