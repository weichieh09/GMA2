/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import ProdComponent from '@/entities/prod/prod.vue';
import ProdClass from '@/entities/prod/prod.component';
import ProdService from '@/entities/prod/prod.service';
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
  describe('Prod Management Component', () => {
    let wrapper: Wrapper<ProdClass>;
    let comp: ProdClass;
    let prodServiceStub: SinonStubbedInstance<ProdService>;

    beforeEach(() => {
      prodServiceStub = sinon.createStubInstance<ProdService>(ProdService);
      prodServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<ProdClass>(ProdComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          prodService: () => prodServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      prodServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllProds();
      await comp.$nextTick();

      // THEN
      expect(prodServiceStub.retrieve.called).toBeTruthy();
      expect(comp.prods[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      prodServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(prodServiceStub.retrieve.callCount).toEqual(1);

      comp.removeProd();
      await comp.$nextTick();

      // THEN
      expect(prodServiceStub.delete.called).toBeTruthy();
      expect(prodServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
