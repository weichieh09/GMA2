import { IProd } from '@/shared/model/prod.model';
import { ICerf } from '@/shared/model/cerf.model';
import { ICountry } from '@/shared/model/country.model';

export interface IStd {
  id?: number;
  stdNo?: string | null;
  stdVer?: string | null;
  name?: string | null;
  status?: string | null;
  fee?: number | null;
  issuDt?: Date | null;
  expDt?: Date | null;
  prods?: IProd[] | null;
  cerfs?: ICerf[] | null;
  countries?: ICountry[] | null;
}

export class Std implements IStd {
  constructor(
    public id?: number,
    public stdNo?: string | null,
    public stdVer?: string | null,
    public name?: string | null,
    public status?: string | null,
    public fee?: number | null,
    public issuDt?: Date | null,
    public expDt?: Date | null,
    public prods?: IProd[] | null,
    public cerfs?: ICerf[] | null,
    public countries?: ICountry[] | null
  ) {}
}
