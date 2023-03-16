export interface IProd2Cerf {
  id?: number;
  prodId?: string | null;
  mnfctrId?: string | null;
  cerfNo?: string | null;
  cerfVer?: string | null;
  applId?: string | null;
  areaCd?: string | null;
  cerfTag?: string | null;
  stsCd?: string | null;
  lstMtnUsr?: string | null;
  lstMtnDt?: Date | null;
}

export class Prod2Cerf implements IProd2Cerf {
  constructor(
    public id?: number,
    public prodId?: string | null,
    public mnfctrId?: string | null,
    public cerfNo?: string | null,
    public cerfVer?: string | null,
    public applId?: string | null,
    public areaCd?: string | null,
    public cerfTag?: string | null,
    public stsCd?: string | null,
    public lstMtnUsr?: string | null,
    public lstMtnDt?: Date | null
  ) {}
}
