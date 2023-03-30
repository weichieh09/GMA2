import { ICountry } from '@/shared/model/country.model';
import { ICerf } from '@/shared/model/cerf.model';
import { ISticker } from '@/shared/model/sticker.model';

export interface IMark {
  id?: number;
  markNo?: string | null;
  enName?: string | null;
  chName?: string | null;
  imgContentType?: string | null;
  img?: string | null;
  country?: ICountry | null;
  cerf?: ICerf | null;
  sticker?: ISticker | null;
}

export class Mark implements IMark {
  constructor(
    public id?: number,
    public markNo?: string | null,
    public enName?: string | null,
    public chName?: string | null,
    public imgContentType?: string | null,
    public img?: string | null,
    public country?: ICountry | null,
    public cerf?: ICerf | null,
    public sticker?: ISticker | null
  ) {}
}
