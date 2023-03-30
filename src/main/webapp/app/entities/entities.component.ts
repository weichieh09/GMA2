import { Component, Provide, Vue } from 'vue-property-decorator';

import UserService from '@/entities/user/user.service';
import ProdService from './prod/prod.service';
import CountryService from './country/country.service';
import CerfService from './cerf/cerf.service';
import StdService from './std/std.service';
import MarkService from './mark/mark.service';
import CompanyService from './company/company.service';
import FeeService from './fee/fee.service';
import CerfCompanyService from './cerf-company/cerf-company.service';
import StickerService from './sticker/sticker.service';
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
  @Provide('feeService') private feeService = () => new FeeService();
  @Provide('cerfCompanyService') private cerfCompanyService = () => new CerfCompanyService();
  @Provide('stickerService') private stickerService = () => new StickerService();
  // jhipster-needle-add-entity-service-to-entities-component - JHipster will import entities services here
}
