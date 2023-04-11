import { Component, Provide, Vue } from 'vue-property-decorator';

import UserService from '@/entities/user/user.service';
import ProdService from './prod/prod.service';
import CountryService from './country/country.service';
import CerfService from './cerf/cerf.service';
import StdService from './std/std.service';
import MarkService from './mark/mark.service';
import CompanyService from './company/company.service';
import FeeProdCerfCompanyService from './fee-prod-cerf-company/fee-prod-cerf-company.service';
import CerfCompanyService from './cerf-company/cerf-company.service';
import StickerService from './sticker/sticker.service';
import ProdCountryService from './prod-country/prod-country.service';
import ProdStdService from './prod-std/prod-std.service';
import CerfProdService from './cerf-prod/cerf-prod.service';
import CerfStdService from './cerf-std/cerf-std.service';
import CountryStdService from './country-std/country-std.service';
import CerfMarkService from './cerf-mark/cerf-mark.service';
import StickerMarkService from './sticker-mark/sticker-mark.service';
import CountryCertService from './country-cert/country-cert.service';
import ProdStickerService from './prod-sticker/prod-sticker.service';
import CountryMarkService from './country-mark/country-mark.service';
import Wcc412ViewService from './wcc-412-view/wcc-412-view.service';
// jhipster-needle-add-entity-service-to-entities-component-import - JHipster will import entities services here

@Component
export default class Entities extends Vue {
  @Provide('userService') private userService = () => new UserService();
  @Provide('prodService') private prodService = () => new ProdService();
  @Provide('countryService') private countryService = () => new CountryService();
  @Provide('cerfService') private cerfService = () => new CerfService();
  @Provide('stdService') private stdService = () => new StdService();
  @Provide('markService') private markService = () => new MarkService();
  @Provide('companyService') private companyService = () => new CompanyService();
  @Provide('feeProdCerfCompanyService') private feeProdCerfCompanyService = () => new FeeProdCerfCompanyService();
  @Provide('cerfCompanyService') private cerfCompanyService = () => new CerfCompanyService();
  @Provide('stickerService') private stickerService = () => new StickerService();
  @Provide('prodCountryService') private prodCountryService = () => new ProdCountryService();
  @Provide('prodStdService') private prodStdService = () => new ProdStdService();
  @Provide('cerfProdService') private cerfProdService = () => new CerfProdService();
  @Provide('cerfStdService') private cerfStdService = () => new CerfStdService();
  @Provide('countryStdService') private countryStdService = () => new CountryStdService();
  @Provide('cerfMarkService') private cerfMarkService = () => new CerfMarkService();
  @Provide('stickerMarkService') private stickerMarkService = () => new StickerMarkService();
  @Provide('countryCertService') private countryCertService = () => new CountryCertService();
  @Provide('prodStickerService') private prodStickerService = () => new ProdStickerService();
  @Provide('countryMarkService') private countryMarkService = () => new CountryMarkService();
  @Provide('wcc412ViewService') private wcc412ViewService = () => new Wcc412ViewService();
  // jhipster-needle-add-entity-service-to-entities-component - JHipster will import entities services here
}
