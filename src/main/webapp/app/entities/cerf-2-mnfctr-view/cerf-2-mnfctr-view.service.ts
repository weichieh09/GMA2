import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { ICerf2MnfctrView } from '@/shared/model/cerf-2-mnfctr-view.model';

const baseApiUrl = 'api/cerf-2-mnfctr-views';

export default class Cerf2MnfctrViewService {
  public find(id: number): Promise<ICerf2MnfctrView> {
    return new Promise<ICerf2MnfctrView>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public retrieve(paginationQuery?: any): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl + `?${buildPaginationQueryOpts(paginationQuery)}`)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
