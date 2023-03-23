/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import StdComponent from '@/entities/std/std.vue';
import StdClass from '@/entities/std/std.component';
import StdService from '@/entities/std/std.service';
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
  describe('Std Management Component', () => {
    let wrapper: Wrapper<StdClass>;
    let comp: StdClass;
    let stdServiceStub: SinonStubbedInstance<StdService>;

    beforeEach(() => {
      stdServiceStub = sinon.createStubInstance<StdService>(StdService);
      stdServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<StdClass>(StdComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          stdService: () => stdServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      stdServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllStds();
      await comp.$nextTick();

      // THEN
      expect(stdServiceStub.retrieve.called).toBeTruthy();
      expect(comp.stds[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      stdServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(stdServiceStub.retrieve.callCount).toEqual(1);

      comp.removeStd();
      await comp.$nextTick();

      // THEN
      expect(stdServiceStub.delete.called).toBeTruthy();
      expect(stdServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
