import { Authority } from '@/shared/security/authority';

const Wcc101 = () => import('@/customized/wcc101/index.vue');
const Wcc201 = () => import('@/customized/wcc201/index.vue');

export default [
  {
    path: '/wcc101',
    name: 'Wcc101',
    component: Wcc101,
  },
  {
    path: '/wcc201',
    name: 'Wcc201',
    component: Wcc201,
  },
];
