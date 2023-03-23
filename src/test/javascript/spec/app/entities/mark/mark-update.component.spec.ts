/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import MarkUpdateComponent from '@/entities/mark/mark-update.vue';
import MarkClass from '@/entities/mark/mark-update.component';
import MarkService from '@/entities/mark/mark.service';

import CountryService from '@/entities/country/country.service';

import ProdService from '@/entities/prod/prod.service';
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
  describe('Mark Management Update Component', () => {
    let wrapper: Wrapper<MarkClass>;
    let comp: MarkClass;
    let markServiceStub: SinonStubbedInstance<MarkService>;

    beforeEach(() => {
      markServiceStub = sinon.createStubInstance<MarkService>(MarkService);

      wrapper = shallowMount<MarkClass>(MarkUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          markService: () => markServiceStub,
          alertService: () => new AlertService(),

          countryService: () =>
            sinon.createStubInstance<CountryService>(CountryService, {
              retrieve: sinon.stub().resolves({}),
            } as any),

          prodService: () =>
            sinon.createStubInstance<ProdService>(ProdService, {
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
        comp.mark = entity;
        markServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(markServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.mark = entity;
        markServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(markServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundMark = { id: 123 };
        markServiceStub.find.resolves(foundMark);
        markServiceStub.retrieve.resolves([foundMark]);

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
