import { Component, Provide, Vue } from 'vue-property-decorator';

import UserService from '@/entities/user/user.service';
import CerfService from './cerf/cerf.service';
import CerfFeeService from './cerf-fee/cerf-fee.service';
import MnfctrService from './mnfctr/mnfctr.service';
import ProdService from './prod/prod.service';
import Prod2CerfService from './prod-2-cerf/prod-2-cerf.service';
import StdService from './std/std.service';
import AreaDescService from './area-desc/area-desc.service';
import CerfImgService from './cerf-img/cerf-img.service';
import Cref2StdService from './cref-2-std/cref-2-std.service';
import FeeDescService from './fee-desc/fee-desc.service';
import MnfctrFeeService from './mnfctr-fee/mnfctr-fee.service';
import Prod2FctyService from './prod-2-fcty/prod-2-fcty.service';
import Prod2StdService from './prod-2-std/prod-2-std.service';
import StdFeeService from './std-fee/std-fee.service';
import StsDescService from './sts-desc/sts-desc.service';
// jhipster-needle-add-entity-service-to-entities-component-import - JHipster will import entities services here

@Component
export default class Entities extends Vue {
  @Provide('userService') private userService = () => new UserService();
  @Provide('cerfService') private cerfService = () => new CerfService();
  @Provide('cerfFeeService') private cerfFeeService = () => new CerfFeeService();
  @Provide('mnfctrService') private mnfctrService = () => new MnfctrService();
  @Provide('prodService') private prodService = () => new ProdService();
  @Provide('prod2CerfService') private prod2CerfService = () => new Prod2CerfService();
  @Provide('stdService') private stdService = () => new StdService();
  @Provide('areaDescService') private areaDescService = () => new AreaDescService();
  @Provide('cerfImgService') private cerfImgService = () => new CerfImgService();
  @Provide('cref2StdService') private cref2StdService = () => new Cref2StdService();
  @Provide('feeDescService') private feeDescService = () => new FeeDescService();
  @Provide('mnfctrFeeService') private mnfctrFeeService = () => new MnfctrFeeService();
  @Provide('prod2FctyService') private prod2FctyService = () => new Prod2FctyService();
  @Provide('prod2StdService') private prod2StdService = () => new Prod2StdService();
  @Provide('stdFeeService') private stdFeeService = () => new StdFeeService();
  @Provide('stsDescService') private stsDescService = () => new StsDescService();
  // jhipster-needle-add-entity-service-to-entities-component - JHipster will import entities services here
}
