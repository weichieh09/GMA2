import { IFee } from '@/shared/model/fee.model';
import { ICountry } from '@/shared/model/country.model';
import { IStd } from '@/shared/model/std.model';
import { ISticker } from '@/shared/model/sticker.model';
import { ICerf } from '@/shared/model/cerf.model';

export interface IProd {
  id?: number;
  prodNo?: string | null;
  enName?: string | null;
  chName?: string | null;
  hsCode?: string | null;
  cccCode?: string | null;
  fees?: IFee[] | null;
  countries?: ICountry[] | null;
  stds?: IStd[] | null;
  sticker?: ISticker | null;
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
    public fees?: IFee[] | null,
    public countries?: ICountry[] | null,
    public stds?: IStd[] | null,
    public sticker?: ISticker | null,
    public cerfs?: ICerf[] | null
  ) {}
}
