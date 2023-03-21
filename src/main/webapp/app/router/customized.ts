import { Authority } from '@/shared/security/authority';

const Wcc101 = () => import('@/customized/wcc101/index.vue');
const Wcc102 = () => import('@/customized/wcc102/index.vue');
const Wcc111 = () => import('@/customized/wcc111/index.vue');

export default [
  {
    path: '/wcc101',
    name: 'Wcc101',
    component: Wcc101,
  },
  {
    path: '/wcc102',
    name: 'Wcc102',
    component: Wcc102,
  },
  {
    path: '/wcc111',
    name: 'Wcc111',
    component: Wcc111,
  },
];
