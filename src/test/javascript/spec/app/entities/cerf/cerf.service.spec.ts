/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import { DATE_FORMAT } from '@/shared/date/filters';
import CerfService from '@/entities/cerf/cerf.service';
import { Cerf } from '@/shared/model/cerf.model';

const error = {
  response: {
    status: null,
    data: {
      type: null,
    },
  },
};

const axiosStub = {
  get: sinon.stub(axios, 'get'),
  post: sinon.stub(axios, 'post'),
  put: sinon.stub(axios, 'put'),
  patch: sinon.stub(axios, 'patch'),
  delete: sinon.stub(axios, 'delete'),
};

describe('Service Tests', () => {
  describe('Cerf Service', () => {
    let service: CerfService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new CerfService();
      currentDate = new Date();
      elemDefault = new Cerf(
        123,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'image/png',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        currentDate
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            issuDt: dayjs(currentDate).format(DATE_FORMAT),
            expDt: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault
        );
        axiosStub.get.resolves({ data: returnedFromService });

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });

      it('should not find an element', async () => {
        axiosStub.get.rejects(error);
        return service
          .find(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should create a Cerf', async () => {
        const returnedFromService = Object.assign(
          {
            id: 123,
            issuDt: dayjs(currentDate).format(DATE_FORMAT),
            expDt: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            issuDt: currentDate,
            expDt: currentDate,
          },
          returnedFromService
        );

        axiosStub.post.resolves({ data: returnedFromService });
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a Cerf', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a Cerf', async () => {
        const returnedFromService = Object.assign(
          {
            cerfNo: 'BBBBBB',
            cerfVer: 'BBBBBB',
            status: 'BBBBBB',
            pdf: 'BBBBBB',
            applId: 'BBBBBB',
            fctyId: 'BBBBBB',
            mnfctrId: 'BBBBBB',
            issuDt: dayjs(currentDate).format(DATE_FORMAT),
            expDt: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            issuDt: currentDate,
            expDt: currentDate,
          },
          returnedFromService
        );
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a Cerf', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a Cerf', async () => {
        const patchObject = Object.assign(
          {
            pdf: 'BBBBBB',
            fctyId: 'BBBBBB',
          },
          new Cerf()
        );
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign(
          {
            issuDt: currentDate,
            expDt: currentDate,
          },
          returnedFromService
        );
        axiosStub.patch.resolves({ data: returnedFromService });

        return service.partialUpdate(patchObject).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not partial update a Cerf', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of Cerf', async () => {
        const returnedFromService = Object.assign(
          {
            cerfNo: 'BBBBBB',
            cerfVer: 'BBBBBB',
            status: 'BBBBBB',
            pdf: 'BBBBBB',
            applId: 'BBBBBB',
            fctyId: 'BBBBBB',
            mnfctrId: 'BBBBBB',
            issuDt: dayjs(currentDate).format(DATE_FORMAT),
            expDt: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            issuDt: currentDate,
            expDt: currentDate,
          },
          returnedFromService
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of Cerf', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a Cerf', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a Cerf', async () => {
        axiosStub.delete.rejects(error);

        return service
          .delete(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });
    });
  });
});
