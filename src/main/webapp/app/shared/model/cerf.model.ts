import { ICerfCompany } from '@/shared/model/cerf-company.model';
import { IFee } from '@/shared/model/fee.model';
import { IMark } from '@/shared/model/mark.model';
import { IProd } from '@/shared/model/prod.model';
import { IStd } from '@/shared/model/std.model';
import { ICountry } from '@/shared/model/country.model';

export interface ICerf {
  id?: number;
  cerfNo?: string | null;
  cerfVer?: string | null;
  status?: string | null;
  pdfContentType?: string | null;
  pdf?: string | null;
  issuDt?: Date | null;
  expDt?: Date | null;
  cerfCompanies?: ICerfCompany[] | null;
  fees?: IFee[] | null;
  marks?: IMark[] | null;
  prods?: IProd[] | null;
  stds?: IStd[] | null;
  country?: ICountry | null;
}

export class Cerf implements ICerf {
  constructor(
    public id?: number,
    public cerfNo?: string | null,
    public cerfVer?: string | null,
    public status?: string | null,
    public pdfContentType?: string | null,
    public pdf?: string | null,
    public issuDt?: Date | null,
    public expDt?: Date | null,
    public cerfCompanies?: ICerfCompany[] | null,
    public fees?: IFee[] | null,
    public marks?: IMark[] | null,
    public prods?: IProd[] | null,
    public stds?: IStd[] | null,
    public country?: ICountry | null
  ) {}
}
