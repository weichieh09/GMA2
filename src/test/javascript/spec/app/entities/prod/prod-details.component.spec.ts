/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import ProdDetailComponent from '@/entities/prod/prod-details.vue';
import ProdClass from '@/entities/prod/prod-details.component';
import ProdService from '@/entities/prod/prod.service';
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
  describe('Prod Management Detail Component', () => {
    let wrapper: Wrapper<ProdClass>;
    let comp: ProdClass;
    let prodServiceStub: SinonStubbedInstance<ProdService>;

    beforeEach(() => {
      prodServiceStub = sinon.createStubInstance<ProdService>(ProdService);

      wrapper = shallowMount<ProdClass>(ProdDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { prodService: () => prodServiceStub, alertService: () => new AlertService() },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundProd = { id: 123 };
        prodServiceStub.find.resolves(foundProd);

        // WHEN
        comp.retrieveProd(123);
        await comp.$nextTick();

        // THEN
        expect(comp.prod).toBe(foundProd);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundProd = { id: 123 };
        prodServiceStub.find.resolves(foundProd);

        // WHEN
        comp.beforeRouteEnter({ params: { prodId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.prod).toBe(foundProd);
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
