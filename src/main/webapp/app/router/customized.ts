import { Authority } from '@/shared/security/authority';

const Wcc101 = () => import('@/customized/wcc101/index.vue');
const Wcc201 = () => import('@/customized/wcc201/index.vue');
const Wcc311 = () => import('@/customized/wcc310/wcc311.vue');
const Wcc312 = () => import('@/customized/wcc310/wcc312.vue');

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
  {
    path: '/wcc311',
    name: 'Wcc311',
    component: Wcc311,
  },
  {
    path: '/wcc312',
    name: 'Wcc312',
    component: Wcc312,
  },
];
