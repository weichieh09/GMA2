/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import CerfComponent from '@/entities/cerf/cerf.vue';
import CerfClass from '@/entities/cerf/cerf.component';
import CerfService from '@/entities/cerf/cerf.service';
import AlertService from '@/shared/alert/alert.service';

const localVue = createLocalVue();
localVue.use(ToastPlugin);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('Cerf Management Component', () => {
    let wrapper: Wrapper<CerfClass>;
    let comp: CerfClass;
    let cerfServiceStub: SinonStubbedInstance<CerfService>;

    beforeEach(() => {
      cerfServiceStub = sinon.createStubInstance<CerfService>(CerfService);
      cerfServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<CerfClass>(CerfComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          cerfService: () => cerfServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      cerfServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllCerfs();
      await comp.$nextTick();

      // THEN
      expect(cerfServiceStub.retrieve.called).toBeTruthy();
      expect(comp.cerfs[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      cerfServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(cerfServiceStub.retrieve.callCount).toEqual(1);

      comp.removeCerf();
      await comp.$nextTick();

      // THEN
      expect(cerfServiceStub.delete.called).toBeTruthy();
      expect(cerfServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
