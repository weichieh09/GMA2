import { ICerfCompany } from '@/shared/model/cerf-company.model';
import { IFee } from '@/shared/model/fee.model';

export interface ICompany {
  id?: number;
  companyNo?: string | null;
  enName?: string | null;
  chName?: string | null;
  tel?: string | null;
  addr?: string | null;
  email?: string | null;
  cerfCompanies?: ICerfCompany[] | null;
  fees?: IFee[] | null;
}

export class Company implements ICompany {
  constructor(
    public id?: number,
    public companyNo?: string | null,
    public enName?: string | null,
    public chName?: string | null,
    public tel?: string | null,
    public addr?: string | null,
    public email?: string | null,
    public cerfCompanies?: ICerfCompany[] | null,
    public fees?: IFee[] | null
  ) {}
}
