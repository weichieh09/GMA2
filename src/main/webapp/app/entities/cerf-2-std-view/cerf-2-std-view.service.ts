import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { ICerf2StdView } from '@/shared/model/cerf-2-std-view.model';

const baseApiUrl = 'api/cerf-2-std-views';

export default class Cerf2StdViewService {
  public find(id: number): Promise<ICerf2StdView> {
    return new Promise<ICerf2StdView>((resolve, reject) => {
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
