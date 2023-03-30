import { IMark } from '@/shared/model/mark.model';
import { IProd } from '@/shared/model/prod.model';

export interface ISticker {
  id?: number;
  stickerNo?: string | null;
  imgContentType?: string | null;
  img?: string | null;
  marks?: IMark[] | null;
  prod?: IProd | null;
}

export class Sticker implements ISticker {
  constructor(
    public id?: number,
    public stickerNo?: string | null,
    public imgContentType?: string | null,
    public img?: string | null,
    public marks?: IMark[] | null,
    public prod?: IProd | null
  ) {}
}
