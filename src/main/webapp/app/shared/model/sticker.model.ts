import { IStickerMark } from '@/shared/model/sticker-mark.model';
import { IProdSticker } from '@/shared/model/prod-sticker.model';

export interface ISticker {
  id?: number;
  stickerNo?: string | null;
  imgContentType?: string | null;
  img?: string | null;
  stickerMarks?: IStickerMark[] | null;
  prodStickers?: IProdSticker[] | null;
}

export class Sticker implements ISticker {
  constructor(
    public id?: number,
    public stickerNo?: string | null,
    public imgContentType?: string | null,
    public img?: string | null,
    public stickerMarks?: IStickerMark[] | null,
    public prodStickers?: IProdSticker[] | null
  ) {}
}
