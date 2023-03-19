import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { ICerfSearchView } from '@/shared/model/cerf-search-view.model';

const baseApiUrl = 'api/cerf-search-views';

export default class CerfSearchViewService {
  public find(id: number): Promise<ICerfSearchView> {
    return new Promise<ICerfSearchView>((resolve, reject) => {
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
