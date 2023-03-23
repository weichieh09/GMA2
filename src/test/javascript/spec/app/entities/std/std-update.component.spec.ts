/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import StdUpdateComponent from '@/entities/std/std-update.vue';
import StdClass from '@/entities/std/std-update.component';
import StdService from '@/entities/std/std.service';

import ProdService from '@/entities/prod/prod.service';

import CerfService from '@/entities/cerf/cerf.service';

import CountryService from '@/entities/country/country.service';
import AlertService from '@/shared/alert/alert.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.use(ToastPlugin);
localVue.component('font-awesome-icon', {});
localVue.component('b-input-group', {});
localVue.component('b-input-group-prepend', {});
localVue.component('b-form-datepicker', {});
localVue.component('b-form-input', {});

describe('Component Tests', () => {
  describe('Std Management Update Component', () => {
    let wrapper: Wrapper<StdClass>;
    let comp: StdClass;
    let stdServiceStub: SinonStubbedInstance<StdService>;

    beforeEach(() => {
      stdServiceStub = sinon.createStubInstance<StdService>(StdService);

      wrapper = shallowMount<StdClass>(StdUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          stdService: () => stdServiceStub,
          alertService: () => new AlertService(),

          prodService: () =>
            sinon.createStubInstance<ProdService>(ProdService, {
              retrieve: sinon.stub().resolves({}),
            } as any),

          cerfService: () =>
            sinon.createStubInstance<CerfService>(CerfService, {
              retrieve: sinon.stub().resolves({}),
            } as any),

          countryService: () =>
            sinon.createStubInstance<CountryService>(CountryService, {
              retrieve: sinon.stub().resolves({}),
            } as any),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.std = entity;
        stdServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(stdServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.std = entity;
        stdServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(stdServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundStd = { id: 123 };
        stdServiceStub.find.resolves(foundStd);
        stdServiceStub.retrieve.resolves([foundStd]);

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
