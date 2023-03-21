export interface ICerf2ProdView {
  id?: number;
  cerfNo?: string | null;
  cerfVer?: string | null;
  prodId?: string | null;
  prodNmCh?: string | null;
}

export class Cerf2ProdView implements ICerf2ProdView {
  constructor(
    public id?: number,
    public cerfNo?: string | null,
    public cerfVer?: string | null,
    public prodId?: string | null,
    public prodNmCh?: string | null
  ) {}
}
