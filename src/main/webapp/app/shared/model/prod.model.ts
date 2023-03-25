import { IProdFee } from '@/shared/model/prod-fee.model';
import { ICountry } from '@/shared/model/country.model';
import { IStd } from '@/shared/model/std.model';
import { IMark } from '@/shared/model/mark.model';
import { ICerf } from '@/shared/model/cerf.model';

export interface IProd {
  id?: number;
  prodNo?: string | null;
  enName?: string | null;
  chName?: string | null;
  hsCode?: string | null;
  cccCode?: string | null;
  prodFees?: IProdFee[] | null;
  countries?: ICountry[] | null;
  stds?: IStd[] | null;
  marks?: IMark[] | null;
  cerfs?: ICerf[] | null;
}

export class Prod implements IProd {
  constructor(
    public id?: number,
    public prodNo?: string | null,
    public enName?: string | null,
    public chName?: string | null,
    public hsCode?: string | null,
    public cccCode?: string | null,
    public prodFees?: IProdFee[] | null,
    public countries?: ICountry[] | null,
    public stds?: IStd[] | null,
    public marks?: IMark[] | null,
    public cerfs?: ICerf[] | null
  ) {}
}
