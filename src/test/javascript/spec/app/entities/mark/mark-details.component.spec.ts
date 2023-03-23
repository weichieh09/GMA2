/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import MarkDetailComponent from '@/entities/mark/mark-details.vue';
import MarkClass from '@/entities/mark/mark-details.component';
import MarkService from '@/entities/mark/mark.service';
import router from '@/router';
import AlertService from '@/shared/alert/alert.service';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Mark Management Detail Component', () => {
    let wrapper: Wrapper<MarkClass>;
    let comp: MarkClass;
    let markServiceStub: SinonStubbedInstance<MarkService>;

    beforeEach(() => {
      markServiceStub = sinon.createStubInstance<MarkService>(MarkService);

      wrapper = shallowMount<MarkClass>(MarkDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { markService: () => markServiceStub, alertService: () => new AlertService() },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundMark = { id: 123 };
        markServiceStub.find.resolves(foundMark);

        // WHEN
        comp.retrieveMark(123);
        await comp.$nextTick();

        // THEN
        expect(comp.mark).toBe(foundMark);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundMark = { id: 123 };
        markServiceStub.find.resolves(foundMark);

        // WHEN
        comp.beforeRouteEnter({ params: { markId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.mark).toBe(foundMark);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
