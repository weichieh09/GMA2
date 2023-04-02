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
const FeeProdCerfCompany = () => import('@/entities/fee-prod-cerf-company/fee-prod-cerf-company.vue');
// prettier-ignore
const FeeProdCerfCompanyUpdate = () => import('@/entities/fee-prod-cerf-company/fee-prod-cerf-company-update.vue');
// prettier-ignore
const FeeProdCerfCompanyDetails = () => import('@/entities/fee-prod-cerf-company/fee-prod-cerf-company-details.vue');
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
// prettier-ignore
const ProdCountry = () => import('@/entities/prod-country/prod-country.vue');
// prettier-ignore
const ProdCountryUpdate = () => import('@/entities/prod-country/prod-country-update.vue');
// prettier-ignore
const ProdCountryDetails = () => import('@/entities/prod-country/prod-country-details.vue');
// prettier-ignore
const ProdStd = () => import('@/entities/prod-std/prod-std.vue');
// prettier-ignore
const ProdStdUpdate = () => import('@/entities/prod-std/prod-std-update.vue');
// prettier-ignore
const ProdStdDetails = () => import('@/entities/prod-std/prod-std-details.vue');
// prettier-ignore
const CerfProd = () => import('@/entities/cerf-prod/cerf-prod.vue');
// prettier-ignore
const CerfProdUpdate = () => import('@/entities/cerf-prod/cerf-prod-update.vue');
// prettier-ignore
const CerfProdDetails = () => import('@/entities/cerf-prod/cerf-prod-details.vue');
// prettier-ignore
const CerfStd = () => import('@/entities/cerf-std/cerf-std.vue');
// prettier-ignore
const CerfStdUpdate = () => import('@/entities/cerf-std/cerf-std-update.vue');
// prettier-ignore
const CerfStdDetails = () => import('@/entities/cerf-std/cerf-std-details.vue');
// prettier-ignore
const CountryStd = () => import('@/entities/country-std/country-std.vue');
// prettier-ignore
const CountryStdUpdate = () => import('@/entities/country-std/country-std-update.vue');
// prettier-ignore
const CountryStdDetails = () => import('@/entities/country-std/country-std-details.vue');
// prettier-ignore
const CerfMark = () => import('@/entities/cerf-mark/cerf-mark.vue');
// prettier-ignore
const CerfMarkUpdate = () => import('@/entities/cerf-mark/cerf-mark-update.vue');
// prettier-ignore
const CerfMarkDetails = () => import('@/entities/cerf-mark/cerf-mark-details.vue');
// prettier-ignore
const StickerMark = () => import('@/entities/sticker-mark/sticker-mark.vue');
// prettier-ignore
const StickerMarkUpdate = () => import('@/entities/sticker-mark/sticker-mark-update.vue');
// prettier-ignore
const StickerMarkDetails = () => import('@/entities/sticker-mark/sticker-mark-details.vue');
// prettier-ignore
const CountryCert = () => import('@/entities/country-cert/country-cert.vue');
// prettier-ignore
const CountryCertUpdate = () => import('@/entities/country-cert/country-cert-update.vue');
// prettier-ignore
const CountryCertDetails = () => import('@/entities/country-cert/country-cert-details.vue');
// prettier-ignore
const ProdSticker = () => import('@/entities/prod-sticker/prod-sticker.vue');
// prettier-ignore
const ProdStickerUpdate = () => import('@/entities/prod-sticker/prod-sticker-update.vue');
// prettier-ignore
const ProdStickerDetails = () => import('@/entities/prod-sticker/prod-sticker-details.vue');
// prettier-ignore
const CountryMark = () => import('@/entities/country-mark/country-mark.vue');
// prettier-ignore
const CountryMarkUpdate = () => import('@/entities/country-mark/country-mark-update.vue');
// prettier-ignore
const CountryMarkDetails = () => import('@/entities/country-mark/country-mark-details.vue');
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
      path: 'fee-prod-cerf-company',
      name: 'FeeProdCerfCompany',
      component: FeeProdCerfCompany,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'fee-prod-cerf-company/new',
      name: 'FeeProdCerfCompanyCreate',
      component: FeeProdCerfCompanyUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'fee-prod-cerf-company/:feeProdCerfCompanyId/edit',
      name: 'FeeProdCerfCompanyEdit',
      component: FeeProdCerfCompanyUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'fee-prod-cerf-company/:feeProdCerfCompanyId/view',
      name: 'FeeProdCerfCompanyView',
      component: FeeProdCerfCompanyDetails,
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
    {
      path: 'prod-country',
      name: 'ProdCountry',
      component: ProdCountry,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-country/new',
      name: 'ProdCountryCreate',
      component: ProdCountryUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-country/:prodCountryId/edit',
      name: 'ProdCountryEdit',
      component: ProdCountryUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-country/:prodCountryId/view',
      name: 'ProdCountryView',
      component: ProdCountryDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-std',
      name: 'ProdStd',
      component: ProdStd,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-std/new',
      name: 'ProdStdCreate',
      component: ProdStdUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-std/:prodStdId/edit',
      name: 'ProdStdEdit',
      component: ProdStdUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-std/:prodStdId/view',
      name: 'ProdStdView',
      component: ProdStdDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-prod',
      name: 'CerfProd',
      component: CerfProd,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-prod/new',
      name: 'CerfProdCreate',
      component: CerfProdUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-prod/:cerfProdId/edit',
      name: 'CerfProdEdit',
      component: CerfProdUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-prod/:cerfProdId/view',
      name: 'CerfProdView',
      component: CerfProdDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-std',
      name: 'CerfStd',
      component: CerfStd,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-std/new',
      name: 'CerfStdCreate',
      component: CerfStdUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-std/:cerfStdId/edit',
      name: 'CerfStdEdit',
      component: CerfStdUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-std/:cerfStdId/view',
      name: 'CerfStdView',
      component: CerfStdDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'country-std',
      name: 'CountryStd',
      component: CountryStd,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'country-std/new',
      name: 'CountryStdCreate',
      component: CountryStdUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'country-std/:countryStdId/edit',
      name: 'CountryStdEdit',
      component: CountryStdUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'country-std/:countryStdId/view',
      name: 'CountryStdView',
      component: CountryStdDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-mark',
      name: 'CerfMark',
      component: CerfMark,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-mark/new',
      name: 'CerfMarkCreate',
      component: CerfMarkUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-mark/:cerfMarkId/edit',
      name: 'CerfMarkEdit',
      component: CerfMarkUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'cerf-mark/:cerfMarkId/view',
      name: 'CerfMarkView',
      component: CerfMarkDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'sticker-mark',
      name: 'StickerMark',
      component: StickerMark,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'sticker-mark/new',
      name: 'StickerMarkCreate',
      component: StickerMarkUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'sticker-mark/:stickerMarkId/edit',
      name: 'StickerMarkEdit',
      component: StickerMarkUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'sticker-mark/:stickerMarkId/view',
      name: 'StickerMarkView',
      component: StickerMarkDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'country-cert',
      name: 'CountryCert',
      component: CountryCert,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'country-cert/new',
      name: 'CountryCertCreate',
      component: CountryCertUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'country-cert/:countryCertId/edit',
      name: 'CountryCertEdit',
      component: CountryCertUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'country-cert/:countryCertId/view',
      name: 'CountryCertView',
      component: CountryCertDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-sticker',
      name: 'ProdSticker',
      component: ProdSticker,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-sticker/new',
      name: 'ProdStickerCreate',
      component: ProdStickerUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-sticker/:prodStickerId/edit',
      name: 'ProdStickerEdit',
      component: ProdStickerUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'prod-sticker/:prodStickerId/view',
      name: 'ProdStickerView',
      component: ProdStickerDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'country-mark',
      name: 'CountryMark',
      component: CountryMark,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'country-mark/new',
      name: 'CountryMarkCreate',
      component: CountryMarkUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'country-mark/:countryMarkId/edit',
      name: 'CountryMarkEdit',
      component: CountryMarkUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'country-mark/:countryMarkId/view',
      name: 'CountryMarkView',
      component: CountryMarkDetails,
      meta: { authorities: [Authority.USER] },
    },
    // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
  ],
};
