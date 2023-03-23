import { ICountry } from '@/shared/model/country.model';
import { IStd } from '@/shared/model/std.model';
import { IMark } from '@/shared/model/mark.model';
import { ICerf } from '@/shared/model/cerf.model';

export interface IProd {
  id?: number;
  prodNo?: string | null;
  name?: string | null;
  hsCode?: string | null;
  cccCode?: string | null;
  countries?: ICountry[] | null;
  stds?: IStd[] | null;
  marks?: IMark[] | null;
  cerfs?: ICerf[] | null;
}

export class Prod implements IProd {
  constructor(
    public id?: number,
    public prodNo?: string | null,
    public name?: string | null,
    public hsCode?: string | null,
    public cccCode?: string | null,
    public countries?: ICountry[] | null,
    public stds?: IStd[] | null,
    public marks?: IMark[] | null,
    public cerfs?: ICerf[] | null
  ) {}
}
