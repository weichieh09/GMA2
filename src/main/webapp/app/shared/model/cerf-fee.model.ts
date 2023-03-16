export interface ICerfFee {
  id?: number;
  cerfNo?: string | null;
  cerfVer?: string | null;
  cerfTag?: string | null;
  areaCd?: string | null;
  applId?: string | null;
  stsCd?: string | null;
  feeCd?: string | null;
  feeDt?: Date | null;
  fee?: number | null;
  curr?: string | null;
  lstMtnUsr?: string | null;
  lstMtnDt?: Date | null;
}

export class CerfFee implements ICerfFee {
  constructor(
    public id?: number,
    public cerfNo?: string | null,
    public cerfVer?: string | null,
    public cerfTag?: string | null,
    public areaCd?: string | null,
    public applId?: string | null,
    public stsCd?: string | null,
    public feeCd?: string | null,
    public feeDt?: Date | null,
    public fee?: number | null,
    public curr?: string | null,
    public lstMtnUsr?: string | null,
    public lstMtnDt?: Date | null
  ) {}
}
