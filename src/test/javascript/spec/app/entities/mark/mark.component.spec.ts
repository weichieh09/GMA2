/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import MarkComponent from '@/entities/mark/mark.vue';
import MarkClass from '@/entities/mark/mark.component';
import MarkService from '@/entities/mark/mark.service';
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
  describe('Mark Management Component', () => {
    let wrapper: Wrapper<MarkClass>;
    let comp: MarkClass;
    let markServiceStub: SinonStubbedInstance<MarkService>;

    beforeEach(() => {
      markServiceStub = sinon.createStubInstance<MarkService>(MarkService);
      markServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<MarkClass>(MarkComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          markService: () => markServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      markServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllMarks();
      await comp.$nextTick();

      // THEN
      expect(markServiceStub.retrieve.called).toBeTruthy();
      expect(comp.marks[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      markServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(markServiceStub.retrieve.callCount).toEqual(1);

      comp.removeMark();
      await comp.$nextTick();

      // THEN
      expect(markServiceStub.delete.called).toBeTruthy();
      expect(markServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
