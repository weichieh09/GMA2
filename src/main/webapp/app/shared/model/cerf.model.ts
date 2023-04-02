import { ICerfProd } from '@/shared/model/cerf-prod.model';
import { ICerfStd } from '@/shared/model/cerf-std.model';
import { ICerfMark } from '@/shared/model/cerf-mark.model';
import { ICerfCompany } from '@/shared/model/cerf-company.model';
import { IFeeProdCerfCompany } from '@/shared/model/fee-prod-cerf-company.model';
import { ICountryCert } from '@/shared/model/country-cert.model';

export interface ICerf {
  id?: number;
  cerfNo?: string | null;
  cerfVer?: string | null;
  status?: string | null;
  pdfContentType?: string | null;
  pdf?: string | null;
  issuDt?: Date | null;
  expDt?: Date | null;
  cerfProds?: ICerfProd[] | null;
  cerfStds?: ICerfStd[] | null;
  cerfMarks?: ICerfMark[] | null;
  cerfCompanies?: ICerfCompany[] | null;
  feeProdCerfCompanies?: IFeeProdCerfCompany[] | null;
  countryCerts?: ICountryCert[] | null;
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
    public cerfProds?: ICerfProd[] | null,
    public cerfStds?: ICerfStd[] | null,
    public cerfMarks?: ICerfMark[] | null,
    public cerfCompanies?: ICerfCompany[] | null,
    public feeProdCerfCompanies?: IFeeProdCerfCompany[] | null,
    public countryCerts?: ICountryCert[] | null
  ) {}
}
