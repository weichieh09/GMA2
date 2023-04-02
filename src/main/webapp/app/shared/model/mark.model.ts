import { ICerfMark } from '@/shared/model/cerf-mark.model';
import { IStickerMark } from '@/shared/model/sticker-mark.model';
import { ICountryMark } from '@/shared/model/country-mark.model';

export interface IMark {
  id?: number;
  markNo?: string | null;
  enName?: string | null;
  chName?: string | null;
  imgContentType?: string | null;
  img?: string | null;
  cerfMarks?: ICerfMark[] | null;
  stickerMarks?: IStickerMark[] | null;
  countryMarks?: ICountryMark[] | null;
}

export class Mark implements IMark {
  constructor(
    public id?: number,
    public markNo?: string | null,
    public enName?: string | null,
    public chName?: string | null,
    public imgContentType?: string | null,
    public img?: string | null,
    public cerfMarks?: ICerfMark[] | null,
    public stickerMarks?: IStickerMark[] | null,
    public countryMarks?: ICountryMark[] | null
  ) {}
}
