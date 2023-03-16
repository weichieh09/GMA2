export interface IProd {
  id?: number;
  prodId?: string | null;
  mnfctrId?: string | null;
  prodNmCh?: string | null;
  prodNmEn?: string | null;
  hsCd?: string | null;
  cccCd?: string | null;
  lstMtnUsr?: string | null;
  lstMtnDt?: Date | null;
}

export class Prod implements IProd {
  constructor(
    public id?: number,
    public prodId?: string | null,
    public mnfctrId?: string | null,
    public prodNmCh?: string | null,
    public prodNmEn?: string | null,
    public hsCd?: string | null,
    public cccCd?: string | null,
    public lstMtnUsr?: string | null,
    public lstMtnDt?: Date | null
  ) {}
}
