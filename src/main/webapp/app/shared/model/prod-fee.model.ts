import { IProd } from '@/shared/model/prod.model';

export interface IProdFee {
  id?: number;
  fee?: number | null;
  feeType?: string | null;
  prod?: IProd | null;
}

export class ProdFee implements IProdFee {
  constructor(public id?: number, public fee?: number | null, public feeType?: string | null, public prod?: IProd | null) {}
}
