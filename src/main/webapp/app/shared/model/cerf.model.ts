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
  applId?: number | null;
  fctyId?: number | null;
  mnfctrId?: number | null;
  issuDt?: Date | null;
  expDt?: Date | null;
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
    public applId?: number | null,
    public fctyId?: number | null,
    public mnfctrId?: number | null,
    public issuDt?: Date | null,
    public expDt?: Date | null,
    public prods?: IProd[] | null,
    public stds?: IStd[] | null,
    public country?: ICountry | null
  ) {}
}
