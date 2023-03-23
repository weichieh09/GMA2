/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import StdDetailComponent from '@/entities/std/std-details.vue';
import StdClass from '@/entities/std/std-details.component';
import StdService from '@/entities/std/std.service';
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
  describe('Std Management Detail Component', () => {
    let wrapper: Wrapper<StdClass>;
    let comp: StdClass;
    let stdServiceStub: SinonStubbedInstance<StdService>;

    beforeEach(() => {
      stdServiceStub = sinon.createStubInstance<StdService>(StdService);

      wrapper = shallowMount<StdClass>(StdDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { stdService: () => stdServiceStub, alertService: () => new AlertService() },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundStd = { id: 123 };
        stdServiceStub.find.resolves(foundStd);

        // WHEN
        comp.retrieveStd(123);
        await comp.$nextTick();

        // THEN
        expect(comp.std).toBe(foundStd);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundStd = { id: 123 };
        stdServiceStub.find.resolves(foundStd);

        // WHEN
        comp.beforeRouteEnter({ params: { stdId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.std).toBe(foundStd);
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
