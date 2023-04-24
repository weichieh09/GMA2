import { Authority } from '@/shared/security/authority';

const Wcc101 = () => import('@/customized/wcc101/index.vue');
const Wcc201 = () => import('@/customized/wcc201/index.vue');
const Wcc311 = () => import('@/customized/wcc310/wcc311.vue');
const Wcc312 = () => import('@/customized/wcc310/wcc312.vue');
const Wcc313 = () => import('@/customized/wcc310/wcc313.vue');
const Wcc321 = () => import('@/customized/wcc320/wcc321.vue');
const Wcc412 = () => import('@/customized/wcc410/wcc412.vue');
const Wcc000 = () => import('@/customized/wcc000/wcc000.vue');
const Wcc421 = () => import('@/customized/wcc420/wcc421.vue');
const Wcc422 = () => import('@/customized/wcc420/wcc422.vue');

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
    path: '/wcc311/new',
    name: 'Wcc311New',
    component: Wcc311,
  },
  {
    path: '/wcc311/:cerfId/edit',
    name: 'Wcc311Edit',
    component: Wcc311,
  },
  {
    path: '/wcc313/:cerfId',
    name: 'Wcc313',
    component: Wcc313,
  },
  {
    path: '/wcc312',
    name: 'Wcc312',
    component: Wcc312,
  },
  {
    path: '/wcc321',
    name: 'Wcc321',
    component: Wcc321,
  },
  {
    path: '/wcc412',
    name: 'Wcc412',
    component: Wcc412,
  },
  {
    path: '/wcc000',
    name: 'Wcc000',
    component: Wcc000,
  },
  {
    path: '/wcc421',
    name: 'Wcc421',
    component: Wcc421,
  },
  {
    path: '/wcc422',
    name: 'Wcc422',
    component: Wcc422,
  },
];
