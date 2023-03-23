/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import CerfUpdateComponent from '@/entities/cerf/cerf-update.vue';
import CerfClass from '@/entities/cerf/cerf-update.component';
import CerfService from '@/entities/cerf/cerf.service';

import ProdService from '@/entities/prod/prod.service';

import StdService from '@/entities/std/std.service';

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
  describe('Cerf Management Update Component', () => {
    let wrapper: Wrapper<CerfClass>;
    let comp: CerfClass;
    let cerfServiceStub: SinonStubbedInstance<CerfService>;

    beforeEach(() => {
      cerfServiceStub = sinon.createStubInstance<CerfService>(CerfService);

      wrapper = shallowMount<CerfClass>(CerfUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          cerfService: () => cerfServiceStub,
          alertService: () => new AlertService(),

          prodService: () =>
            sinon.createStubInstance<ProdService>(ProdService, {
              retrieve: sinon.stub().resolves({}),
            } as any),

          stdService: () =>
            sinon.createStubInstance<StdService>(StdService, {
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
        comp.cerf = entity;
        cerfServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(cerfServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.cerf = entity;
        cerfServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(cerfServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundCerf = { id: 123 };
        cerfServiceStub.find.resolves(foundCerf);
        cerfServiceStub.retrieve.resolves([foundCerf]);

        // WHEN
        comp.beforeRouteEnter({ params: { cerfId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.cerf).toBe(foundCerf);
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
