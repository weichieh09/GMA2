import { ICerf } from '@/shared/model/cerf.model';
import { IMark } from '@/shared/model/mark.model';
import { IStd } from '@/shared/model/std.model';
import { IProd } from '@/shared/model/prod.model';

export interface ICountry {
  id?: number;
  countryNo?: string | null;
  enName?: string | null;
  chName?: string | null;
  cerfs?: ICerf[] | null;
  marks?: IMark[] | null;
  stds?: IStd[] | null;
  prods?: IProd[] | null;
}

export class Country implements ICountry {
  constructor(
    public id?: number,
    public countryNo?: string | null,
    public enName?: string | null,
    public chName?: string | null,
    public cerfs?: ICerf[] | null,
    public marks?: IMark[] | null,
    public stds?: IStd[] | null,
    public prods?: IProd[] | null
  ) {}
}
