export interface IStdFee {
  id?: number;
  prodId?: string | null;
  mnfctrId?: string | null;
  stdNo?: string | null;
  stdVer?: string | null;
  stsCd?: string | null;
  feeCd?: string | null;
  feeDt?: Date | null;
  fee?: number | null;
  curr?: string | null;
  lstMtnUsr?: string | null;
  lstMtnDt?: Date | null;
}

export class StdFee implements IStdFee {
  constructor(
    public id?: number,
    public prodId?: string | null,
    public mnfctrId?: string | null,
    public stdNo?: string | null,
    public stdVer?: string | null,
    public stsCd?: string | null,
    public feeCd?: string | null,
    public feeDt?: Date | null,
    public fee?: number | null,
    public curr?: string | null,
    public lstMtnUsr?: string | null,
    public lstMtnDt?: Date | null
  ) {}
}
