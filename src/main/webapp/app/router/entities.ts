import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore
const Entities = () => import('@/entities/entities.vue');

// prettier-ignore
const Cerf = () => import('@/entities/cerf/cerf.vue');
// prettier-ignore
const CerfUpdate = () => import('@/entities/cerf/cerf-update.vue');
// prettier-ignore
const CerfDetails = () => import('@/entities/cerf/cerf-details.vue');
// prettier-ignore
const CerfFee = () => import('@/entities/cerf-fee/cerf-fee.vue');
// prettier-ignore
const CerfFeeUpdate = () => import('@/entities/cerf-fee/cerf-fee-update.vue');
// prettier-ignore
const CerfFeeDetails = () => import('@/entities/cerf-fee/cerf-fee-details.vue');
// prettier-ignore
const Mnfctr = () => import('@/entities/mnfctr/mnfctr.vue');
// prettier-ignore
const MnfctrUpdate = () => import('@/entities/mnfctr/mnfctr-update.vue');
// prettier-ignore
const MnfctrDetails = () => import('@/entities/mnfctr/mnfctr-details.vue');
// prettier-ignore
const Prod = () => import('@/entities/prod/prod.vue');
// prettier-ignore
const ProdUpdate = () => import('@/entities/prod/prod-update.vue');
// prettier-ignore
const ProdDetails = () => import('@/entities/prod/prod-details.vue');
// prettier-ignore
const Prod2Cerf = () => import('@/entities/prod-2-cerf/prod-2-cerf.vue');
// prettier-ignore
const Prod2CerfUpdate = () => import('@/entities/prod-2-cerf/prod-2-cerf-update.vue');
// prettier-ignore
const Prod2CerfDetails = () => import('@/entities/prod-2-cerf/prod-2-cerf-details.vue');
// prettier-ignore
const Std = () => import('@/entities/std/std.vue');
// prettier-ignore
const StdUpdate = () => import('@/entities/std/std-update.vue');
// prettier-ignore
const StdDetails = () => import('@/entities/std/std-details.vue');
// prettier-ignore
const AreaDesc = () => import('@/entities/area-desc/area-desc.vue');
// prettier-ignore
const AreaDescUpdate = () => import('@/entities/area-desc/area-desc-update.vue');
// prettier-ignore
const AreaDescDetails = () => import('@/entities/area-desc/area-desc-details.vue');
// prettier-ignore
const CerfImg = () => import('@/entities/cerf-img/cerf-img.vue');
// prettier-ignore
const CerfImgUpdate = () => import('@/entities/cerf-img/cerf-img-update.vue');
// prettier-ignore
const CerfImgDetails = () => import('@/entities/cerf-img/cerf-img-details.vue');
// prettier-ignore
const Cref2Std = () => import('@/entities/cref-2-std/cref-2-std.vue');
// prettier-ignore
const Cref2StdUpdate = () => import('@/entities/cref-2-std/cref-2-std-update.vue');
// prettier-ignore
const Cref2StdDetails = () => import('@/entities/cref-2-std/cref-2-std-details.vue');
// prettier-ignore
const FeeDesc = () => import('@/entities/fee-desc/fee-desc.vue');
// prettier-ignore
const FeeDescUpdate = () => import('@/entities/fee-desc/fee-desc-update.vue');
// prettier-ignore
const FeeDescDetails = () => import('@/entities/fee-desc/fee-desc-details.vue');
// prettier-ignore
const MnfctrFee = () => import('@/entities/mnfctr-fee/mnfctr-fee.vue');
// prettier-ignore
const MnfctrFeeUpdate = () => import('@/entities/mnfctr-fee/mnfctr-fee-update.vue');
// prettier-ignore
const MnfctrFeeDetails = () => import('@/entities/mnfctr-fee/mnfctr-fee-details.vue');
// prettier-ignore
const Prod2Fcty = () => import('@/entities/prod-2-fcty/prod-2-fcty.vue');
// prettier-ignore
const Prod2FctyUpdate = () => import('@/entities/prod-2-fcty/prod-2-fcty-update.vue');
// prettier-ignore
const Prod2FctyDetails = () => import('@/entities/prod-2-fcty/prod-2-fcty-details.vue');
// prettier-ignore
const Prod2Std = () => import('@/entities/prod-2-std/prod-2-std.vue');
// prettier-ignore
const Prod2StdUpdate = () => import('@/entities/prod-2-std/prod-2-std-update.vue');
// prettier-ignore
const Prod2StdDetails = () => import('@/entities/prod-2-std/prod-2-std-details.vue');
// prettier-ignore
const StdFee = () => import('@/entities/std-fee/std-fee.vue');
// prettier-ignore
const StdFeeUpdate = () => import('@/entities/std-fee/std-fee-update.vue');
// prettier-ignore
const StdFeeDetails = () => import('@/entities/std-fee/std-fee-details.vue');
// prettier-ignore
const StsDesc = () => import('@/entities/sts-desc/sts-desc.vue');
// prettier-ignore
const StsDescUpdate = () => import('@/entities/sts-desc/sts-desc-update.vue');
// prettier-ignore
const StsDescDetails = () => import('@/entities/sts-desc/sts-desc-details.vue');
// prettier-ignore
const CerfSearchView = () => import('@/entities/cerf-search-view/cerf-search-view.vue');
// prettier-ignore
const CerfSearchViewDetails = () => import('@/entities/cerf-search-view/cerf-search-view-details.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default {
  path: '/',
  component: Entities,
  children: [
    {
      path: 'cerf',
      name: 'Cerf',
      component: Cerf,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf/new',
      name: 'CerfCreate',
      component: CerfUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf/:cerfId/edit',
      name: 'CerfEdit',
      component: CerfUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf/:cerfId/view',
      name: 'CerfView',
      component: CerfDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-fee',
      name: 'CerfFee',
      component: CerfFee,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-fee/new',
      name: 'CerfFeeCreate',
      component: CerfFeeUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-fee/:cerfFeeId/edit',
      name: 'CerfFeeEdit',
      component: CerfFeeUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-fee/:cerfFeeId/view',
      name: 'CerfFeeView',
      component: CerfFeeDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'mnfctr',
      name: 'Mnfctr',
      component: Mnfctr,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'mnfctr/new',
      name: 'MnfctrCreate',
      component: MnfctrUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'mnfctr/:mnfctrId/edit',
      name: 'MnfctrEdit',
      component: MnfctrUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'mnfctr/:mnfctrId/view',
      name: 'MnfctrView',
      component: MnfctrDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod',
      name: 'Prod',
      component: Prod,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod/new',
      name: 'ProdCreate',
      component: ProdUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod/:prodId/edit',
      name: 'ProdEdit',
      component: ProdUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod/:prodId/view',
      name: 'ProdView',
      component: ProdDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-2-cerf',
      name: 'Prod2Cerf',
      component: Prod2Cerf,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-2-cerf/new',
      name: 'Prod2CerfCreate',
      component: Prod2CerfUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-2-cerf/:prod2CerfId/edit',
      name: 'Prod2CerfEdit',
      component: Prod2CerfUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-2-cerf/:prod2CerfId/view',
      name: 'Prod2CerfView',
      component: Prod2CerfDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'std',
      name: 'Std',
      component: Std,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'std/new',
      name: 'StdCreate',
      component: StdUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'std/:stdId/edit',
      name: 'StdEdit',
      component: StdUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'std/:stdId/view',
      name: 'StdView',
      component: StdDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'area-desc',
      name: 'AreaDesc',
      component: AreaDesc,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'area-desc/new',
      name: 'AreaDescCreate',
      component: AreaDescUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'area-desc/:areaDescId/edit',
      name: 'AreaDescEdit',
      component: AreaDescUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'area-desc/:areaDescId/view',
      name: 'AreaDescView',
      component: AreaDescDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-img',
      name: 'CerfImg',
      component: CerfImg,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-img/new',
      name: 'CerfImgCreate',
      component: CerfImgUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-img/:cerfImgId/edit',
      name: 'CerfImgEdit',
      component: CerfImgUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-img/:cerfImgId/view',
      name: 'CerfImgView',
      component: CerfImgDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cref-2-std',
      name: 'Cref2Std',
      component: Cref2Std,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cref-2-std/new',
      name: 'Cref2StdCreate',
      component: Cref2StdUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cref-2-std/:cref2StdId/edit',
      name: 'Cref2StdEdit',
      component: Cref2StdUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cref-2-std/:cref2StdId/view',
      name: 'Cref2StdView',
      component: Cref2StdDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'fee-desc',
      name: 'FeeDesc',
      component: FeeDesc,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'fee-desc/new',
      name: 'FeeDescCreate',
      component: FeeDescUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'fee-desc/:feeDescId/edit',
      name: 'FeeDescEdit',
      component: FeeDescUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'fee-desc/:feeDescId/view',
      name: 'FeeDescView',
      component: FeeDescDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'mnfctr-fee',
      name: 'MnfctrFee',
      component: MnfctrFee,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'mnfctr-fee/new',
      name: 'MnfctrFeeCreate',
      component: MnfctrFeeUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'mnfctr-fee/:mnfctrFeeId/edit',
      name: 'MnfctrFeeEdit',
      component: MnfctrFeeUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'mnfctr-fee/:mnfctrFeeId/view',
      name: 'MnfctrFeeView',
      component: MnfctrFeeDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-2-fcty',
      name: 'Prod2Fcty',
      component: Prod2Fcty,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-2-fcty/new',
      name: 'Prod2FctyCreate',
      component: Prod2FctyUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-2-fcty/:prod2FctyId/edit',
      name: 'Prod2FctyEdit',
      component: Prod2FctyUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-2-fcty/:prod2FctyId/view',
      name: 'Prod2FctyView',
      component: Prod2FctyDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-2-std',
      name: 'Prod2Std',
      component: Prod2Std,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-2-std/new',
      name: 'Prod2StdCreate',
      component: Prod2StdUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-2-std/:prod2StdId/edit',
      name: 'Prod2StdEdit',
      component: Prod2StdUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-2-std/:prod2StdId/view',
      name: 'Prod2StdView',
      component: Prod2StdDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'std-fee',
      name: 'StdFee',
      component: StdFee,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'std-fee/new',
      name: 'StdFeeCreate',
      component: StdFeeUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'std-fee/:stdFeeId/edit',
      name: 'StdFeeEdit',
      component: StdFeeUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'std-fee/:stdFeeId/view',
      name: 'StdFeeView',
      component: StdFeeDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'sts-desc',
      name: 'StsDesc',
      component: StsDesc,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'sts-desc/new',
      name: 'StsDescCreate',
      component: StsDescUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'sts-desc/:stsDescId/edit',
      name: 'StsDescEdit',
      component: StsDescUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'sts-desc/:stsDescId/view',
      name: 'StsDescView',
      component: StsDescDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: '/cerf-search-view',
      name: 'CerfSearchView',
      component: CerfSearchView,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: '/cerf-search-view/:cerfSearchViewId/view',
      name: 'CerfSearchViewView',
      component: CerfSearchViewDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: '/cerf-search-view',
      name: 'CerfSearchView',
      component: CerfSearchView,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: '/cerf-search-view/:cerfSearchViewId/view',
      name: 'CerfSearchViewView',
      component: CerfSearchViewDetails,
      meta: { authorities: [Authority.USER] },
    },
    // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
  ],
};
