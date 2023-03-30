import { IProd } from '@/shared/model/prod.model';
import { IMark } from '@/shared/model/mark.model';

export interface ISticker {
  id?: number;
  stickerNo?: string | null;
  imgContentType?: string | null;
  img?: string | null;
  prods?: IProd[] | null;
  marks?: IMark[] | null;
}

export class Sticker implements ISticker {
  constructor(
    public id?: number,
    public stickerNo?: string | null,
    public imgContentType?: string | null,
    public img?: string | null,
    public prods?: IProd[] | null,
    public marks?: IMark[] | null
  ) {}
}
