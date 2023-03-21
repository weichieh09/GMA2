import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { ICerf2ProdView } from '@/shared/model/cerf-2-prod-view.model';

const baseApiUrl = 'api/cerf-2-prod-views';

export default class Cerf2ProdViewService {
  public find(id: number): Promise<ICerf2ProdView> {
    return new Promise<ICerf2ProdView>((resolve, reject) => {
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
