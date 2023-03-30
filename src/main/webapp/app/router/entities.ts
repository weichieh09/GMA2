import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore
const Entities = () => import('@/entities/entities.vue');

// prettier-ignore
const Prod = () => import('@/entities/prod/prod.vue');
// prettier-ignore
const ProdUpdate = () => import('@/entities/prod/prod-update.vue');
// prettier-ignore
const ProdDetails = () => import('@/entities/prod/prod-details.vue');
// prettier-ignore
const Country = () => import('@/entities/country/country.vue');
// prettier-ignore
const CountryUpdate = () => import('@/entities/country/country-update.vue');
// prettier-ignore
const CountryDetails = () => import('@/entities/country/country-details.vue');
// prettier-ignore
const Cerf = () => import('@/entities/cerf/cerf.vue');
// prettier-ignore
const CerfUpdate = () => import('@/entities/cerf/cerf-update.vue');
// prettier-ignore
const CerfDetails = () => import('@/entities/cerf/cerf-details.vue');
// prettier-ignore
const Std = () => import('@/entities/std/std.vue');
// prettier-ignore
const StdUpdate = () => import('@/entities/std/std-update.vue');
// prettier-ignore
const StdDetails = () => import('@/entities/std/std-details.vue');
// prettier-ignore
const Mark = () => import('@/entities/mark/mark.vue');
// prettier-ignore
const MarkUpdate = () => import('@/entities/mark/mark-update.vue');
// prettier-ignore
const MarkDetails = () => import('@/entities/mark/mark-details.vue');
// prettier-ignore
const Company = () => import('@/entities/company/company.vue');
// prettier-ignore
const CompanyUpdate = () => import('@/entities/company/company-update.vue');
// prettier-ignore
const CompanyDetails = () => import('@/entities/company/company-details.vue');
// prettier-ignore
const Fee = () => import('@/entities/fee/fee.vue');
// prettier-ignore
const FeeUpdate = () => import('@/entities/fee/fee-update.vue');
// prettier-ignore
const FeeDetails = () => import('@/entities/fee/fee-details.vue');
// prettier-ignore
const CerfCompany = () => import('@/entities/cerf-company/cerf-company.vue');
// prettier-ignore
const CerfCompanyUpdate = () => import('@/entities/cerf-company/cerf-company-update.vue');
// prettier-ignore
const CerfCompanyDetails = () => import('@/entities/cerf-company/cerf-company-details.vue');
// prettier-ignore
const Sticker = () => import('@/entities/sticker/sticker.vue');
// prettier-ignore
const StickerUpdate = () => import('@/entities/sticker/sticker-update.vue');
// prettier-ignore
const StickerDetails = () => import('@/entities/sticker/sticker-details.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default {
  path: '/',
  component: Entities,
  children: [
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
      path: 'country',
      name: 'Country',
      component: Country,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'country/new',
      name: 'CountryCreate',
      component: CountryUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'country/:countryId/edit',
      name: 'CountryEdit',
      component: CountryUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'country/:countryId/view',
      name: 'CountryView',
      component: CountryDetails,
      meta: { authorities: [Authority.USER] },
    },
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
      path: 'mark',
      name: 'Mark',
      component: Mark,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'mark/new',
      name: 'MarkCreate',
      component: MarkUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'mark/:markId/edit',
      name: 'MarkEdit',
      component: MarkUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'mark/:markId/view',
      name: 'MarkView',
      component: MarkDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'company',
      name: 'Company',
      component: Company,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'company/new',
      name: 'CompanyCreate',
      component: CompanyUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'company/:companyId/edit',
      name: 'CompanyEdit',
      component: CompanyUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'company/:companyId/view',
      name: 'CompanyView',
      component: CompanyDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'fee',
      name: 'Fee',
      component: Fee,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'fee/new',
      name: 'FeeCreate',
      component: FeeUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'fee/:feeId/edit',
      name: 'FeeEdit',
      component: FeeUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'fee/:feeId/view',
      name: 'FeeView',
      component: FeeDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-company',
      name: 'CerfCompany',
      component: CerfCompany,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-company/new',
      name: 'CerfCompanyCreate',
      component: CerfCompanyUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-company/:cerfCompanyId/edit',
      name: 'CerfCompanyEdit',
      component: CerfCompanyUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-company/:cerfCompanyId/view',
      name: 'CerfCompanyView',
      component: CerfCompanyDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'sticker',
      name: 'Sticker',
      component: Sticker,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'sticker/new',
      name: 'StickerCreate',
      component: StickerUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'sticker/:stickerId/edit',
      name: 'StickerEdit',
      component: StickerUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'sticker/:stickerId/view',
      name: 'StickerView',
      component: StickerDetails,
      meta: { authorities: [Authority.USER] },
    },
    // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
  ],
};
