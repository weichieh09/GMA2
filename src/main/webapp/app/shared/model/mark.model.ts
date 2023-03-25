import { ICountry } from '@/shared/model/country.model';
import { IProd } from '@/shared/model/prod.model';

export interface IMark {
  id?: number;
  markNo?: string | null;
  enName?: string | null;
  chName?: string | null;
  imgContentType?: string | null;
  img?: string | null;
  country?: ICountry | null;
  prods?: IProd[] | null;
}

export class Mark implements IMark {
  constructor(
    public id?: number,
    public markNo?: string | null,
    public enName?: string | null,
    public chName?: string | null,
    public imgContentType?: string | null,
    public img?: string | null,
    public country?: ICountry | null,
    public prods?: IProd[] | null
  ) {}
}
