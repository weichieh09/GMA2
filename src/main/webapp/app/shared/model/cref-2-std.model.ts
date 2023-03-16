export interface ICref2Std {
  id?: number;
  cerfNo?: string | null;
  cerfVer?: string | null;
  areaCd?: string | null;
  applId?: string | null;
  cerfTag?: string | null;
  stdNo?: string | null;
  stdVer?: string | null;
  stsCd?: string | null;
  lstMtnUsr?: string | null;
  lstMtnDt?: Date | null;
}

export class Cref2Std implements ICref2Std {
  constructor(
    public id?: number,
    public cerfNo?: string | null,
    public cerfVer?: string | null,
    public areaCd?: string | null,
    public applId?: string | null,
    public cerfTag?: string | null,
    public stdNo?: string | null,
    public stdVer?: string | null,
    public stsCd?: string | null,
    public lstMtnUsr?: string | null,
    public lstMtnDt?: Date | null
  ) {}
}
