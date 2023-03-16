export interface IProd2Std {
  id?: number;
  prodId?: string | null;
  mnfctrId?: string | null;
  stdNo?: string | null;
  stdVer?: string | null;
  stsCd?: string | null;
  lstMtnUsr?: string | null;
  lstMtnDt?: Date | null;
}

export class Prod2Std implements IProd2Std {
  constructor(
    public id?: number,
    public prodId?: string | null,
    public mnfctrId?: string | null,
    public stdNo?: string | null,
    public stdVer?: string | null,
    public stsCd?: string | null,
    public lstMtnUsr?: string | null,
    public lstMtnDt?: Date | null
  ) {}
}
