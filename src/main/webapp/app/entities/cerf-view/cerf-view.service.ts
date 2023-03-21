import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { ICerfView } from '@/shared/model/cerf-view.model';

const baseApiUrl = 'api/cerf-views';

export default class CerfViewService {
  public find(id: number): Promise<ICerfView> {
    return new Promise<ICerfView>((resolve, reject) => {
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
