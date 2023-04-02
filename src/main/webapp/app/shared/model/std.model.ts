import { IProdStd } from '@/shared/model/prod-std.model';
import { ICerfStd } from '@/shared/model/cerf-std.model';
import { ICountryStd } from '@/shared/model/country-std.model';

export interface IStd {
  id?: number;
  stdNo?: string | null;
  stdVer?: string | null;
  enName?: string | null;
  chName?: string | null;
  status?: string | null;
  issuDt?: Date | null;
  expDt?: Date | null;
  prodStds?: IProdStd[] | null;
  cerfStds?: ICerfStd[] | null;
  countryStds?: ICountryStd[] | null;
}

export class Std implements IStd {
  constructor(
    public id?: number,
    public stdNo?: string | null,
    public stdVer?: string | null,
    public enName?: string | null,
    public chName?: string | null,
    public status?: string | null,
    public issuDt?: Date | null,
    public expDt?: Date | null,
    public prodStds?: IProdStd[] | null,
    public cerfStds?: ICerfStd[] | null,
    public countryStds?: ICountryStd[] | null
  ) {}
}
