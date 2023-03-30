import { IProd } from '@/shared/model/prod.model';
import { ICerf } from '@/shared/model/cerf.model';
import { ICompany } from '@/shared/model/company.model';

export interface IFee {
  id?: number;
  fee?: number | null;
  feeType?: string | null;
  feeDt?: Date | null;
  prod?: IProd | null;
  cerf?: ICerf | null;
  company?: ICompany | null;
}

export class Fee implements IFee {
  constructor(
    public id?: number,
    public fee?: number | null,
    public feeType?: string | null,
    public feeDt?: Date | null,
    public prod?: IProd | null,
    public cerf?: ICerf | null,
    public company?: ICompany | null
  ) {}
}
